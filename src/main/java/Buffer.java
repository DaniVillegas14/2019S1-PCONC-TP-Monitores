import java.util.ArrayList;


public class Buffer {
    ArrayList<Object> queue= new ArrayList<Object>();
    private int tamanio;

    public Buffer(int tamanio) {

        this.tamanio = tamanio;
    }

    synchronized public void pop(){
        while(this.queue.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.remove(0);
        System.out.println("Se saco algo del buffer");
        notifyAll();
    }

    synchronized public void enqueue(Integer n) {
        while(this.queue.size() >= tamanio){
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
