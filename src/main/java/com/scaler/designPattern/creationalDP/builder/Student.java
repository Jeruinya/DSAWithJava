package com.scaler.designPattern.creationalDP.builder;

public class Student {
    String name;
    int age;
    double psp;
    String universityName;
    String batch;
    long id;
    int gradYear;
    String phoneNumber;


   private Student(Helper builder) {
        // validation starts
        if (builder.getGradYear() > 2022) {
            throw new IllegalArgumentException("Grad year cannot be greater than 2022");
        }
        // validation completed

        this.gradYear = builder.getGradYear();
        this.age = builder.getAge();
        this.name = builder.getName();
    }

    public static Helper getBuilder(){
        return  new Helper();
    }

    public static class Helper {
        private String name;
        private int age;
        private double psp;
        private String universityName;
        private String batch;
        private long id;
        private int gradYear;
        private String phoneNumber;

        public Student build() {
            if (this.getAge() > 100) {
                throw new IllegalArgumentException();
            }
            if (this.getPhoneNumber().length() < 10)
                throw new IllegalArgumentException();
            return  new Student(this);
        }

        public String getName() {
            return name;
        }

        public Helper setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Helper setAge(int age) {
            this.age = age;
            return this;
        }

        public double getPsp() {
            return psp;
        }

        public Helper setPsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Helper setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public Helper setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public long getId() {
            return id;
        }

        public Helper setId(long id) {
            this.id = id;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public Helper setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Helper setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
    }
}