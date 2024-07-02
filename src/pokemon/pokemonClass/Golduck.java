package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.BodySlam;
import moves.normal.Frustration;
import moves.normal.Growl;
import moves.water.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Golduck extends Pokemon {

    public Golduck(){
        super("Golduck",
                12,
                100,
                "MALE",
                Type.WATER,
                25,
                31,
                64,
                "src/Img/golduck.png");


        addMove(new BodySlam());
        addMove(new Frustration());
        addMove(new AquaTail());
        addMove(new WaterGun());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(13,new WaterPulse());
        addMoveByLevel(16,new Surf());
        addMoveByLevel(20,new HydroPump());
    }
}
