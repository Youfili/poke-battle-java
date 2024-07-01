package moves.psychic;

import moves.Move;
import pokemon.Type;

public class Confusion extends Move {
    public Confusion() {
        super("Confusion",
                Type.PSYCHIC,
                28,
                "Confusion has a 10% chance of confusing the target.");
    }
}
