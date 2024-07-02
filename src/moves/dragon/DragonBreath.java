package moves.dragon;

import moves.Move;
import pokemon.Type;

public class DragonBreath extends Move {
    public DragonBreath() {
        super("Dragon Breath",
                Type.DRAGON,
                18,
                "Dragon Breath hit the target.");
    }
}
