package huntthewumpus;

/**
 *
 * @author natal
 */
public class WumpusCave extends Cave{
    private boolean wumpusState;//Para saber si Wumpus esta despierto o dormido.
    private boolean wumpusExist;//Para saber si Wumpus esta o no en su cueva.
    public WumpusCave(int id, String name) {
        super(id, name);
        wumpusState=true;//Wumpus esta despierto.
        wumpusExist=true;//Wumpus esta en la cueva.
    }
    /**
     * Método para cambiar el estado de Wumpus, es decir,
     * para modificar si esta o no despierto.
     */
    public void changeWumpusState(){
        if(wumpusState) wumpusState=false;
        else wumpusState=true;
    }
    
    /**
     * Método para cambiar el estado de la cueva de Wumpus, es decir, 
     * si esta o no dentro de la cueva.
     */
    public void changeWumpusExist(){
        if(wumpusExist) wumpusExist=false;
        else wumpusExist=true;
    }
    
    /**
     * Método para saber si Wumpus esta dormido o despierto.
     * @return 
     */
    public boolean isWumpusState() {
        return wumpusState;
    }
    /**
     * Método para saber si Wumpus esta o no dentro de la cueva.
     * @return 
     */
    public boolean isWumpusExist() {
        return wumpusExist;
    }

    
    @Override
    /**
     * Método para que se realicen las acciones correspondientes de 
     * la WumpusCave (que el jugador atrape a Wumpus si es que esta dormido, 
     * o que Wumpus mate al jugador si es que esta despierto.
     */
    public void abilityCave(Player j) {
        if(j.isBagHuntWumpus()==true){
            //Si el jugador tiene a Wumpus en el saco,
            //significa que ya lo atrapó.
            System.out.println("\033[32m¡Ya atrapaste a Wumpus!\u001B[0m\n");
        }else{
            if(wumpusExist){//Si Wumpus aún esta en la cueva.
                if(wumpusState){//Si Wumpus esta despieto, el jugador muere.
                    j.die();//Método para que el jugador muera.
                    System.out.println("¡Wumpus está despierto y "
                            + "te ha asesinado , has perdido la partida:(\n");
                }
                else{//Si Wumpus esta dormido, el jugador atrapa a Wumpus.
                    j.huntWumpus();//Método para que el jugador atrape a Wumpus.
                    wumpusExist=false;//Wumpus ya no esta en la cueva.
                    System.out.println("\033[32m¡Atrapaste a Wumpus, "
                            + "regresa al campamento!\u001B[0m\n");
                }
            }else{ //Si el jugador no tiene a Wumpus en el saco, 
                //y Wumpus no esta en la cueva, significa que otro jugador
                //ya atrapó a Wumpus.
                System.out.println("\033[32m¡Alguien ya atrapó a Wumpus!"
                        + "\u001B[0m\n");
            }
        }
    }
    

    @Override
    /**
     * Método para mostrar la alerta correspondiente.
     */
    public String toString() {//Alerta en verde.
        return "\033[32mHuele a Wumpus.\u001B[0m\n";
    }   
}
