package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import pokemon.Pokedex;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;

public class Charmender extends Pokemon implements Serializable {

    public Charmender(){
        super("Charmender",
                6,
                100,
                "MALE",
                Type.FIRE,
                52,
                49,
                45,
                64,
                "src/Img/charmander.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new Ember());
        addMoveByLevel(12,new FireFang());
        addMoveByLevel(16,new Flamethrower());
    }


}
