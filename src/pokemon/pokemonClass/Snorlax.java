package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Snorlax extends Pokemon {

    public Snorlax(){
        super("Snorlax",
                6,
                100,
                "MALE",
                Type.NORMAL,
                46,
                73,
                30,
                64,
                "src/Img/snorlax.png",
                160,
                null);


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
