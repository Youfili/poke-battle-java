package pokemon.pokemonClass;

import moves.Move;
import moves.electric.Thunder;
import moves.electric.ThunderBolt;
import moves.electric.ThunderShock;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Growl;
import moves.normal.Tackle;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Electabuzz extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Electabuzz(){
        super("Electabuzz",
                13,
                100,
                "MALE",
                Type.ELECTRIC,
                31,
                49,
                55,
                "src/Img/electabuzz.png");


        moves.add(new Growl());
        moves.add(new Tackle());
        moves.add(new Thunder());
        moves.add(new ThunderBolt());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(14,new ThunderShock());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }

}
