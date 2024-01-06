package controller;

import model.AbstractAnimal;
import model.AnimalGenius;
import model.implement.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.List;

/**
 * ПЕРЕИМЕНОВАТЬ В ANIMALCONTROLLER Отвечает за взаимодействие View и Model
 */
public class RuhasApp {

    private Storage dbRuha;

    public RuhasApp(Storage dbRuha) {
        this.dbRuha = dbRuha;
    }

    public List<AbstractAnimal> getAnimals() {
        return dbRuha.getAllAnimals();
    }

    public boolean createAnimal(String name, LocalDate birthDay, AnimalGenius animalGenius) {
        AbstractAnimal animal = switch (animalGenius) {
            case CAT -> new Cat(name, birthDay);
            case DOG -> new Dog(name, birthDay);
            case HAMSTER -> new Hamster(name, birthDay);
            case HORSE -> new Horse(name, birthDay);
            case CAMEL -> new Camel(name, birthDay);
            case DONKEY -> new Donkey(name, birthDay);
        };

        return dbRuha.addAnimal(animal);
    }

    public int removeAnimal(AbstractAnimal animal) {
        if (animal == null) return -1;
        return  dbRuha.removeAnimal(animal);
    }
}