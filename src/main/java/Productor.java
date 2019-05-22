public class Productor extends Thread{
    private Buffer buffer;
    private Integer contador;
    public Productor(Buffer buffer) {
        this.buffer= buffer;
        this.contador = 0;
    }

    @Override
    synchronized public void run() {
    while (true ){
            buffer.enqueue(contador);
            contador++;
        }
    }
}
