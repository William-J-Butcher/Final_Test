package storage;

import model.AbstractAnimal;
import model.AbstractPackAnimal;
import model.AbstractPet;
import model.implement.*;
import model.Skill;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализация интерфейса Storage
 * Хранилище реализовано на HashMap
 */
public class RuhasStorage implements Storage{
    Map<Integer, AbstractAnimal> dbAnimals = new HashMap<>();

    public RuhasStorage() {
        init();
    }

    private void init(){
        AbstractPet cat = new Cat("Karamelka", LocalDate.of(2022, 2, 02));

        int per = cat.getAge();

        cat.learnSkill(new Skill("Kis-kis"));
        dbAnimals.put(cat.getId(), cat);

        AbstractPet dog = new Dog("Rex", LocalDate.of(2021, 1, 01));
        dog.learnSkill(new Skill("Sit"));
        dog.learnSkill(new Skill("Jump"));
        dbAnimals.put(dog.getId(), dog);

        AbstractPet hamster = new Hamster("Barry", LocalDate.of(2021, 1, 01));
        hamster.learnSkill(new Skill(""));
        dbAnimals.put(hamster.getId(), hamster);

        AbstractPackAnimal horse = new Horse("Sivka", LocalDate.of(2018, 1, 12));
        horse.setLoadCapacity(300);
        horse.learnSkill(new Skill("No!"));
        dbAnimals.put(horse.getId(), horse);

        AbstractPackAnimal horse2 = new Horse("Burka", LocalDate.of(2021, 12, 12));
        horse2.setLoadCapacity(400);
        horse2.learnSkill(new Skill("No!"));
        horse2.learnSkill(new Skill("Stop!"));
        dbAnimals.put(horse2.getId(), horse2);

        AbstractPackAnimal donkey = new Donkey("Ia", LocalDate.of(2019, 2, 12));
        donkey.setLoadCapacity(500);
        donkey.learnSkill(new Skill(""));
        dbAnimals.put(donkey.getId(), donkey);

        AbstractPackAnimal camel = new Camel("Quasimodo", LocalDate.of(2019, 3, 12));
        camel.setLoadCapacity(1000);
        camel.learnSkill(new Skill("NO!"));
        dbAnimals.put(camel.getId(), camel);
    }
    @Override
    public List<AbstractAnimal> getAllAnimals() {
        List<AbstractAnimal> result = new ArrayList<>();
        for (AbstractAnimal animal: dbAnimals.values()) {
            result.add(animal);
        }
        return result;
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbAnimals.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbAnimals.containsKey(animal.getId())) {return false;}
        dbAnimals.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbAnimals.containsKey(animal.getId())) {
            return -1;
        }
        AbstractAnimal removed = dbAnimals.remove(animal.getId());
        return removed.getId();
    }
}