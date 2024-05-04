package moves;

import pokemon.Pokemon;

public abstract class Move {
    private String name;
    private int damage;
    private String description;
    private int pp;

    public Move(String name, int damage,int pp, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.pp = pp;

    }
    public void use(Pokemon pokeUser,Pokemon pokeTarget) {
        //da implementare
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    @Override
    public String toString() {
        return name;
    }
}
