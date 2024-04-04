package huntthewumpus;

/**
 *
 * @author natal
 */
public class PitCave extends Cave{
     public PitCave(int id, String name) {
        super(id, name);
    }
    

    @Override
    public String toString() {//Texto en morado.
        return "\033[35mSe siente una corriente de aire extraña.\u001B[0m\n";
    }

    @Override
    /**
     * Método correspondiente a la habilidad de la cueva (el jugador muere 
     * si cae en una de estas cuevas).
     */
    public void abilityCave(Player j) {
        j.die();//El jugador muere.
        System.out.println("\033[35m¡Has caido en una caverna con pozo "
                + "sin fondo! Lo sentimos, has perdio la partida\u001B[0m\n");
    }
}
