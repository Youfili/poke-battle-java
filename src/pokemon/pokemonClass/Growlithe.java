package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Growlithe extends Pokemon {

    public Growlithe(){
        super("Growlithe",
                16,
                170,
                "MALE",
                Type.FIRE,
                37,
                42,
                47,
                "src/Img/growlithe.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(17,new Ember());
        addMoveByLevel(20,new FireFang());
        addMoveByLevel(24,new Flamethrower());
    }


}
