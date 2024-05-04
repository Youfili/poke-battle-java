package moves.base;
import pokemon.*;
import moves.Move;

import java.util.ArrayList;
import java.util.List;

public class Action extends DefaultMoves {
    public Action() {
        super("Action",10,20,"Normal action");
    }

    public static void main(String[] arg){
        //DefaultMoves move = new Action();
        List<Pokemon> pokemon= new ArrayList<Pokemon>();
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        System.out.println(pokemon);
        pokemon.forEach( poke -> System.out.println(poke.getMoves()));
    }
}
