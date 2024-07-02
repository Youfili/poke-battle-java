package pokemon.pokemonClass;

import moves.Move;
import moves.fire.*;
import moves.normal.Growl;
import moves.normal.Scratch;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Growlithe extends Pokemon {

    public Growlithe(){
        super("Growlithe",
                9,
                100,
                "MALE",
                Type.FIRE,
                27,
                32,
                64,
                "src/Img/growlithe.png");


        addMove(new Growl());
        addMove(new Scratch());
        addMove(new Ember());
        addMove(new FireFang());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(10,new Flamethrower());
        addMoveByLevel(13,new HeatWave());
        addMoveByLevel(16,new FirePulse());
    }


}
