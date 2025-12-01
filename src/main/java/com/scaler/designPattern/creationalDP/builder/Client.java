package com.scaler.designPattern.creationalDP.builder;

public class Client {

    public static void main(String[] args) {
        Student.Helper studentBuilder = Student.getBuilder();
        Student ss = studentBuilder
                .setAge(10)
                .setName("ABC")
                .setPhoneNumber("1234567890")
                .setId(1231).setBatch("April")
                .setPsp(1.2)
                .setGradYear(2022).build();

    }
}