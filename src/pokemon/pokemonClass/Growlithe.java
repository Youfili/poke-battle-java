package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Growlithe extends Pokemon {

    public Growlithe(){
        super("Growlithe",
                6,
                100,
                "MALE",
                Type.FIRE,
                55,
                52,
                47,
                60,
                "src/Img/growlithe.png",
                16,
                null);


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new Ember());
        addMoveByLevel(12,new FireFang());
        addMoveByLevel(16,new Flamethrower());
    }


}
