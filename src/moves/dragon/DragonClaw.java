package moves.dragon;

import moves.Move;
import pokemon.Type;

public class DragonClaw extends Move {
    public DragonClaw() {
        super("Dragon Claw",
                Type.DRAGON,
                28,
                "Dragon Claw deals damage and has no secondary effect.");
    }
}
