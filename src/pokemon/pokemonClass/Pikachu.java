package pokemon.pokemonClass;

import moves.Move;
import moves.electric.*;
import moves.normal.Action;
import moves.normal.Growl;
import moves.normal.Tackle;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Pikachu extends Pokemon {

    public Pikachu(){
        super("Pikachu",
                10,
                100,
                "MALE",
                Type.ELECTRIC,
                45,
                33,
                64,
                "src/Img/pikachu.png");


        addMove(new Growl());
        addMove(new Tackle());
        addMove(new Thunder());
        addMove(new ThunderBolt());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(11,new ThunderShock());
        addMoveByLevel(14,new VoltTackle());
        addMoveByLevel(18,new Spark());
    }

}
