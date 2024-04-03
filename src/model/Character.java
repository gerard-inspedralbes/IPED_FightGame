package model;

public abstract class Character {
    private static int characterCounter= 1;
    private int id;
    private String nom;
    private int strength;
    private int lives;
    private int agility;
    private int endurance;
    private int intellect;
    private int spirit;

    public Character(String nom, int strength, int agility, int endurance, int intellect, int spirit) {
        this.nom = nom;
        this.strength = strength;
        this.lives = 3;
        this.agility = agility;
        this.endurance = endurance;
        this.intellect = intellect;
        this.spirit = spirit;
        this.id = characterCounter++;
    }

    public String getNom() {
        return nom;
    }

    public int getId()
    {
        return id;
    }

    public int getLives() {
        return lives;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getStrength() {
        return strength;
    }

    public void loseLive(){
        lives--;
    }


    @Override
    public String toString() {
        return  "id=" + id +
                ", lives=" + lives +
                ", nom=" + escriureNom(nom) +
                ", strength=" + strength +
                ", agility=" + agility +
                ", endurance=" + endurance +
                ", intellect=" + intellect +
                ", spirit=" + spirit
                ;
    }

    private String escriureNom(String nom)
    {
      return String.format("%-" + 7 + "s", nom);
    }
}
