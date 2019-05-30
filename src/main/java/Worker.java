
public class Worker extends Thread {

    private Buffer<Runnable> buffer;

    public Worker(Buffer<Runnable> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            buffer.pop().run();
        }
    }
}

