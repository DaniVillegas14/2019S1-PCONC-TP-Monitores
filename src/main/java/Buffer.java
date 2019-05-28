import java.util.ArrayList;


public class Buffer<T> {
    ArrayList<T> queue= new ArrayList<T>();
    private int tamanio;

    public Buffer(int tamanio) {

        this.tamanio = tamanio;
    }

    synchronized public T pop(){
        while(this.queue.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Se saco algo del buffer");
        notifyAll();
        return this.queue.remove(0);
    }

    synchronized public void enqueue(T elemento){
        while(this.queue.size() >= tamanio){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(elemento);
        System.out.println("Se encolo : " + elemento);
        notify();
    }
}
