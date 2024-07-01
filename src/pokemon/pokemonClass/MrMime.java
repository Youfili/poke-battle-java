package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class MrMime extends Pokemon {
    public MrMime(){
        super("MrMime",
                19,
                100,
                "MALE",
                Type.PSYCHIC,
                49,
                69,
                35,
                24,
                "src/Img/mrmime.png",
                100,
                null);


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }

}
