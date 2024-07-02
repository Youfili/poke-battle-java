package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Growl;
import moves.normal.Tackle;
import moves.poison.PoisonSting;
import moves.poison.SludgeBomb;
import moves.poison.Toxic;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Nidoran extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Nidoran(){
        super("Nidoran",
                8,
                100,
                "FEMALE",
                Type.POISON,
                30,
                44,
                67,
                "src/Img/nidoran.png");


        moves.add(new Growl());
        moves.add(new Tackle());
        moves.add(new PoisonSting());
        moves.add(new SludgeBomb());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(9,new Toxic());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
