package moves.poison;

import moves.Move;
import pokemon.Type;

public class ToxicShot extends Move {
    public ToxicShot() {
        super("Toxic Shot",
                Type.POISON,
                26,
                "Toxic badly damage the target");
    }
}