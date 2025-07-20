package com.java.features.java8;

//Given a list of Account objects with status and balance fields, calculate the total balance of only active accounts.

import java.util.Arrays;
import java.util.List;

record Account(String status, double balance) {
}

public class CalculateBalanceOfActiveAccount {
    public static void main(String[] args) {
        List<Account> accountList = Arrays.asList(
                new Account("active", 2000),
                new Account("inactive", 500),
                new Account("active", 1500),
                new Account("inactive", 800));
        double sum = accountList.stream().filter(
                account -> "active".equalsIgnoreCase(account.status())).mapToDouble(Account::balance).sum();
        System.out.println(sum);
    }
}
