package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.psychic.Confusion;
import moves.psychic.Psybeam;
import moves.psychic.Psychic;
import pokemon.Pokemon;
import pokemon.Type;

public class Alakazam extends Pokemon {

    public Alakazam(){
        super("Alakazam",
                28,
                230,
                "FEMALE",
                Type.PSYCHIC,
                62,
                59,
                48,
                "src/Img/alakazam.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(29,new Confusion());
        addMoveByLevel(33,new Psybeam());
        addMoveByLevel(36,new Psychic());
    }
}
