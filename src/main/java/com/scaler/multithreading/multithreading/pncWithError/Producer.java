package com.scaler.multithreading.multithreading.pncWithError;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> q;
    private int maxSize;

    public Producer(Queue<Object> q, int maxSize) {
        this.q = q;
        this.maxSize = maxSize;
    }

    /**
          DOES PRODUCER NEED TO KNOW ABOUT THE QUEUE? --> Yes.
          Pass it via constructor
         */
    @Override
    public void run() {

        /**
         * run an infinite loop as of now -> basically we want to add any new object to my shop
         * as soon as there is some space (in this case the space is maxSize)
         */
        while(true){
            //synchronized (q){
                if(q.size() < maxSize){
                    q.add(new Object());
                }
           // }

        }

        // GO TO CONSUMER.


    }
}
