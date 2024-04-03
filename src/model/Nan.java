package model;

public class Nan extends Character {
    public Nan(String nom) {
        super(nom, 26, 17, 24, 17, 23);
    }

    @Override
    public String toString() {
        return String.format("Nan  {%s}",super.toString());
    }
}
