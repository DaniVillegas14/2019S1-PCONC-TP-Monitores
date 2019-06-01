import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private List<Worker> workers = new ArrayList();
    private Buffer<Runnable> runnableBuffer;
    public ThreadPool(int cantWorkers,int capacidadDelBuffer) {
        runnableBuffer = new Buffer<>(capacidadDelBuffer);
        this.crearWorkers(cantWorkers);
        this.startWorkers();
    }

    private void startWorkers() {
        workers.forEach(w -> w.start());
    }

    private void crearWorkers(int cantWorkers) {
        for (int i = 0; i < cantWorkers; i++) {
            workers.add(new Worker(runnableBuffer));
        }
    }
    public void launch(Runnable task){
        runnableBuffer.enqueue(task);
    }

    public void stop(){
        for (int i = 0; i < workers.size(); i++) {
            runnableBuffer.enqueue(new PoisonPill());
        }
    }

}
