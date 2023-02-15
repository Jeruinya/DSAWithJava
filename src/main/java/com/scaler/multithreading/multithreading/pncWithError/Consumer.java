package com.scaler.multithreading.multithreading.pncWithError;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Object> q;
    private int maxSize;

    public Consumer(Queue<Object> q, int maxSize) {
        this.q = q;
        this.maxSize = maxSize;
    }


    @Override
    public void run() {
        /**
         * run an infinite loop as of now -> basically we want to add any new object to my shop
         * as soon as there is some space (in this case the space is maxSize)
         */
        while(true){
           // synchronized (q){
                if(q.size() > 0){
                    q.remove();
                }
          //  }

        }


        /**
         * Question: if this was a single threaded code, w/o any pre-emption,
         * will this code work fine...? --> YES, because: if you checked the size of Queue & it was 0
         * but then later someone chnged the size, you will try to remove and end up in ERROR
         *
         * GO BACK TO CLIENT
         */
    }
}
