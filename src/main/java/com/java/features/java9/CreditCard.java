package com.java.features.java9;

public final class CreditCard extends PaymentMethod {
    @Override
    public void processPayment(PaymentMethod method){
    System.out.println("CreditCard Payment method Implementation");
    }
}
