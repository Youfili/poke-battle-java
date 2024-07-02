package moves.psychic;

import moves.Move;
import pokemon.Type;

public class Confusion extends Move {
    public Confusion() {
        super("Confusion",
                Type.PSYCHIC,
                24,
                "Confusion hit the target.");
    }
}
