package pokemon;

import moves.Move;
import pokemon.pokemonClass.*;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private List<Pokemon> pokedex= new ArrayList<Pokemon>();

    public  Pokedex() {

        // Aggiungo i pokemon al Pokedex

        pokedex.add(new Bulbasaur());
        pokedex.add(new Charmender());
        pokedex.add(new Squirtle());
        pokedex.add(new Growlithe());
        pokedex.add(new Nidoran());
        pokedex.add(new Pikachu());
        pokedex.add(new Snorlax());
        pokedex.add(new Alakazam());
        pokedex.add(new Electabuzz());
        pokedex.add(new Golduck());
        pokedex.add(new MrMime());
        pokedex.add(new Machamp());
        pokedex.add(new Dragonite());
        pokedex.add(new Mewtwo());

    }

    public List<Pokemon> getPokedex() {
        return pokedex;
    }

}
