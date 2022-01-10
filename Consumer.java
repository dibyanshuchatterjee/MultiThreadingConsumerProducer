/*
 * Consumer.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class works on implementing the consumer logic.
 *
 * @author Muskan Mall
 * @author Dibyanshu Chatterjee
 */
class Consumer implements Runnable {
    Storage storage;

    Consumer(Storage storage) {
        this.storage = storage;
        Thread thread = new Thread(this, "Consumer");
        thread.start();
    }

    @Override
    public void run() {
        while (storage.consumed < storage.toBeConsumed) {
            storage.get();
        }
    }
}