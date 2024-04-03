package model;

public abstract class Fighter extends Character{
    protected int victories;
    protected int defeats;
    public abstract boolean fight(Character opponent);

    public Fighter(String nom, int strength, int agility, int endurance, int intellect, int spirit) {
        super(nom, strength, agility, endurance, intellect, spirit);
    }
    public void win(){
        victories ++;
    }
    public void lose(){
        loseLive();
        defeats++;
    }

    @Override
    public String toString() {
        return super.toString() +
                " victories=" + victories +
                ", defeats=" + defeats
                ;
    }
}
