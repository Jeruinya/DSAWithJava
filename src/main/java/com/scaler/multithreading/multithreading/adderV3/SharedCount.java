package com.scaler.multithreading.multithreading.adderV3;

public class SharedCount {
    private int value = 0;

    /**
     *
     * @param offset
     */
    public synchronized void increamentValue(int offset){
        value += offset;
    }

    public int getValue() {
        return value;
    }
}
