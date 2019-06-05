import java.util.ArrayList;
import java.util.List;

public class RadixSortTask implements Runnable {
    private ConcurRadixSort concurRadixSort;
    private List<Integer> numeros;
    private int nroDeLLegada;
    private ContenedorDeTareas result;
    private int nroBit;
    private Barrera barrera;

    public RadixSortTask(ConcurRadixSort concurRadixSort, List<Integer> numeros, int nroDeLLegada, ContenedorDeTareas result, int nroBit, Barrera barrera) {
        this.concurRadixSort = concurRadixSort;
        this.numeros = numeros;
        this.nroDeLLegada = nroDeLLegada;

        this.result = result;
        this.nroBit = nroBit;
        this.barrera = barrera;
    }

    @Override
    public void run() {
        System.out.println("llegada:"+nroDeLLegada);
        Par splitted = concurRadixSort.split(numeros,nroBit);
        result.agregarTarea(nroDeLLegada,splitted);
        barrera.esperar();
    }
}
