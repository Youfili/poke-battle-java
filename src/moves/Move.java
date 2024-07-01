package moves;

import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;

public abstract class Move implements Serializable {
    private String name;
    private String description;
    private int damage;
    private Type type;

//    public Move(String name, int damage, String description) {
//        this.name = name;
//        this.damage = damage;
//        this.description = description;
//
//    }

    public Move(String name, Type type, int damage, String description) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type=type;

    }


    @Override
    public String toString() {
        return name;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int pokemonLevel) {
        this.damage = damage;
    }

    // Metodo per calcolare il danno
    public int calculateDamage(int puntiAttackDelPokemonInAttacco, int puntiDifesaDelPokemonInDIfesa) {
        double attackMultiplier = 1 + 0.05 * puntiAttackDelPokemonInAttacco;
        double defenseMultiplier = 1 / (1 + 0.01 * puntiDifesaDelPokemonInDIfesa); // riduce il danno in base ai punti difesa
        return (int) (this.damage * attackMultiplier * defenseMultiplier);
    }

}
