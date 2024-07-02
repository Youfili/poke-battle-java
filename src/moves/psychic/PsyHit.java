package moves.psychic;

import moves.Move;
import pokemon.Type;

public class PsyHit extends Move {
    public PsyHit() {
        super("Psy Hit",
                Type.PSYCHIC,
                26,
                "Psybeam damage the target.");
    }
}
