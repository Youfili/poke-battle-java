package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Mewtwo extends Pokemon {

    public Mewtwo(){
        super("Mewtwo",
                95,
                100,
                "MALE",
                Type.PSYCHIC,
                92,
                89,
                85,
                14,
                "src/Img/mewtwo.png",
                600,
                null);


//        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }

}
