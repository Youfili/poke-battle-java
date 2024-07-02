package pokemon.pokemonClass;

import moves.Move;
import moves.fighting.CloseCombat;
import moves.fighting.DynamicPunch;
import moves.fighting.KarateChop;
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

    List<Move> moves = new ArrayList<>();

    public Machamp(){
        super("Machamp",
                14,
                100,
                "MALE",
                Type.FIGHTING,
                38,
                49,
                65,
                "src/Img/machamp.png");


        moves.add(new Growl());
        moves.add(new Tackle());
        moves.add(new DynamicPunch());
        moves.add(new KarateChop());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(15,new CloseCombat());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}


