import java.util.ArrayList;
import java.util.List;

public class ConcurRadixSort {

    private int numerosDeThreads;
    private int nroDeTarea = -1;
    private int cantidadDeTareas;

    public ConcurRadixSort(int numerosDeThreads) {
        this.numerosDeThreads = numerosDeThreads;
    }
    public List<Integer> radixSortConcur(List<Integer> integers) throws InterruptedException {
      //  Barrera barrera;
        ContenedorDeTareas result = new ContenedorDeTareas(numerosDeThreads);
        List<Integer> aux = integers;
        ThreadPool threadPool = new ThreadPool(numerosDeThreads,100);
        for (int i = 0; i < 32; i++) {
          //  barrera = new Barrera(numerosDeThreads +1);
            List<List<Integer>> tareas = this.separarEnCantThreads(aux);
            encolarTareas(tareas, threadPool,result,i);

     //       barrera.esperar();
            aux = result.compilarResultado(this.getNumeroDeTarea());
            result = new ContenedorDeTareas(tareas.size());
        }
        threadPool.stop();
        return aux;
    }

    private void encolarTareas(List<List<Integer>> tareas, ThreadPool threadPool, ContenedorDeTareas result, int nroBit) {
        for (List<Integer> tarea :
                tareas) {
            threadPool.launch(new RadixSortTask(this,tarea,this.getNumeroDeTarea(),result,nroBit));
        }
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
        int cantidad = array.size()/numerosDeThreads;
        int resto = array.size() % numerosDeThreads;
        int indice = 0;
        for (int i = 0; i < numerosDeThreads; i++) {
            List<Integer> aux = array.subList(indice,cantidad+indice);
            resultado.get(i).addAll(aux);
            indice = indice + cantidad;
        }
        if(array.size() > indice)
        {resultado.get(numerosDeThreads-1).addAll(array.subList(indice,array.size()));}
        return resultado;
    }

    private void agregarListasVacias(List<List<Integer>> resultado, int numerosDeThreads) {
        for (int i = 0; i < numerosDeThreads; i++) {
            resultado.add(new ArrayList<>());
        }
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
