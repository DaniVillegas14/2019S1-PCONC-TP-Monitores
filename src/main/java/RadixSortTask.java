import java.util.List;

public class RadixSortTask implements Runnable {
    private ConcurRadixSort concurRadixSort;
    private List<Integer> tarea;
    private List<Integer> result;
    private Barrera barrera;

    public RadixSortTask(ConcurRadixSort concurRadixSort, List<Integer> tarea,List<Integer> result,Barrera barrera) {
        this.concurRadixSort = concurRadixSort;

        this.tarea = tarea;
        this.result = result;
        this.barrera = barrera;
    }

    @Override
    public void run() {
        result.addAll(concurRadixSort.radixSort(tarea));
        barrera.esperar();
    }
}
