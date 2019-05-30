public class PoisonPill implements Runnable {


    public PoisonPill() {
    }

    @Override
    public void run() {
        throw new PoisonException("Poison Pill consumida, un worker se detuvo.");
    }

}