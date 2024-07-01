package pokemon.pokemonClass;

import moves.electric.Thunder;
import moves.electric.ThunderBolt;
import moves.electric.ThunderShock;
import pokemon.Pokemon;
import pokemon.Type;

public class Pikachu extends Pokemon {

    public Pikachu(){
        super("Pikachu",
                14,
                120,
                "MALE",
                Type.ELECTRIC,
                45,
                33,
                42,
                "src/Img/pikachu.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(15,new Thunder());
        addMoveByLevel(18,new ThunderBolt());
        addMoveByLevel(21,new ThunderShock());
    }
}
