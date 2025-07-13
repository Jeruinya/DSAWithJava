package com.java.features.java9;

public final class BankTransfer extends PaymentMethod {
    @Override
    public void processPayment(PaymentMethod method) {
        System.out.println("BankTransfer Payment method Implementation");
    }
}
