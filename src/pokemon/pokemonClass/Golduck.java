package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Golduck extends Pokemon {

    public Golduck(){
        super("Golduck",
                15,
                100,
                "MALE",
                Type.WATER,
                55,
                51,
                38,
                40,
                "src/Img/golduck.png",
                16,
                null);

//
//        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
