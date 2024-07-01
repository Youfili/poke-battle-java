package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.water.AquaTail;
import moves.water.WaterGun;
import moves.water.WaterPulse;
import pokemon.Pokemon;
import pokemon.Type;

public class Golduck extends Pokemon {

    public Golduck(){
        super("Golduck",
                15,
                150,
                "MALE",
                Type.WATER,
                35,
                51,
                38,
                "src/Img/golduck.png");

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(16,new AquaTail());
        addMoveByLevel(19,new WaterGun());
        addMoveByLevel(24,new WaterPulse());
    }
}
