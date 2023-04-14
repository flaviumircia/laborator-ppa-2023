package com.ion_popescu.myapplication.animals;

public class Cat extends Animal{
    public Cat(){}
    public Cat(String name, String colour, int age) {
        super(name, colour, age);
    }

    @Override
    public void talk() {
        System.out.println("Meow meow");
    }
}
