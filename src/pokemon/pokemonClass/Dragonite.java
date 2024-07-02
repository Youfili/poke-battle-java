package pokemon.pokemonClass;

import moves.Move;
import moves.dragon.DragonBreath;
import moves.dragon.DragonClaw;
import moves.dragon.DragonMeteor;
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

    List<Move> moves = new ArrayList<>();

    public Dragonite(){
        super("Dragonite",
                17,
                100,
                "MALE",
                Type.DRAGON,
                68,
                62,
                65,
                "src/Img/dragonite.png");


        moves.add(new Growl());
        moves.add(new Scratch());
        moves.add(new DragonBreath());
        moves.add(new DragonClaw());


        //settiamo il  dizionario delle mosse da imparare in base al livello --> mossa
        addMoveByLevel(18,new DragonMeteor());
    }
    @Override
    public List<Move> getMoves() {
        return moves;
    }

}
