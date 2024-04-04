package huntthewumpus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author natal
 */
public class Labyrinth {
    //Para que solo se pueda acceder a el en esta clase
    private static Scanner sc= new Scanner(System.in);
    private List<Cave> caves;
    private final int minConex=3;//Conexiones mínimas entre las cuevas.
    private final int maxConex=4;//Conexiones máximas entre las cuevas.
    private Level level;
    private Player[] player;
    private int idWumpus;//Caverna en la que estará Wumpus.
    
    public Labyrinth (Level level, Player[] player){
        this.player=player;
        this.level=level;
        caves= new ArrayList<Cave>();
        createCaves();
        sortCaves();
        conectCaves();
    }

    public List<Cave> getCaves() {
        return caves;
    }
    
    /**
     * Método para iniciar el juego.
     */
    public void startGame(){
        boolean endGame=false;
        int posActual=0;
        String answer;
        String name;
        int action=0;//Número de caverna en el que se realizará la acción.
        boolean correctAction;//Para saber si se disparó o se movió 
                              //a una caverna correcta.
        int dieCont=0;//Contador de jugadores muertos.

        while(endGame==false){//Mientras no se haya terminado el juego.
            //Para indicar el número de cada jugador.
            for(int i=0; i<player.length; i++){
                if(player[i].isLive()){
                    dieCont=0;
                    //Se obtiene la posición del jugador.
                    posActual=player[i].getPosActual();
                    //Se obtiene el nombre de la caverna en la que 
                    //esta el jugador.
                    name=caves.get(posActual).getName();
                    player[i].actualCave(posActual,name);
                    System.out.println();
                    for(int j=0; j<caves.get(posActual).getConections()
                            .size(); j++){
                        System.out.print(caves.get(caves.get(posActual).
                            getConections().get(j)));
                    }//Se obtienen y se imprimen todas las cavernas con las que
                    //se tienen conexión.
                    System.out.print("Hay salidas hacias las cavernas: ");
                    //Se deja espacio entre cada caverna para poder 
                    //diferenciarlas.
                    for(int j=0; j<caves.get(posActual).getConections().
                            size(); j++){
                        System.out.print(caves.get(posActual).getConections()
                            .get(j)+"  ");
                    }

                    do{
                        try{//Se le pregunta la acción a realizar.
                            System.out.print("\n¿Quieres avanzar(a) o "
                                    + "disparar(d)?: ");
                            answer= sc.nextLine();
                            //Si elige avanzar se le pregunta hacia que caverna.
                            if(answer.toLowerCase().equals("a")){//Para avanzar.
                                System.out.print("¿Hacia que caverna quiere"
                                        + " avanzar?: ");
                                action= sc.nextInt();//el número ingresado se 
                                                     //guarda en action.
                            //Para disparar
                            }else if(answer.toLowerCase().equals("d")){
                                System.out.print("¿Hacia que caverna quiere "
                                        + "disparar?: ");
                                action= sc.nextInt();//el número ingresado se 
                                                     //guarda en action.
                            }else{
                                System.out.println("Opción incorrecta");
                                continue;//si la opción es incorrecta se vuelve
                                //a preguntar al usuario si desea avanzar o
                                //disparar 
                            }

                            correctAction=false;
                            //Se compara el dato ingresado para comprobar si se 
                            //ingresó una caverna correcta 
                            //(correspondiente a las que se le mostraron al 
                            //jugador).
                            for(int k=0; k< caves.get(posActual).getConections
                                ().size(); k++){
                                if(caves.get(posActual).getConections().
                                    get(k)==action){//Disparo a una caverna
                                                    //correcta.
                                    correctAction=true;
                                    break;
                                }
                            }//Si no corresponden, se le muestra el 
                             //siguiente mensaje y se le vuelve a preguntar 
                             //si quiere avanzar o disparar.
                            if(correctAction==false){
                                System.out.println("Seleccione una caverna "
                                        + "correcta");
                                sc.nextLine();
                            }else{//Si el jugador elige avanzar, se guarda la 
                                  //caverna ingresada en action.
                                if(answer.toLowerCase().equals("a")){
                                    //el jugador se mueve a la caverna
                                    //correspondiente.
                                    player[i].move(action);
                                    //se obtiene la habilidad de la caverna
                                    //(en caso de que sea una caverna especial).
                                    caves.get(action).abilityCave(player[i]);
                                    //Se revisa si el jugador ganó el juego.
                                    checkWinGame(i);
                                    if(player[i].isWinGame()){
                                        //Se termina el juego, hay un ganador.
                                        System.out.println("\n¡El jugador "+ 
                                                player[i].getName()
                                                +" ganó la partida!");
                                        endGame=true;
                                        break;
                                    }
                                    //Se muestra la catnidad de oxígeno y
                                    //la cantidad de flechas.
                                    player[i].actualOxygen();
                                    player[i].actualArrows();
                                    System.out.println("----------------------"
                                            + "-------------------------------"
                                            + "----------");
                                    sc.nextLine();
                                    break;
                                }else{
                                    //Si se mueve o dispara a la Cueva
                                    //en donde esta Wumpus.
                                    if(caves.get(action).getId()==idWumpus){
                                        WumpusCave m= (WumpusCave)caves.get
                                            (action);
                                        //Si Wumpus esta en la cueva...
                                        if(m.isWumpusExist()){
                                            //se cambia el estado de Wumpus en
                                            //caso de que el jugador haya 
                                            //disparado a la caverna en donde 
                                            //se ecnontraba Wumpus.
                                            m.changeWumpusState();
                                            player[i].shoot(action,true);
                                        }else{
                                            player[i].shoot(action,false);
                                        }
                                    }else{
                                        player[i].shoot(action,false);
                                    }
                                    
                                    player[i].actualOxygen();
                                    player[i].actualArrows();
                                    System.out.println("--------"
                                            + "-------------------------------"
                                            + "------------------------");
                                    sc.nextLine();
                                }  
                            }
                        }catch(Exception ex){
                            System.out.println("Tipo de dato ingresado "
                                    + "incorrecto, ingrese nuevamente: ");
                            sc.nextLine();
                        }
                    }while(true);
                }else{
                    dieCont++;//Se suma 1 a al contador de muertos.
                }
                
                if(endGame) break;
                //Si el contador de muertos es igual a la cantidad de jugadores, 
                //el juego se termina. 
                if(dieCont==player.length){
                    System.out.println("\nEL juego terminó, "
                            + "no hubo ganadores");
                    endGame=true;
                    break;
                }
            }
        }
    }
    /**
     * Método para revisar si un jugador ganó el juego.
     * @param actualPlayer 
     */
    private void checkWinGame(int actualPlayer){
        if(player[actualPlayer].isLive() && player//Si el jugador esta vivo.
                [actualPlayer].getNumOxygen()>0){//Si el jugador tiene oxígeno.
            if(player[actualPlayer].isBagHuntWumpus() && player
                    [actualPlayer].getPosActual()==0){
                //Si el jugador atrapó a Wumpus y lo llevó al campamento
                //significa que ganó el juego.
                player[actualPlayer].winGame();
            }
        }else{//El jugador esta muerto
              //Se comprueba si tenia a Wumpus en el saco
              //Si tenía a Wumpus, Wumpus se libera.
            if(player[actualPlayer].isBagHuntWumpus()){
                player[actualPlayer].looseWumpus();
                for(int i=0; i<caves.size(); i++){
                    if(caves.get(i).getId()==idWumpus){
                        //Se devuelve a Wumpus al laberinto y se 
                        //cambia su estado a despierto.
                        WumpusCave m= (WumpusCave)caves.get(i);
                        m.changeWumpusState();
                        m.changeWumpusExist();
                        break;
                    }
                }
            } 
        }
    }
    
    /**
     * Método para crear cavernas.
     */
    private void createCaves(){
        int i=0;
        int numAlea;//número aleatorio.
        int[] cantCaves= level.getNumbersCaves();//Se guardan las cantidades de
                                           //cada tipo de caverna del laberinto.
        //Se crea una lista de los números usados en en el laberinto.
        List<Integer> usedNumbers= new ArrayList<Integer>();
        caves.add(new CampCave(0,"Campamento"));//Por defecto el campamento 
                                                //tiene le valor de 0.
        
        for(int k=0; k<cantCaves.length; k++){//Se crean las cavernas 
                                              //correspondientes a la cantidad 
                                              //de cada tipo.
            i=0;
            while(i<cantCaves[k]){//El ciclo para hasta que se completen 
                                  //todos los tipos de caverna.
                //Devuelve un número aleatorio dependiendo de la cantidad de 
                //cavernas según el nivel correspondiente.
                numAlea=(int)(Math.random()*level.getNumCaves()+1);

                if(!searchAlea(numAlea,usedNumbers)){//Se agregan y se crean.
                    selectCave(numAlea,(k+1));
                    usedNumbers.add(numAlea);
                    i++;
                }
            }
        }
    }
    /**
     * Método para agregar y nombrar a cada tipo de caverna.
     * @param id
     * @param op 
     */
    private void selectCave(int id, int op){
        switch(op){
            case 1: 
                caves.add(new WumpusCave(id,"Caverna Wumpus"));
                idWumpus=id;//Se guarda el número de la caverna en la que esta 
                            //Wumpus.
                break;
            case 2: caves.add(new PitCave(id,"Caverna con Pozo sin fondo"));
                    break;
            case 3: caves.add(new BatCave(id,"Caverna con Murciélagos "
                    + "gigantes",caves)); break;
            case 4: caves.add(new WaterCave(id,"Caverna con agua")); break;
            case 5: caves.add(new OxygenCave(id,"Caverna con tanque de "
                    + "oxígeno")); break;
            case 6: caves.add(new ChallengeCave(id,"Caverna con desafío"
                    ,this.level)); break;
            case 7: caves.add(new NormalCave(id,"Caverna normal")); break;
        }
    }
    /**
     * Método para buscar un número aleatorio en la lista de números
     * usados en el laberinto.
     * @param num
     * @param usedNumbers
     * @return 
     */
    private boolean searchAlea(int num,List<Integer> usedNumbers){
        for(int j=0; j<usedNumbers.size(); j++){
            if(usedNumbers.get(j)==num){
                return true;
           }
        }
        return false;
    }
    
    /**
     * Método para ordenar las cavernas.
     */
    private void sortCaves(){
        Cave aux;
        for(int i=0; i<caves.size()-1; i++){
            //Suma de las cavernas.
            for(int j=i+1; j<caves.size(); j++){
                if(caves.get(i).getId()>=caves.get(j).getId()){
                    aux=caves.get(i);
                    caves.set(i, caves.get(j));
                    caves.set(j, aux);
                }
            }
        }
    }
    
    /**
     * Método para establecer las conexiones entre las cavernas.
     */
    private void conectCaves(){
        int numAlea;
        int cantConections;//Cantidad de conexiones.

        for(int i=0; i<caves.size();i++){
            cantConections=caves.get(i).getConections().size();
            if(cantConections<minConex){//Hasta que la cantidad de conexiones
                                        //sea mayor a 3.
                numAlea=((int)(Math.random()*(maxConex+1-minConex))
                        +minConex)-cantConections;
                for(int j=0; j<numAlea; j++){
                    if(!addAdditional(i, minConex)){
                        addAdditional(i, maxConex);
                    }
                }
            }   
        }
    }
    
    /**
     * Método para comprobar si se necesita agregar una conexión más a un grupo
     * de cavernas conectadas.
     * @param i
     * @param cant
     * @return 
     */
    private boolean addAdditional(int i, int cant){
        int positionCave=0;
        boolean exist;
        int cont=0;
        while(true){
            positionCave=(int)(Math.random()*(level.getNumCaves()));
            if(caves.get(positionCave).getConections().size()<cant &&
                    positionCave!=i){//Conectar las cavernas 
                exist =false;
                for(int k=0; k<caves.get(i).getConections().size();k++){
                    if(caves.get(i).getConections().get(k)==positionCave){
                        exist=true;
                        break;
                    }
                }
                if(!exist){
                    caves.get(i).setConect(positionCave);
                    caves.get(positionCave).setConect(i);
                    return true;
                }                           
            }else{
                cont++;
            }
            if(cont==100) return false;
        }
    }
}
