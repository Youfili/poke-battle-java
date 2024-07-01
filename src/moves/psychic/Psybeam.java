package moves.psychic;

import moves.Move;
import pokemon.Type;

public class Psybeam extends Move {
    public Psybeam() {
        super("Psybeam",
                Type.PSYCHIC,
                25,
                "Psybeam has a 10% chance of confusing the target.");
    }
}
