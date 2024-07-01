package moves.electric;

import moves.Move;
import pokemon.Type;

public class Thunder extends Move {
    public Thunder() {
        super("Thunder",
                Type.ELECTRIC,
                17,
                "Thunder has a 30% chance of paralyzing the target.");
    }
}
