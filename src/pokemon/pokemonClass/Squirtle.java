package pokemon.pokemonClass;

import moves.Move;
import moves.grass.GigaDrain;
import moves.grass.RazorLeaf;
import moves.grass.VineWhip;
import moves.normal.Growl;
import moves.normal.Tackle;
import moves.normal.TailWhip;
import moves.water.AquaTail;
import moves.water.WaterGun;
import moves.water.WaterPulse;
import pokemon.Pokemon;
import pokemon.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Squirtle extends Pokemon implements Serializable {

    List<Move> moves = new ArrayList<>();

    public Squirtle(){
        super ("Squirtle",
                6,
                100,
                "FEMALE",
                Type.WATER,
                32,
                29,
                65,
                "src/Img/squirtle.png");


        moves.add(new TailWhip());
        moves.add(new Tackle());
        moves.add(new AquaTail());
        moves.add(new WaterGun());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(7,new WaterPulse());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
