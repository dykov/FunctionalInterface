package com.company;

public class Main {

    public static void main(String[] args) {
        EntityFabric<Person> fabric = Person::new; // createNewInstance params corresponds to Person constructor params
        Person alex = fabric.createNewInstance(1, "Alex");

        EntityFabric<Animal> animalEntityFabric = Animal::guessAnimal; // createNewInstance params corresponds to Animal::guessAnimal params
        Animal mouse = animalEntityFabric.createNewInstance(4, "cheese");
    }
}

interface EntityFabric<T extends Creature> {
    T createNewInstance(int num, String val);
}

abstract class Creature {
}

class Person extends Creature {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Animal extends Creature {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public static Animal guessAnimal(int countOfLegs, String favoriteFood) {
        if (countOfLegs == 4 && favoriteFood.equalsIgnoreCase("cheese")) {
            return new Animal("mouse");
        } else if (countOfLegs == 8 && favoriteFood.equalsIgnoreCase("fly")) {
            return new Animal("spider");
        }

        return new Animal("unknown creature");
    }
}