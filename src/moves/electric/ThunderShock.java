package moves.electric;

import moves.Move;
import pokemon.Type;

public class ThunderShock extends Move {
    public ThunderShock() {
        super("Thunder Shock",
                Type.ELECTRIC,
                28,
                "Thunder Shock has a 10% chance of paralyzing the target.");
    }
}
