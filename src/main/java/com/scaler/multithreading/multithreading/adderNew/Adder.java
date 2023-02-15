package com.scaler.multithreading.multithreading.adderNew;

public class Adder implements Runnable {
    private SharedCount count;
    public Adder(SharedCount count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<100000;i++){
            count.value += i;
        }
    }
}
