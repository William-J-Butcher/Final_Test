package model;

/**
 * Перечисление, описывающее Род животного
 */
public enum AnimalGenius {
    DOG ("Dog"),
    CAT ("Cat"),
    HAMSTER ("Hamster"),
    HORSE ("Horse"),
    CAMEL ("Camel"),
    DONKEY ("Donkey");

    private String title;
    AnimalGenius(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
