package moves.water;

import moves.Move;
import pokemon.Type;

public class Surf extends Move {
    public Surf() {
        super("Surf",
                Type.WATER,
                26,
                "Surf deals damage the target.");
    }
}
