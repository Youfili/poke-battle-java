package pokemon.pokemonClass;

import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.water.AquaTail;
import moves.water.WaterGun;
import moves.water.WaterPulse;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;

public class Squirtle extends Pokemon implements Serializable {

    public Squirtle(){
        super ("Squirtle",
                6,
                100,
                "FEMALE",
                Type.WATER,
                32,
                29,
                45,
                "src/Img/squirtle.png");



        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new AquaTail());
        addMoveByLevel(12,new WaterGun());
        addMoveByLevel(16,new WaterPulse());
    }
}
