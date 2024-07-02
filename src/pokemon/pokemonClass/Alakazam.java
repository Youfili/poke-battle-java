package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.psychic.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Alakazam extends Pokemon {


    public Alakazam(){
        super("Alakazam",
                14,
                100,
                "FEMALE",
                Type.PSYCHIC,
                42,
                49,
                64,
                "src/Img/alakazam.png");

        addMove(new Action());
        addMove(new BodySlam());
        addMove(new Confusion());
        addMove(new Psybeam());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(15,new Psychic());
        addMoveByLevel(18,new PsyHit());
        addMoveByLevel(20,new ZenHeadbutt());
    }


}
