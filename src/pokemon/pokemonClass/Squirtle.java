package pokemon.pokemonClass;

import moves.Move;
import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Growl;
import moves.normal.Tackle;
import moves.normal.TailWhip;
import moves.water.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Squirtle extends Pokemon implements Serializable {

    public Squirtle(){
        super ("Squirtle",
                6,
                100,
                "FEMALE",
                Type.WATER,
                32,
                29,
                64,
                "src/Img/squirtle.png");

        addMove(new TailWhip());
        addMove(new Tackle());
        addMove(new AquaTail());
        addMove(new WaterGun());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new WaterPulse());
        addMoveByLevel(10,new Surf());
        addMoveByLevel(15,new HydroPump());
    }

}
