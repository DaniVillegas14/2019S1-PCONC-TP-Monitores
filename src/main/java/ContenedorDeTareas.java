import java.util.ArrayList;
import java.util.List;

public class ContenedorDeTareas {

    public List<Par> tareas;
    private Integer esperando;

    public ContenedorDeTareas(int cantTareas) {
        this.setUp(cantTareas);
        this.esperando = 0;
    }

    private void setUp(int cantTareas) {
        tareas = new ArrayList<>();
        for (int i = 0; i < cantTareas; i++) {
            tareas.add(new Par());
        }
    }

    synchronized public List<Integer> compilarResultado() throws InterruptedException {
        while(esperando < this.tareas.size() - 1) {
            esperando++;
            wait();
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> ceros = new ArrayList<>();
        for(Par par : tareas){
            res.addAll(par.getUnos());
            ceros.addAll(par.getCeros());
        }
        res.addAll(ceros);
        notify();
        return res;
    }

    synchronized public void agregarTarea(int nroDeLLegada, Par splitted) {
        tareas.set(nroDeLLegada,splitted);

    }
}
