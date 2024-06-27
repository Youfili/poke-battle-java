package pokemon.pokemonClass;

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
    }
}
