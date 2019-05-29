public class PoisonPill implements Runnable {

    private Worker worker;

    public PoisonPill(Worker worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
       this.worker.detener();
    }

}