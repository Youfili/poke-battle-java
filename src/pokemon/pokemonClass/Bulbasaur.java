package pokemon.pokemonClass;

import moves.Move;
import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Action;
import moves.normal.BodySlam;
import moves.normal.Growl;
import moves.normal.Tackle;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bulbasaur extends Pokemon implements Serializable {

    List<Move> moves = new ArrayList<>();

    public Bulbasaur(){
        super("Bulbasaur",
                6,
                100,
                "MALE",
                Type.GRASS,
                35,
                39,
                65,
                "src/Img/bulbasaur.png");


        moves.add(new Growl());
        moves.add(new Tackle());
        moves.add(new VineWhip());
        moves.add(new RazorLeaf());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new GigaDrain());


    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
