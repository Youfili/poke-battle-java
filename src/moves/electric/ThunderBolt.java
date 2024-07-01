package moves.electric;

import moves.Move;
import pokemon.Type;

public class ThunderBolt extends Move {
    public ThunderBolt() {
        super("Thunderbolt",
                Type.ELECTRIC,
                22,
                "Thunderbolt has a 10% chance of paralyzing the target.");
    }
}
