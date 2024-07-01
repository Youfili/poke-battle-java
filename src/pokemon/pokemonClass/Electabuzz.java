package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Electabuzz extends Pokemon {

    public Electabuzz(){
        super("Electabuzz",
                25,
                100,
                "MALE",
                Type.ELECTRIC,
                58,
                59,
                45,
                62,
                "src/Img/electabuzz.png",
                100,
                null);


//        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }

}
