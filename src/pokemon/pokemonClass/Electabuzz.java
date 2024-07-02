package pokemon.pokemonClass;

import moves.Move;
import moves.electric.*;
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

    public Electabuzz(){
        super("Electabuzz",
                13,
                100,
                "MALE",
                Type.ELECTRIC,
                31,
                49,
                64,
                "src/Img/electabuzz.png");


        addMove(new Growl());
        addMove(new Tackle());
        addMove(new Thunder());
        addMove(new ThunderBolt());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(14,new ThunderShock());
        addMoveByLevel(17,new VoltTackle());
        addMoveByLevel(20,new Spark());
    }

}
