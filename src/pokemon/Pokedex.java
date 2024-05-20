package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private List<Pokemon> pokedex= new ArrayList<Pokemon>();

    public  Pokedex() {
        pokedex.add(new Pokemon("Bulbasaur", 6, 45,
                "MALE", Type.GRASS, 50, 49, 45,64, "src/Img/bulbasaur.png",16,new Pokemon("Ivysaur", 6, 45,
                "MALE", Type.GRASS, 50, 49, 45,64, "src/Img/bulbasaur.png",25,null)));
        pokedex.add(new Pokemon("Charmender", 6, 45,
                "MALE", Type.FIRE, 52, 49, 45,64, "src/Img/charmander.png",16,null));
        pokedex.add(new Pokemon("Squirtle", 6, 45,
                "MALE", Type.WATER, 52, 49, 45,64, "src/Img/squirtle.png",16,null));


    }
    public List<Pokemon> getPokedex() {
        return pokedex;

    }

}
