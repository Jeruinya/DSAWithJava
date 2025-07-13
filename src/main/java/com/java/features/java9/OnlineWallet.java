package com.java.features.java9;

public final class OnlineWallet extends PaymentMethod {
    @Override
    public void processPayment(PaymentMethod method) {
        System.out.println("Online Payment method Implementation");
    }
}
