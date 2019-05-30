public class PoisonPill implements Runnable {

    @Override
    public void run() {
        throw new PoisonException("Worker interrumpido");
    }

}