package huntthewumpus;
import java.util.List;
/**
 *
 * @author natal
 */
public class BatCave extends Cave{
    private List<Cave> caves;
    public BatCave(int id, String name,List<Cave> caves) {
        super(id, name);
        this.caves=caves;
    }
    
    @Override
    /**
     * Método para mostrar la alerta correspondiente de la caverna.
     */
    public String toString() {//Texto en amarillo.
        return "\033[33mSe escuchan aleteos.\u001B[0m\n";
    }

    @Override
    /**
     * Método para realizar la habilidad correspondiente de la caverna
     * (enviar al jugador a una caverna aleatoria).
     */
    public void abilityCave(Player j) {
        int alea=(int)(Math.random()*20);
        j.move(alea);//Mueve al jugador a una caverna aleatoria)
        System.out.println("\033[33m¡Has caido en una caverna con murcielagos!"
                + " Te diriges a una caverna aleatoria.\u001B[0m\n");
        caves.get(alea).abilityCave(j);//Se obtiene la caverna aleatoria.
    }
}
