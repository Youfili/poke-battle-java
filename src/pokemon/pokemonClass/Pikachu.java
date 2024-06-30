package pokemon.pokemonClass;

import pokemon.Pokemon;
import pokemon.Type;

public class Pikachu extends Pokemon {

    public Pikachu(){
        super("Pikachu",
                6,
                100,
                "MALE",
                Type.ELECTRIC,
                55,
                53,
                42,
                64,
                "src/Img/pikachu.png",
                16,
                null);


//        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
