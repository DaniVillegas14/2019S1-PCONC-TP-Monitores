public class ThreadPoolTaskProductor extends Thread {

    private ThreadPool threadPool;
    private boolean encendido = true;

    public ThreadPoolTaskProductor (ThreadPool threadPool) {
        this.threadPool = threadPool;
    }

    public void run() {
        while (encendido){
            this.threadPool.launch(new DummyTask("Created By " + this.toString()));
        }
    }

    public void stopThread(){
        encendido = false;
    }

}
