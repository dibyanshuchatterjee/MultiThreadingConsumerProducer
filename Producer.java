/*
 * Producer.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class works on implementing the producer logic.
 *
 * @author Muskan Mall
 * @author Dibyanshu Chatterjee
 */
class Producer implements Runnable {
    Storage storage;

    Producer(Storage storage) {
        this.storage = storage;
        Thread thread = new Thread(this, "Producer");
        thread.start();
    }

    @Override
    public void run() {
        while (storage.consumed < storage.toBeConsumed) {
            storage.put();
        }
    }

}