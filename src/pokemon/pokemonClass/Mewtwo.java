package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import moves.psychic.Psychic;
import pokemon.Pokemon;
import pokemon.Type;

public class Mewtwo extends Pokemon {

    public Mewtwo(){
        super("Mewtwo",
                90,
                750,
                "MALE",
                Type.PSYCHIC,
                92,
                89,
                85,
                "src/Img/mewtwo.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(93,new Psychic());
        addMoveByLevel(96,new Psybeam());
        addMoveByLevel(99,new Confusion());
    }

}
