package moves.dragon;

import moves.Move;
import pokemon.Type;

public class DragonBreath extends Move {
    public DragonBreath() {
        super("Dragon Breath",
                Type.DRAGON,
                25,
                "Dragon Breath has a 30% chance of paralyzing the target.");
    }
}
