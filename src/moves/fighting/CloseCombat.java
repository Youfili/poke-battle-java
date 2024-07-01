package moves.fighting;

import moves.Move;
import pokemon.Type;

public class CloseCombat extends Move {
    public CloseCombat() {
        super("Close Combat",
                Type.FIGHTING,
                28,
                "Close Combat lowers the user's Defense and Special Defense by one stage each after use.");
    }
}
