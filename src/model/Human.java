package model;

public class Human extends Character {
    public Human(String nom) {
            super(nom, 14, 19, 16, 25, 24);
        }

    @Override
    public String toString() {
        return String.format("Human {%s}",super.toString());
    }
}
