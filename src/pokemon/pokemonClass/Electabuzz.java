package pokemon.pokemonClass;

import moves.electric.Thunder;
import moves.electric.ThunderBolt;
import moves.electric.ThunderShock;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Electabuzz extends Pokemon {

    public Electabuzz(){
        super("Electabuzz",
                25,
                210,
                "MALE",
                Type.ELECTRIC,
                61,
                59,
                45,
                "src/Img/electabuzz.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(26,new Thunder());
        addMoveByLevel(29,new ThunderBolt());
        addMoveByLevel(33,new ThunderShock());
    }

}
