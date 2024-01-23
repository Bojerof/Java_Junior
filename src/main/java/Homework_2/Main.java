package Homework_2;

import java.lang.reflect.Method;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void makeSound(){
        System.out.println("No have sound!");
    }
}
class Fish extends Animal {
    private String breed;

    public Fish(String name, int age) {
        super(name, age);

    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public String getBreed() {
        return breed;
    }


}

class Cat extends Animal {
    private int lives;

    public Cat(String name, int age, int lives) {
        super(name, age);
        this.lives = lives;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public int getLives() {
        return lives;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[4];
        animals[0] = new Dog("Buddy", 3, "Golden Retriever");
        animals[1] = new Cat("Whiskers", 5, 9);
        animals[2] = new Dog("Max", 2, "Labrador");
        animals[3] = new Fish("Robert", 1);
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName());
            System.out.println("Age: " + animal.getAge());
            Method makeSoundMethod;
            try {
                makeSoundMethod = animal.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (Exception e) {
                System.out.println("Error");
            }
            System.out.println();
        }
    }
}