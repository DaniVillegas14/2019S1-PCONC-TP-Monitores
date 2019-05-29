
public class Worker extends Thread {

    private Buffer<Runnable> buffer;
    private boolean ejecutar;

    public Worker(Buffer<Runnable> buffer) {
        this.buffer = buffer;
        this.ejecutar = true;
    }

    @Override
    public void run() {
        while(this.ejecutar) {
            buffer.pop().run();
        }
        // Cuando sale del while es porque el thread se detuvo
        try {
            throw new PoisonException("Worker interrumpido");
        } catch (PoisonException e) {
            e.printStackTrace();
        }
    }

    public void detener() {
        this.ejecutar = false;
    }

}

