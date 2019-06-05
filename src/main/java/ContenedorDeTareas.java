import java.util.ArrayList;
import java.util.List;

public class ContenedorDeTareas {
    public List<Par> tareas;

    public ContenedorDeTareas(int cantTareas) {
        this.setUp(cantTareas);
    }

    private void setUp(int cantTareas) {
        tareas = new ArrayList<>();
        for (int i = 0; i < cantTareas; i++) {
            tareas.add(new Par());
        }
    }

    public List<Integer> compilarResultado() {
        List<Integer> res = new ArrayList<>();
        List<Integer> ceros = new ArrayList<>();
        for(Par par : tareas){
            res.addAll(par.getUnos());
            ceros.addAll(par.getCeros());
        }
        res.addAll(ceros);
        return res;
    }

    synchronized public void agregarTarea(int nroDeLLegada, Par splitted) {
        tareas.set(nroDeLLegada,splitted);
    }
}
