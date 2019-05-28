public class DummyTask implements Runnable {
    private String name;

    public DummyTask(String name) {

        this.name = name;
    }

    public void run() {
        System.out.println("Dummy Task "+name+" is working heavily!!!");
    }
}
