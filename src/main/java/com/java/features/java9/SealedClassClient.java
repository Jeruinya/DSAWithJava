package com.java.features.java9;

public class SealedClassClient {
    public static void handlePayment(PaymentMethod method) {
        //case CreditCard creditCard -> creditCard.processPayment(method);
       // case BankTransfer bankTransfer -> bankTransfer.processPayment(method);
        //case OnlineWallet onlineWallet -> onlineWallet.processPayment(method);
    }

    public static void main(String args[]){
        PaymentMethod p= new CreditCard();
        handlePayment(p);
        PaymentMethod p1= new OnlineWallet();
        handlePayment(p1);
    }
}
