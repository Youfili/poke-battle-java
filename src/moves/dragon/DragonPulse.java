package moves.dragon;

import moves.Move;
import pokemon.Type;

public class DragonPulse extends Move {
    public DragonPulse() {
        super("Dragon Pulse",
                Type.DRAGON,
                32,
                "Dragon Pulse deals damage and has no additional effect.");
    }
}
