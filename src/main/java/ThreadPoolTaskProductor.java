public class ThreadPoolTaskProductor extends Thread {

    private ThreadPool threadPool;
    private boolean encendido = true;

    public ThreadPoolTaskProductor (ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public synchronized void run() {
        while (encendido){
            this.threadPool.launch(new DummyTask("Created By " + this.toString()));
        }
    }
    public void stop(int n){
        encendido = false;
    }

}
