package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Dragonite extends Pokemon {

    public Dragonite(){
        super("Dragonite",
                40,
                100,
                "MALE",
                Type.DRAGON,
                84,
                79,
                75,
                34,
                "src/Img/dragonite.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
//        addMoveByLevel(7,new Ember());
//        addMoveByLevel(12,new FireFang());
//        addMoveByLevel(16,new Flamethrower());
    }

}
