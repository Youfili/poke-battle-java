package pokemon.pokemonClass;

import moves.Move;
import moves.fire.*;
import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Growl;
import moves.normal.Scratch;
import moves.normal.Tackle;
import pokemon.Pokedex;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;

public class Charmender extends Pokemon implements Serializable {

    public Charmender(){
        super("Charmender",
                6,
                100,
                "MALE",
                Type.FIRE,
                35,
                49,
                64,
                "src/Img/charmander.png");


        addMove(new Growl());
        addMove(new Scratch());
        addMove(new Ember());
        addMove(new FireFang());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new Flamethrower());
        addMoveByLevel(10,new HeatWave());
        addMoveByLevel(14,new FirePulse());
    }

}
