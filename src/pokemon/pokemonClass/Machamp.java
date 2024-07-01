package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Machamp extends Pokemon {
    public Machamp(){
        super("Machamp",
                27,
                100,
                "MALE",
                Type.FIGHTING,
                68,
                79,
                35,
                44,
                "src/Img/machamp.png",
                100,
                null);


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }

}


