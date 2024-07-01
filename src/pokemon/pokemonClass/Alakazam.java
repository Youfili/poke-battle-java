package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Alakazam extends Pokemon {

    public Alakazam(){
        super("Alakazam",
                28,
                100,
                "FEMALE",
                Type.PSYCHIC,
                62,
                59,
                48,
                34,
                "src/Img/alakazam.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
