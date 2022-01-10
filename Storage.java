/*
 * Storage.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This class works on getting the consumer to consume when the storage is full,
 *  else wait until producer produces the required amount.
 *
 * @author Muskan Mall
 * @author Dibyanshu Chatterjee
 */
class Storage {
    static int maxMatch = 90;
    static int maxMatchBox = 9;
    int matches;
    int matchboxes;
    int consumed = 0;
    int toBeConsumed;
    boolean flag = false;

    Storage(int toBeConsumed) {
        /* Parametrized constructor to assing objects.
         */
        this.toBeConsumed = toBeConsumed;
    }

    public synchronized void put() {
        /* The synchronized method put allows either of the threads to get in first
         *  and either add to the storage fo factory or the consumer.
         */
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        add();
        flag = true;
        notify();

    }

    private void add() {
        //Helper method to work with put function

        if (matches < maxMatch) {
            matches += 1;
        }
        if (matchboxes < maxMatchBox) {
            matchboxes += 1;
        }
    }

    public synchronized void get() {
        /* The synchronized method get allows either of the threads to get in first
         *  and either get to the storage of factory or the consumer.helps to consumer to get from storage.
         */
        while (!flag) {
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }// means wait();
        }
        fetch();
        flag = false;
        notify();
    }

    private void fetch() {
        //Helper method to work with put function
        if (matches >= 50 && matchboxes > 0) {
            matches -= 50;
            matchboxes -= 1;
            System.out.println("Consuming");
            consumed += 1;
        }
    }
}