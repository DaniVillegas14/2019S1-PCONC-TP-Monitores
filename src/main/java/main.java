import java.util.ArrayList;
import java.util.List;

class main {

    public static void main(String[] args) throws InterruptedException {
        /***Prueba para Buffer*/
      /*  Buffer buffer = new Buffer<Integer>(1000000000);
        Productor p1 = new Productor(buffer);
        Productor p2 = new Productor(buffer);
        Consumidor c1 = new Consumidor(buffer);
        Consumidor c2 = new Consumidor(buffer);
        p1.start();
        p2.start();
        c1.start();
        c2.start();*/

        /***Prueba para Worker*/
    /*    Buffer<Runnable>  runnableBuffer = new Buffer<Runnable>(10);
        Productor productor = new TaskProductor(runnableBuffer);
        Productor productor2 = new TaskProductor(runnableBuffer);
        Worker worker = new Worker(runnableBuffer);
        runnableBuffer.enqueue(new DummyTask("Usain Bolt"));
        runnableBuffer.enqueue(new DummyTask("Rayo Mcqueen"));
        runnableBuffer.enqueue(new DummyTask("Dani"));
        runnableBuffer.enqueue(new DummyTask("Nico"));
        runnableBuffer.enqueue(new DummyTask("Paulo Londra"));
        runnableBuffer.enqueue(new DummyTask("Fredy Mercury"));
        runnableBuffer.enqueue(new DummyTask("Aristoteles"));

        productor.start();
        productor2.start();

        worker.start();
    } */
/*
        *//***Prueba para PoisonPill*//*
        Buffer<Runnable>  runnableBuffer = new Buffer<>(10);
              Productor productor = new TaskProductor(runnableBuffer);
              Productor productor2 = new TaskProductor(runnableBuffer);
              Worker worker = new Worker(runnableBuffer);
              runnableBuffer.enqueue(new DummyTask("Usain Bolt"));
              runnableBuffer.enqueue(new DummyTask("Rayo Mcqueen"));
              runnableBuffer.enqueue(new PoisonPill());
              runnableBuffer.enqueue(new DummyTask("Dani"));
              runnableBuffer.enqueue(new DummyTask("Nico"));

              productor.start();
              productor2.start();

              worker.start();*/

      /**Prueba para ThreadPool*/
          /*ThreadPool threadPool = new ThreadPool(8,10);
          ThreadPoolTaskProductor productor = new ThreadPoolTaskProductor(threadPool);

          productor.start();
          Thread.sleep(4000);
          threadPool.stop();
          productor.stopThread();*/
        /**Prueba RadixSort*/
        ConcurRadixSort concurRadixSort = new ConcurRadixSort(8);
        List<Integer> array = new ArrayList<>();
        array.add(new Integer(2));
        array.add(new Integer(3));
         array.add(new Integer(8));
      array.add(new Integer(6));
        array.add(new Integer(4));
        array.add(new Integer(7));
        array.add(new Integer(9));
        array.add(new Integer(2));

        System.out.println(concurRadixSort.radixSort(array));
    }

}



