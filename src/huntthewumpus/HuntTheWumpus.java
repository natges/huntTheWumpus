package huntthewumpus;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author natal
 */
public class HuntTheWumpus {
    //Se declara y se crea un objeto scanner
    static Scanner sc= new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player[] players;//Jugadores en el juego.
        NumLevel level;//Nivel seleccionado
        int numPlayers;//Número de jugadores
        String answer;
        boolean out=false;//Para salir del juego.
        
        //Lore.
        System.out.println(" Wumpus es un robot con inteligencia artificial,"
                + "diseñado específicamente para enseñar Programación "
                + "Orientada a Objetos a los alumnos\n de la Universidad "
                + "TecMilenio. Sin embargo, Wumpus ha tomado la decisión de"
                + " huir después de que los alumnos de TecMilenio hayan\n"
                + " fallado con la entrega del proyecto final del semestre. "
                + "Se dice que está escondido en un laberinto bajo tierra"
                + " a las afueras de la ciudad\n de Monterrey, tu trabajo es"
                + " adentrarte al laberinto, atrapar a Wumpus y "
                + " volver con él al campamento sin morir en el intento.\n"
                + " Te advertimos que debes tener cuidado, dentro del "
                + "laberinto te encontraras con pozos sin fondo, "
                + "cavernas de agua,\n"
                + " cavernas con murciélagos gigantes y cavernas con desafíos. "
                + "No descuides tu oxígeno ni tus flechas, y no olvides dormir "
                + "a Wumpus antes de atraparlo."
                + "\n ¡Que comience el juego!");
        System.out.println("                                               ");
     	System.out.println("\nPRESIONE ENTER PARA CONTINUAR..."); 
    	sc.nextLine(); //El programa se detiene hasta que se pulse ENTER
        
        do{ //Se elige el nivel de juego junto con la cantidad de jugadores.
            level=chooseLevel();
            numPlayers=chooseNumPlayers();
            players= new Player[numPlayers];
            sc.nextLine();
            for(int i=0; i<numPlayers; i++){
                System.out.print("Ingrese el nombre del jugador "+(i+1)+": ");
                players[i]= new Player(level, sc.nextLine());
            }

            Labyrinth labyrinth= new Labyrinth(new Level(level),players);
            labyrinth.startGame();//El juego comienza.
            do{
                System.out.print("¿Desea jugar de nuevo s/n?: ");
                answer=sc.nextLine();
                if(answer.toLowerCase().equals("s")){
                    System.out.println("\n");
                    break;
                }else if(answer.toLowerCase().equals("n")){
                    System.out.println("Ha salido del juego\n");
                    out=true;
                    break;
                }else{
                    System.out.println("Opción incorrecta, "
                            + "ingrese nuevamente: ");
                }
            }while(true);
        }while(out==false);//El juego vuelve a comenzar. 
    }
    
    /**
     * Método para elegir el nivel del juego.
     * @return 
     */
    public static NumLevel chooseLevel(){
        int op;
        do{
            try{
                System.out.println("SELECCIONE UN NIVEL");
                System.out.println("1.- Nivel Fácil");
                System.out.println("2.- Nivel Medio");
                System.out.println("3.- Nivel Avanzado");
                System.out.print("Seleccione un nivel: ");
                op=sc.nextInt();
                
                switch(op){
                    case 1: return NumLevel.UNO;
                    case 2: return NumLevel.DOS;
                    case 3: return NumLevel.TRES;
                    default:
                        System.out.println("Opción incorrecto, ingrese "
                            + "nuevamente\n");
                        break;
                }
            }catch(Exception ex){//Por si ingresa un tipo de dato o
                                 //un número diferente a 1, 2 o 3.
                System.out.println("Tipo de dato ingresado incorrecto, ingrese "
                        + "nuevamente\n");
                sc.nextLine();
            }            
        }while(true);
    }
    
    
    /**
     * Método para elegir al número de jugadores.
     * @return 
     */
    public static int chooseNumPlayers(){
        int num;
        do{
            try{
                System.out.print("Seleccione número de jugadores (1-4): ");
                num=sc.nextInt();
                if(num<1 || num>4){
                    System.out.println("El número de jugadores es de (1-4)");
                }else return num;             
            }catch(Exception ex){
                System.out.println("Tipo de dato ingresado incorrecto, ingrese "
                        + "nuevamente\n");
                sc.nextLine();
            }            
        }while(true);
    }
    
}
