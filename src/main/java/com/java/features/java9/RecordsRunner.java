package com.java.features.java9;

//Records in java introduced in java 15
//Eliminates verbosity in creating java Beans
//public accessor methods , constructors, equals, hashCode, and toString methods are automatically created
//You can create custom implementations if you would want.
//Compact constructors are only allowed in Records
//We can add static fields , static initializer and static variables, but you can not add instance variables or
// instance initializers
//you can use instance methods
public class RecordsRunner {
    record Person(String name, String email, String phoneNumber) {
        static  int age;
       // String address; not allowed as its instance variable
        //This is compact constructor
        Person {
            if (name == null) {
                throw new IllegalArgumentException("Name is null");
            }
        }
        public String name(){
            return name;

        }
    }

    public static void main(String args[]) {
        Person p = new Person("Raju", "raju@gmail.com", "8796519400");
        Person p1 = new Person("Raju", "raju@gmail.com", "8796519400");
        Person p2 = new Person("Ram", "raju@gmail.com", "8796519400");
        System.out.println(p);
        System.out.println(p.equals(p1));
        System.out.println(p1.equals(p2));


    }
}
