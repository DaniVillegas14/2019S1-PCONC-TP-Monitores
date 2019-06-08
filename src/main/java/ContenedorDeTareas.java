import java.util.ArrayList;
import java.util.List;

public class ContenedorDeTareas {
    public List<Par> tareas;
    private int contador = 0;

    public ContenedorDeTareas(int cantTareas) {
        this.setUp(cantTareas);
    }

    private void setUp(int cantTareas) {
        tareas = new ArrayList<>();
        for (int i = 0; i < cantTareas; i++) {
            tareas.add(new Par());
        }
    }

    synchronized public List<Integer> compilarResultado() {
        while (contador < tareas.size()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contador = 0;
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
        contador++;
        tareas.set(nroDeLLegada,splitted);
        if(contador == tareas.size()){
            notify();
        }
    }
}
