package moves.base;

import moves.Move;

import java.util.ArrayList;

public class DefaultMoves extends Move{
    ArrayList<Move> moves = new ArrayList<Move>();
    private String name;
    private int damage;
    private String description;
    private int pp;

    public DefaultMoves(String name, int damage,int pp, String description) {

       super( name,  damage, pp,  description);

    }


}
