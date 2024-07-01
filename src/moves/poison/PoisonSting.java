package moves.poison;

import moves.Move;
import pokemon.Type;

public class PoisonSting extends Move {
    public PoisonSting() {
        super("Poison Sting",
                Type.POISON,
                20,
                "Poison Sting has a 30% chance of poisoning the target.");
    }
}
