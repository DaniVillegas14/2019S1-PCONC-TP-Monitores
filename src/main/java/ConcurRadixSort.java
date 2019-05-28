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

}
