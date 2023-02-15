package com.scaler.multithreading;

public class HelloWorldPrinter implements Runnable {

    public void printName(){
        System.out.println("Inside printName.. " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        printName();
        System.out.println("hello world.. " + Thread.currentThread().getName());
    }
}
