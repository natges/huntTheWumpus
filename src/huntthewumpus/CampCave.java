package huntthewumpus;

/**
 *
 * @author natal
 */
public class CampCave extends Cave{
    public CampCave(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    /**
     * Realiza la habilidad correspondiente a la cueva (inicializar el oxígeno).
     */
    public void abilityCave(Player j) {
        if(j.getNumOxygen()<Player.getMaxOxygen()){
            j.increaseOxygen(Player.getMaxOxygen()-j.getNumOxygen());
        }
        if (j.isBagHuntWumpus()==true){
            System.out.println("\033[32m¡Lo has conseguido!\u001B[0m\n");
        }else{
            System.out.println("\033[32m¡Nada mejor como sentirse a salvo!"
                    + "\u001B[0m\n");
        }
    }
}
