package pokemon.pokemonClass;

import moves.Move;
import moves.electric.Thunder;
import moves.electric.ThunderBolt;
import moves.electric.ThunderShock;
import moves.normal.Growl;
import moves.normal.Tackle;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Pikachu extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Pikachu(){
        super("Pikachu",
                10,
                100,
                "MALE",
                Type.ELECTRIC,
                45,
                33,
                62,
                "src/Img/pikachu.png");


        moves.add(new Growl());
        moves.add(new Tackle());
        moves.add(new Thunder());
        moves.add(new ThunderBolt());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(11,new ThunderShock());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
