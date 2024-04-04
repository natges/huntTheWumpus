package huntthewumpus;
/**
 *
 * @author natal
 */
public class WaterCave extends Cave{
    
    public WaterCave(int id, String name) {
        super(id, name);
    }
    
    @Override
    /**
     * Método para mostrar la alerta correspondiente.
     */
    public String toString() {//Texto en azul.
        return "\033[34mSe escucha agua cerca.\u001B[0m\n";
    }

    @Override
    /**
     * Método para que se realicen las acciones correspondientes de la 
     * WaterCave. Si el jugador cae en ella pierde 5 en su cantidad de oxígeno).
     */
    public void abilityCave(Player j) {
        j.reduceOxygen(5);//Método para reducir el oxígeno del jugador.
        System.out.println("\033[34m¡Has caído  en una caverna de agua y has "
                + "perdido oxígeno!\u001B[0m\n");
    }
}
