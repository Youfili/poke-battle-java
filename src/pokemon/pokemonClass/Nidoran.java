package pokemon.pokemonClass;

import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.poison.PoisonSting;
import moves.poison.SludgeBomb;
import moves.poison.Toxic;
import pokemon.Pokemon;
import pokemon.Type;

public class Nidoran extends Pokemon {

    public Nidoran(){
        super("Nidoran",
                13,
                130,
                "FEMALE",
                Type.POISON,
                40,
                44,
                47,
                "src/Img/nidoran.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(14,new PoisonSting());
        addMoveByLevel(17,new SludgeBomb());
        addMoveByLevel(20,new Toxic());
    }
}
