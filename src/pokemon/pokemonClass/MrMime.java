package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.normal.Tackle;
import moves.normal.TailWhip;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import moves.psychic.Psychic;
import moves.water.AquaTail;
import moves.water.WaterGun;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class MrMime extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public MrMime(){
        super("MrMime",
                10,
                100,
                "MALE",
                Type.PSYCHIC,
                35,
                39,
                68,
                "src/Img/mrmime.png");

        moves.add(new Action());
        moves.add(new BodySlam());
        moves.add(new Psychic());
        moves.add(new Psybeam());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(11,new Confusion());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }

}
