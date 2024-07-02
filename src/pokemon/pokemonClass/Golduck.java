package pokemon.pokemonClass;

import moves.Move;
import moves.fire.Ember;
import moves.fire.FireFang;
import moves.fire.Flamethrower;
import moves.normal.BodySlam;
import moves.normal.Frustration;
import moves.water.AquaTail;
import moves.water.WaterGun;
import moves.water.WaterPulse;
import pokemon.Pokemon;
import pokemon.Type;

import java.util.ArrayList;
import java.util.List;

public class Golduck extends Pokemon {

    private List<Move> moves =new ArrayList<>();

    public Golduck(){
        super("Golduck",
                12,
                100,
                "MALE",
                Type.WATER,
                25,
                31,
                68,
                "src/Img/golduck.png");

        // Aggiungo setto le mosse del pokemon:
        moves.add(new BodySlam());
        moves.add(new Frustration());
        moves.add(new AquaTail());
        moves.add(new WaterGun());

        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(13,new WaterPulse());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }
}
