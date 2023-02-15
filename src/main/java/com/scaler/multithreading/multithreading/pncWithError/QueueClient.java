package com.scaler.multithreading.multithreading.pncWithError;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueClient {

    public static void main(String[] args) {
        Queue<Object> objects = new ConcurrentLinkedDeque<>(); // WHY concurrent? --> assume better for NOW.
        // GO TO PRODUCER AND CONSUMER AND WRITE THEIR CODE.

        // CREATE 3 producers.
        // PASS NAMES OF PRODUCER AND CONSUMER & THEN RUN...
        Producer p1 = new Producer(objects, 6);
        Producer p2 = new Producer(objects, 6);
        Producer p3 = new Producer(objects, 6);

        Consumer c1 = new Consumer(objects,6);
        Consumer c2 = new Consumer(objects,6);
        Consumer c3 = new Consumer(objects,6);
        Consumer c4 = new Consumer(objects,6);
        Consumer c5 = new Consumer(objects,6);

        // STARTING ALL THE PRODUCERS.
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        // STARTING ALL THE CONSUMERS.
        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();
        Thread t7 = new Thread(c4);
        t7.start();
        Thread t8 = new Thread(c5);
        t8.start();


        /**
         * WHY ERROR? NO SUCH ELEMENT? WE HAVE ALREADY REMOVED & CHECKED...
         * because, other thread might have tried to remove in parallel --> PRINT THE THREAD NAME.
         */

    }
}
