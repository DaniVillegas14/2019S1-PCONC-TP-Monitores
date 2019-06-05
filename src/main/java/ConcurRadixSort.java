import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private int numerosDeThreads;
    private int nroDeTarea = -1;
    private int cantidadDeTareas;

    public ConcurRadixSort(int numerosDeThreads) {
        this.numerosDeThreads = numerosDeThreads;
    }
    public List<Integer> radixSortConcur(List<Integer> integers){
        Barrera barrera;
        ContenedorDeTareas result = new ContenedorDeTareas(numerosDeThreads);
        List<Integer> aux = integers;
        ThreadPool threadPool = new ThreadPool(numerosDeThreads,100);
        for (int i = 0; i < 32; i++) {
            barrera = new Barrera(numerosDeThreads +1);
            List<List<Integer>> tareas = this.separarEnCantThreads(aux);
            encolarTareas(tareas, threadPool,result,i,barrera);

            barrera.esperar();
            aux =result.compilarResultado();
            result = new ContenedorDeTareas(tareas.size());
        }
        return aux;
    }

    private void encolarTareas(List<List<Integer>> tareas, ThreadPool threadPool, ContenedorDeTareas result, int nroBit, Barrera barrera) {
        for (List<Integer> tarea :
                tareas) {
            threadPool.launch(new RadixSortTask(this,tarea,this.getNumeroDeTarea(),result,nroBit,barrera));
        }
    }

    public List<Integer> radixSort(List<Integer> integers) {
        List<Integer> result = integers;
        for(int bit = 0;bit < 32;++bit) {
            //result = split(result,bit);
        }
        return result;
    }

    public Par split (List<Integer> integers,int nroBit) {
        List<Integer> zeros = new ArrayList<Integer>();
        List<Integer> ones = new ArrayList<Integer>();
        Par result = new Par();
        int mask = 1 << nroBit;
        for (int number:integers) {
            if ((number & mask) > 0)
                ones.add(number);
            else
                zeros.add(number);
        }
        result.agregarAUnos(ones);
        result.agregarACeros(zeros);
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

   /* public List<Integer> ordenar(List<Integer> array) {
        List<List<Integer>> separados = this.separarEnCantThreads(array);
        this.asignarTareasAThreadPool();
        return new ArrayList<>();
    }*/

    private void asignarTareasAThreadPool() {
    }

    synchronized public int getNumeroDeTarea() {
        if(nroDeTarea == numerosDeThreads -1){
            this.nroDeTarea = 0;
            return nroDeTarea;
        }
        else{
        return ++this.nroDeTarea;
        }
    }
}
