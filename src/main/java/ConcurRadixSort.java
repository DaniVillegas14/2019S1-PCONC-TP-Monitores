import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private int numerosDeThreads;

    public ConcurRadixSort(int numerosDeThreads) {
        this.numerosDeThreads = numerosDeThreads;
    }

    public List<Integer> radixSort(List<Integer> list) {
        List<List<Integer>> aux;
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i < 32;++i) {
            aux = split(list,i);
            result.addAll(aux.get(0));
            result.addAll(aux.get(1));
        }
        return result;
    }

    public List<List<Integer>> split (List<Integer> list,int i) {
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int mask = 1 << i;
        for (int n:list) {
            if ((n & mask) > 0)
                ones.add(n);
            else
                zeros.add(n);
        }
        result.add(ones);
        result.add(zeros);
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
            else{contador = contador +1 ;}
        }
        return resultado;

    }

    private void agregarListasVacias(List<List<Integer>> resultado, int numerosDeThreads) {
        for (int i = 0; i < numerosDeThreads; i++) {
            resultado.add(new ArrayList<>());
        }
    }
}
