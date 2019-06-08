import java.util.List;

public class RadixSortTask implements Runnable {
    private ConcurRadixSort concurRadixSort;
    private List<Integer> numeros;
    private int nroDeLLegada;
    private ContenedorDeTareas result;
    private int nroBit;

    public RadixSortTask(ConcurRadixSort concurRadixSort, List<Integer> numeros, int nroDeLLegada, ContenedorDeTareas result, int nroBit) {
        this.concurRadixSort = concurRadixSort;
        this.numeros = numeros;
        this.nroDeLLegada = nroDeLLegada;

        this.result = result;
        this.nroBit = nroBit;
    }

    @Override
    public void run() {
        System.out.println("llegada:"+nroDeLLegada);
        Par splitted = concurRadixSort.split(numeros,nroBit);
        result.agregarTarea(nroDeLLegada,splitted);
    }
}
