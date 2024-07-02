package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.normal.Growl;
import moves.poison.GunkShot;
import moves.psychic.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Mewtwo extends Pokemon {

    public Mewtwo(){
        super("Mewtwo",
                25,
                100,
                "MALE",
                Type.PSYCHIC,
                82,
                89,
                64,
                "src/Img/mewtwo.png");


        addMove(new Action());
        addMove(new BodySlam());
        addMove(new Psychic());
        addMove(new Psybeam());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(26,new Confusion());
        addMoveByLevel(29,new PsyHit());
        addMoveByLevel(33,new ZenHeadbutt());
    }

}
