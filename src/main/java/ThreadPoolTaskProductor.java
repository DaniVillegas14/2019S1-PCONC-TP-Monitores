public class ThreadPoolTaskProductor extends Thread {

    private ThreadPool threadPool;

    public ThreadPoolTaskProductor (ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public synchronized void run() {
        while (true){
            this.threadPool.launch(new DummyTask("Created By " + this.toString()));
        }
    }

}
