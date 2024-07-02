package pokemon.pokemonClass;

import moves.Move;
import moves.fighting.*;
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

public class Machamp extends Pokemon {

    public Machamp(){
        super("Machamp",
                14,
                100,
                "MALE",
                Type.FIGHTING,
                38,
                49,
                64,
                "src/Img/machamp.png");

        addMove(new Growl());
        addMove(new Tackle());
        addMove(new DynamicPunch());
        addMove(new KarateChop());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(15,new CloseCombat());
        addMoveByLevel(18,new CrossChop());
        addMoveByLevel(22,new FocusPunch());
    }

}


