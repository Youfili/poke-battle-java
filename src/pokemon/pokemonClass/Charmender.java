package pokemon.pokemonClass;

import pokemon.Pokedex;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;

public class Charmender extends Pokemon implements Serializable {

    public Charmender(){
        super("Charmender",
                6,
                100,
                "MALE",
                Type.FIRE,
                52,
                49,
                45,
                64,
                "src/Img/charmander.png",
                16,
                null);
    }
}
