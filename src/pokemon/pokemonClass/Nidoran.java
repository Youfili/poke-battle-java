package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Nidoran extends Pokemon {

    public Nidoran(){
        super("Nidoran",
                6,
                100,
                "FEMALE",
                Type.VELEN,
                50,
                48,
                47,
                61,
                "src/Img/nidoran.png",
                16,
                null);


//        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }
}
