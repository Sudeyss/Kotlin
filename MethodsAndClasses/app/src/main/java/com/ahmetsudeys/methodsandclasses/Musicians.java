package com.ahmetsudeys.methodsandclasses;

public class Musicians {
    String name;
    String instrument;
    int age;


    //kurucu metot
    public Musicians(String name, String instrument, int age) {
        this.name = name;
        this.instrument = instrument;
        this.age = age;
        System.out.println("constructor called");
    }
}
