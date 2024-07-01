package pokemon.pokemonClass;

import moves.dragon.DragonBreath;
import moves.dragon.DragonClaw;
import moves.dragon.DragonMeteor;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import pokemon.Pokemon;
import pokemon.Type;

public class Dragonite extends Pokemon {

    public Dragonite(){
        super("Dragonite",
                40,
                400,
                "MALE",
                Type.DRAGON,
                78,
                72,
                75,
                "src/Img/dragonite.png");


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(41,new DragonBreath());
        addMoveByLevel(45,new DragonClaw());
        addMoveByLevel(49,new DragonMeteor());
    }

}
