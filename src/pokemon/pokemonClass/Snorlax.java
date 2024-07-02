package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.*;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Snorlax extends Pokemon {

    List<Move> moves = new ArrayList<>();

    public Snorlax(){
        super("Snorlax",
                16,
                120,
                "MALE",
                Type.NORMAL,
                56,
                79,
                70,
                "src/Img/snorlax.png");


        moves.add(new Growl());
        moves.add(new Scratch());
        moves.add(new BodySlam());
        moves.add(new GigaImpact());



        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(17,new Tackle());
        addMoveByLevel(20,new HyperBeam());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
