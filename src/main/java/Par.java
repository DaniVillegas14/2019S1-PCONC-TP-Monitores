import java.util.ArrayList;
import java.util.List;

public class Par {

    List<Integer> ceros;
    List<Integer> unos;
    public Par() {

        ceros = new ArrayList<Integer>();
        unos = new ArrayList<Integer>();
    }
    public List<Integer> getCeros(){
        return ceros;
    }
    public List<Integer> getUnos(){
        return unos;
    }

    public void agregarAUnos(List<Integer>  lista){
        unos.addAll(lista);
    }
    public void agregarACeros(List<Integer>  lista){
        ceros.addAll(lista);
    }

}
