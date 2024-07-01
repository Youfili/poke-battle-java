package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import moves.psychic.Psychic;
import pokemon.Pokemon;
import pokemon.Type;

public class MrMime extends Pokemon {
    public MrMime(){
        super("MrMime",
                19,
                180,
                "MALE",
                Type.PSYCHIC,
                45,
                59,
                35,
                "src/Img/mrmime.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(20,new Psychic());
        addMoveByLevel(23,new Psybeam());
        addMoveByLevel(26,new Confusion());
    }

}
