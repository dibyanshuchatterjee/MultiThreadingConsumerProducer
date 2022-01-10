/*
 * Factory.java
 *
 * Version:
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

/**
 * This works as the driver class and instantiates all the classes.
 *
 * @author Muskan Mall
 * @author Dibyanshu Chatterjee
 */
public class Factory {
    public static void main(String[] argv) {
        /* The main method is to pas the storage object to the relavant classes
         * and also to instantiate the Storage class.
         */
        Storage storage = new Storage(10);
        new Producer(storage);
        new Consumer(storage);
    }

}

