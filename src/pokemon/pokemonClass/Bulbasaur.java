package pokemon.pokemonClass;

import moves.Move;
import moves.grass.*;
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

    public Bulbasaur(){
        super("Bulbasaur",
                6,
                100,
                "MALE",
                Type.GRASS,
                35,
                39,
                64,
                "src/Img/bulbasaur.png");



        addMove(new Growl());
        addMove(new Tackle());
        addMove(new VineWhip());
        addMove(new RazorLeaf());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new GigaDrain());
        addMoveByLevel(10,new LeafBlade());
        addMoveByLevel(14,new SeedBomb());


    }


}
