public class TaskProductor extends Productor {
    private Buffer<Runnable> runnableBuffer;

    public TaskProductor(Buffer<Runnable> runnableBuffer) {
        super(runnableBuffer);
        this.runnableBuffer = runnableBuffer;
    }

    @Override
    public void run() {
        while (true) {
            runnableBuffer.enqueue(new DummyTask("Created by TaskProductor"));
        }
    }
}
