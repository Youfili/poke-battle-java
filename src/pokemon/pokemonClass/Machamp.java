package pokemon.pokemonClass;

import moves.fighting.CloseCombat;
import moves.fighting.DynamicPunch;
import moves.fighting.KarateChop;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Machamp extends Pokemon {
    public Machamp(){
        super("Machamp",
                27,
                230,
                "MALE",
                Type.FIGHTING,
                58,
                79,
                35,
                "src/Img/machamp.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(28,new DynamicPunch());
        addMoveByLevel(31,new KarateChop());
        addMoveByLevel(35,new CloseCombat());
    }

}


