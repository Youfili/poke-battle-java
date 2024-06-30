package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Meowth extends Pokemon {

    public Meowth(){
        super("Meowth",
                6,
                100,
                "MALE",
                Type.NORMAL,
                42,
                65,
                38,
                67,
                "src/Img/meowth.png",
                16,
                null);


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
