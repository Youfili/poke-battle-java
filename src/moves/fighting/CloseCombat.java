package moves.fighting;

import moves.Move;
import pokemon.Type;

public class CloseCombat extends Move {
    public CloseCombat() {
        super("Close Combat",
                Type.FIGHTING,
                24,
                "Close Combat hit the target");
    }
}
