package moves;

import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;

public abstract class Move implements Serializable {
    private String name;
    private String description;
    private int damage;
    private int pp;
    private int accuracy;
    private Type type;

    public Move(String name, int damage,int pp, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.pp = pp;

    }

    public Move(String name, Type type, int damage, int pp, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.pp = pp;
        this.type=type;

    }


    public void use(Pokemon pokeUser,Pokemon pokeTarget) {
        //da implementare
    }



    @Override
    public String toString() {
        return name;
    }






    //Getter and Setter

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
}
