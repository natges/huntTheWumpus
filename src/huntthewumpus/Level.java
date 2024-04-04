package huntthewumpus;

//Enumeración para definir las constantes de los 
//números de niveles.
enum NumLevel {
    UNO,DOS,TRES;
}

/**
 *
 * @author natal
 */
public class Level {
    private NumLevel numLevel;
    //Cantidad de cuevas correspondientes a cada nivel.
    private int cantWumpusCave;
    private int cantPitCave;
    private int cantBatCave;
    private int cantWaterCave;
    private int cantOxygenCave;
    private int cantChallengeCave;
    private int cantNormalCave;
    private int cantCampCave;
    private int numCaves;
    
    public Level(NumLevel numLevel){
        this.numLevel=numLevel;
        initializeComponents();
    }

    public int getCantWumpusCave() {
        return cantWumpusCave;
    }

    public int getCantPitCave() {
        return cantPitCave;
    }

    public int getCantBatCave() {
        return cantBatCave;
    }

    public int getCantWaterCave() {
        return cantWaterCave;
    }

    public int getCantOxygenCave() {
        return cantOxygenCave;
    }

    public int getCantChallengeCave() {
        return cantChallengeCave;
    }

    public int getCantNormalCave() {
        return cantNormalCave;
    }

    public int getCantCampCave() {
        return cantCampCave;
    }

    public NumLevel getNumLevel() {
        return numLevel;
    }
    
    
    /**
     * Método para inicializar las cantidades de cada caverna de 
     * acuerdo al nivel correspondiente.
     */
    private void initializeComponents(){
        int cantSpecialCave;//Cuevas especiales(que tienen habilidad).
        if(numLevel.name().equals(NumLevel.UNO.name())){//Nivel fácil.
            numCaves=20;
            cantCampCave=1;
            cantWumpusCave=1;
            cantPitCave=1;
            cantBatCave=1;
            cantWaterCave=1;
            cantOxygenCave=3;
            cantChallengeCave=1;
        }else if(numLevel.name().equals(NumLevel.DOS.name())){//Nivel medio.
            numCaves=30;
            cantCampCave=1;
            cantWumpusCave=1;
            cantPitCave=3;
            cantBatCave=3;
            cantWaterCave=3;
            cantOxygenCave=2;
            cantChallengeCave=3;
        }else{//Nivel avanzado.
            numCaves=50;
            cantCampCave=1;
            cantWumpusCave=1;
            cantPitCave=8;
            cantBatCave=5;
            cantWaterCave=5;
            cantOxygenCave=1;
            cantChallengeCave=5;
        }
        //Se calcula la cantidad de cuevas especiales.
        cantSpecialCave=cantWumpusCave+cantPitCave+cantBatCave+
                cantWaterCave+cantOxygenCave+cantChallengeCave+cantCampCave;
        //Se calcula la cantidad de cuevas normales.
        cantNormalCave=numCaves-cantSpecialCave;
    }

    public int getNumCaves() {
        return numCaves;
    }
    
    /**
     * Método para obtener las cantidades de cada tipo de cueva en el
     * laberinto.
     * @return 
     */
    public int[] getNumbersCaves(){
        int[] cants= {cantWumpusCave,cantPitCave,cantBatCave,cantWaterCave,
            cantOxygenCave,cantChallengeCave,cantNormalCave};
        return cants;
    }
}
