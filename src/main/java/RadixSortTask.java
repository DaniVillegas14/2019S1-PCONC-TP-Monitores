import java.util.ArrayList;
import java.util.List;

public class RadixSortTask implements Runnable {
    private ConcurRadixSort concurRadixSort;
    private List<Integer> tarea;
    private List<Integer> result;
    private int nroBit;
    private Barrera barrera;

    public RadixSortTask(ConcurRadixSort concurRadixSort, List<Integer> tarea, List<Integer> result, int nroBit, Barrera barrera) {
        this.concurRadixSort = concurRadixSort;

        this.tarea = tarea;
        this.result = result;
        this.nroBit = nroBit;
        this.barrera = barrera;
    }

    @Override
    public void run() {
        Par splitted = concurRadixSort.split(tarea,nroBit);
        result = new ArrayList<>();
        result.addAll(splitted.getUnos());
        result.addAll(splitted.getCeros());
        barrera.esperar();
    }
}
