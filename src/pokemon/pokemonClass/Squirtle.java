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
                "MALE",
                Type.WATER,
                52,
                49,
                45,
                64,
                "src/Img/squirtle.png",
                16,
                null);



        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(8,new WaterGun());
        addMoveByLevel(12,new WaterPulse());
        addMoveByLevel(16,new AquaTail());
    }
}
