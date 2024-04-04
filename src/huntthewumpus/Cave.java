package huntthewumpus;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author natal
 */
public class Cave {
    private List<Integer> conections;//Conexiones entre cuevas.
    private int id;
    private String name;
    
    
    public Cave(int id, String name){
        conections= new ArrayList<Integer>();
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }
    

    public int getId() {
        return id;
    }
    
    //Conectar con otra posición de otra cueva.
    public void setConect(int num){
        conections.add(num);
    }
    
    public List<Integer> getConections(){
        return conections;
    }

    @Override
    public String toString() {
        return "";
    }
    
    public  void abilityCave(Player j){}
}
