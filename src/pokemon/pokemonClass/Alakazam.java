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

public class Alakazam extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Alakazam(){
        super("Alakazam",
                14,
                100,
                "FEMALE",
                Type.PSYCHIC,
                42,
                49,
                68,
                "src/Img/alakazam.png");

        moves.add(new Action());
        moves.add(new BodySlam());
        moves.add(new Confusion());
        moves.add(new Psybeam());



        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(15,new Psychic());
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
