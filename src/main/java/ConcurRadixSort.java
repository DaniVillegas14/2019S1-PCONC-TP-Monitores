import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private int numerosDeThreads;

    public ConcurRadixSort(int numerosDeThreads) {
        this.numerosDeThreads = numerosDeThreads;
    }
    public List<Integer> radixSortConcur(List<Integer> integers){
        List<Integer> result = new ArrayList<>();
        ThreadPool threadPool = new ThreadPool(numerosDeThreads,100);
        Barrera barrera = new Barrera(numerosDeThreads+1);
        List<List<Integer>> tareas = this.separarEnCantThreads(integers);
        for (List<Integer> tarea :
                tareas) {
            threadPool.launch(new RadixSortTask(this, tarea,result,barrera));
        }
        barrera.esperar();
        return result;
    }

    public List<Integer> radixSort(List<Integer> integers) {
        List<Integer> result = integers;
        for(int bit = 0;bit < 32;++bit) {
            result = split(result,bit);
        }
        return result;
    }

    public List<Integer> split (List<Integer> integers,int nroBit) {
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        int mask = 1 << nroBit;
        for (int number:integers) {
            if ((number & mask) > 0)
                ones.add(number);
            else
                zeros.add(number);
        }
        result.addAll(ones);
        result.addAll(zeros);
        return result;
    }

    public List<List<Integer>> separarEnCantThreads(List<Integer> array) {
        List<List<Integer>> resultado = new ArrayList<>();
        agregarListasVacias(resultado,numerosDeThreads);
        int contador = 0;
        for (Integer n:
             array) {
            resultado.get(contador).add(n);
            if(contador == numerosDeThreads-1){contador = 0;}
            else{contador ++ ;}
        }
        return resultado;

    }

    private void agregarListasVacias(List<List<Integer>> resultado, int numerosDeThreads) {
        for (int i = 0; i < numerosDeThreads; i++) {
            resultado.add(new ArrayList<>());
        }
    }

    public List<Integer> ordenar(List<Integer> array) {
        List<List<Integer>> separados = this.separarEnCantThreads(array);
        this.asignarTareasAThreadPool();
        return new ArrayList<>();
    }

    private void asignarTareasAThreadPool() {
    }
}
