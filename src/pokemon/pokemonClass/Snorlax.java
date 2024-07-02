package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Snorlax extends Pokemon {

    public Snorlax(){
        super("Snorlax",
                16,
                120,
                "MALE",
                Type.NORMAL,
                56,
                79,
                64,
                "src/Img/snorlax.png");


        addMove(new Growl());
        addMove(new Scratch());
        addMove(new BodySlam());
        addMove(new GigaImpact());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(17,new Tackle());
        addMoveByLevel(22,new HyperBeam());
    }

}
