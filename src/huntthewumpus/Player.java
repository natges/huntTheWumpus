package huntthewumpus;

/**
 *
 * @author natal
 */
public class Player {
    private String name;
    private int numArrows;//Cantidad de flechas.
    private int numOxygen;//Cantidad de oxígeno.
    private NumLevel numLevel;
    private static int maxOxygen;//Oxígeno máximo que llega a tener el jugador
                                 //al inicio del juego.
    private int posActual;//Posición actual del jugador.
    private boolean winGame;//Si el jugador gano o no el juego.
    private boolean live;//Si el jugador esta vivo.
    private boolean bagHuntWumpus;//Si dentro del saco tiene o no 
                                  //tiene a Wumpus.
    
    public Player(NumLevel numLevel, String name){
        this.name=name;
        this.numLevel=numLevel;
        initializeComponents();
        posActual=0;
        winGame=false;
        live=true;
        bagHuntWumpus=false;
    }

    public String getName() {
        return name;
    }

    public int getPosActual() {
        return posActual;
    }

    public static int getMaxOxygen() {
        return maxOxygen;
    }
    
    public boolean isBagHuntWumpus() {
        return bagHuntWumpus;
    }
    
    /**
     * Método para indicar que el juego se ganó.
     */
    public void winGame(){
        winGame=true;
    }

    public boolean isWinGame() {
        return winGame;
    }

    public int getNumOxygen() {
        return numOxygen;
    }
    
    /**
     * Método para indicar que el jugador murió.
     */
    public void die(){
        live=false;
    }

    public boolean isLive() {
        return live;
    }
    
    /**
     * Método para indicar que el jugador atrapó a Wumpus.
     */
    public void huntWumpus(){
        bagHuntWumpus=true;
    }
    
    /**
     * Método para indicar que Wumpus se libera del saco del jugador.
     */
    public void looseWumpus(){
        bagHuntWumpus=false;
    }
    
    /**
     * Método para inicializar la cantidad de oxígeno y la cantidad de flechas
     * correspondientes al nivel que eligió el jugador.
     */
    public void initializeComponents(){
        if(numLevel.name().equals(NumLevel.UNO.name())){//Nivel facil.
            numArrows=10;
        }else if(numLevel.name().equals(NumLevel.DOS.name())){//Nivel medio.
            numArrows=8;
        }else{//Nivel avanzado.
            numArrows=5;
        }
        numOxygen=50;
        maxOxygen=numOxygen;
    }
    
    /**
     * Método para disparar a Wumpus y dormirlo.
     * @param pos
     * @param exist 
     */
    public void shoot(int pos,boolean exist){ 
        if(numArrows==0){
            System.out.println("El jugador no tiene flechas\n");
        }else{
            System.out.println("Se ha disparado a la caverna número "+pos);
            if(!exist){//Si Wumpus no esta en la caverna el jugador 
                       //únicamente pierde su flecha.
                numArrows-=1;
            }else{//Si Wumpus esta en la caverna se muestra el siguiente
                  //mensaje:
                System.out.println("\033[32m¡Alguien está tomando una siesta!"
                        + "\u001B[0m\n ");
                numArrows-=1;
            } 
        }
    }
    
    /**
     * Método para indicar la cantidad de flechas disponibles.
     */
    public void actualArrows(){
        System.out.println("Flechas Disponibles: "+numArrows);
    }
    
    /**
     * Método para indicar la cantidad de oxígeno disponible.
     */
    public void actualOxygen(){
        System.out.println("Oxígeno disponible: "+numOxygen);
    }
    
    /**
     * Método para disminuir el oxígeno.
     * @param num 
     */
    public void reduceOxygen(int num){
        if(numOxygen-num<=0){
            numOxygen=0;//Si la cantidad de oxígeno es menor o igual a 0
            live=false; //significa que el jugador no tiene oxígeno, por ende 
                        //esta muerto.
        }
        numOxygen-=num;//Se resta la cantidad de oxígeno correspondiente.
    }
    
    /**
     * Método para aumentar el oxígeno.
     * @param num 
     */
    public void increaseOxygen(int num){
       numOxygen+=num;//Se suma la cantidad de oxígeno correspondiente.
    }
    
    /**
     * Método que indica el movimiento del jugador hacia otra caverna.
     * @param pos 
     */
    public void move(int pos){
        posActual=pos;
        numOxygen--;//Se resta 1 a la cantidad de oxígeno cada que
                    //el jugador se mueve.
        if(numOxygen<0) {
           numOxygen=0;
           live=false;
        }
    }
    
    /**
     * Método que muestra la posición actual del jugador, junto con la cantidad
     * de flechas y oxígeno que tiene disponible.
     * @param pos
     * @param caveName 
     */
    public void actualCave(int pos,String caveName){
        System.out.println("\n"+name+ " estas en la cueva "+ pos+" - "
                +caveName+"\nOxígeno Disponible: " + this.numOxygen+
                "\nFlechas disponibles: "+this.numArrows);
    }
 
}
