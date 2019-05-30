import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private int threadsWorkers;
    private List<Worker> workers;
    private Buffer<Runnable> buffer;

    public ThreadPool(int tamanioBuffer,int threads) {
        this.buffer = new Buffer<Runnable>(tamanioBuffer);
        this.threadsWorkers = threads;
        this.workers = new ArrayList<Worker>();
        this.instanciarThreads();
    }

    private void instanciarThreads() {
        for(int i = 0; i < this.threadsWorkers;i++) {
           Worker worker = new Worker(this.buffer);
           this.workers.add(worker);
        }
    }

    public Buffer<Runnable> getBuffer() {
        return this.buffer;
    }

    public void runWorkers() {
        this.workers.forEach(worker -> worker.run());
    }

    public synchronized void launch(Runnable task) {
        this.buffer.enqueue(task);
    }

    // Este no funca
//    public synchronized void stop() {
//        while(this.buffer.queue.size() > 0) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        // Aca habria que terminar la ejecucion de todos los workers con el Poison
//        throw new PoisonException("TERMINAMOOOOOOOOOO");
//    }

}
