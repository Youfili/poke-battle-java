package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Growl;
import moves.normal.Scratch;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Growlithe extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Growlithe(){
        super("Growlithe",
                9,
                100,
                "MALE",
                Type.FIRE,
                27,
                32,
                67,
                "src/Img/growlithe.png");


        moves.add(new Growl());
        moves.add(new Scratch());
        moves.add(new Ember());
        moves.add(new FireFang());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(24,new Flamethrower());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }


}
