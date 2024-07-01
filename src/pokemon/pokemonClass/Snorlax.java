package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.HyperBeam;
import moves.normal.Scratch;
import moves.normal.Tackle;
import pokemon.Pokemon;
import pokemon.Type;

public class Snorlax extends Pokemon {

    public Snorlax(){
        super("Snorlax",
                21,
                240,
                "MALE",
                Type.NORMAL,
                56,
                79,
                30,
                "src/Img/snorlax.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(22,new Tackle());
        addMoveByLevel(25,new Scratch());
        addMoveByLevel(28,new HyperBeam());
    }
}
