package pokemon.pokemonClass;

import moves.Move;
import moves.dragon.*;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.Growl;
import moves.normal.Scratch;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Dragonite extends Pokemon {

    public Dragonite(){
        super("Dragonite",
                17,
                100,
                "MALE",
                Type.DRAGON,
                68,
                62,
                64,
                "src/Img/dragonite.png");


        addMove(new Growl());
        addMove(new Scratch());
        addMove(new DragonBreath());
        addMove(new DragonClaw());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(19,new DragonMeteor());
        addMoveByLevel(22,new Outrage());
        addMoveByLevel(26,new DragonPulse());
    }

}
