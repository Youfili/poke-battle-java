package moves.normal;

import moves.Move;
import pokemon.Type;

import java.util.ArrayList;

public class DefaultMoves extends Move{
    ArrayList<Move> moves = new ArrayList<Move>();
    private String name;
    private int damage;
    private String description;
    private int pp;
    private Type type;

    public DefaultMoves(String name,Type type, int damage, String description) {

       super( name, type, damage, description);

    }


}
