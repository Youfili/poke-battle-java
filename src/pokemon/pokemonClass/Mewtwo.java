package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import moves.psychic.Psychic;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Mewtwo extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Mewtwo(){
        super("Mewtwo",
                25,
                100,
                "MALE",
                Type.PSYCHIC,
                82,
                89,
                65,
                "src/Img/mewtwo.png");

        moves.add(new Action());
        moves.add(new BodySlam());
        moves.add(new Psychic());
        moves.add(new Psybeam());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(26,new Confusion());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }

}
