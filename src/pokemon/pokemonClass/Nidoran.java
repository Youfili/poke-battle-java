package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Action;
import moves.normal.Growl;
import moves.normal.Tackle;
import moves.poison.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Nidoran extends Pokemon {

    public Nidoran(){
        super("Nidoran",
                8,
                100,
                "FEMALE",
                Type.POISON,
                30,
                44,
                64,
                "src/Img/nidoran.png");

        addMove(new Growl());
        addMove(new Tackle());
        addMove(new PoisonSting());
        addMove(new SludgeBomb());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(9,new Toxic());
        addMoveByLevel(12,new ToxicShot());
        addMoveByLevel(15,new GunkShot());
    }

}
