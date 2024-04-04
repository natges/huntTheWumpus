package huntthewumpus;

/**
 *
 * @author natal
 */
public class OxygenCave extends Cave{
    private boolean oxygen;//Para saber si hay o no hay oxígeno. 
    public OxygenCave(int id, String name) {
        super(id, name);
        oxygen=true;
    }
    
    @Override
    public String toString() {
        return "";
    }

    @Override
    /**
     * Realiza la acción correspondiente a dicha cueva (aumentar en 20 la 
     * cantidad de oxígeno).
     */
    public void abilityCave(Player j) {
        if(oxygen){
            j.increaseOxygen(20); //Aumenta en 20 la cantidad de oxígeno.
            oxygen=false;
            System.out.println("\u001B[46m¡Has caido en una caverna de oxigeno! "
                    + "Se siente bien respirar\u001B[0m\n");
        }
    }
}
