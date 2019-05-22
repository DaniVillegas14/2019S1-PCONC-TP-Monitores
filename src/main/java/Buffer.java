import java.util.ArrayList;


public class Buffer {
    ArrayList<Integer> queue= new ArrayList<Integer>();
    private int tamanio;

    public Buffer(int tamanio) {

        this.tamanio = tamanio;
    }

    synchronized public Integer pop() {
            while(this.queue.size() == 0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("Se saco algo del buffer");
        notify();
        return this.queue.remove(0);

    }

    synchronized public void enqueue(Integer n) {
        while(this.queue.size() == tamanio){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(n);
        System.out.println("Se encolo : " + n);
        notify();
    }
}
