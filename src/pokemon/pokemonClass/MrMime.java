package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.normal.Tackle;
import moves.normal.TailWhip;
import moves.psychic.*;
import moves.water.AquaTail;
import moves.water.WaterGun;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class MrMime extends Pokemon {

    public MrMime(){
        super("MrMime",
                10,
                100,
                "MALE",
                Type.PSYCHIC,
                35,
                39,
                64,
                "src/Img/mrmime.png");

        addMove(new Action());
        addMove(new BodySlam());
        addMove(new Psychic());
        addMove(new Psybeam());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(11,new Confusion());
        addMoveByLevel(14,new PsyHit());
        addMoveByLevel(17,new ZenHeadbutt());
    }

}
