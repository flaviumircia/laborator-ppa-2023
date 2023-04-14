package com.ion_popescu.myapplication.animals;

public class Dog extends Animal {
    public Dog(){}
    public Dog(String name, String colour, int age) {
        super(name, colour, age);
    }

    @Override
    public void talk() {
        System.out.println("Woof woof!");
    }
}
