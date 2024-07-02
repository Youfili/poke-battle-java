package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
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
import java.util.ArrayList;
import java.util.List;

public class Charmender extends Pokemon implements Serializable {

    List<Move> moves = new ArrayList<>();

    public Charmender(){
        super("Charmender",
                6,
                100,
                "MALE",
                Type.FIRE,
                35,
                49,
                75,
                "src/Img/charmander.png");


        moves.add(new Growl());
        moves.add(new Scratch());
        moves.add(new Ember());
        moves.add(new FireFang());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new Flamethrower());
    }

    @Override
    public List<Move> getMoves() {
        return moves;
    }


}
