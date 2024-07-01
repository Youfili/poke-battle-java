package moves.fighting;

import moves.Move;
import pokemon.Type;

public class DynamicPunch extends Move {
    public DynamicPunch() {
        super("Dynamic Punch",
                Type.FIGHTING,
                22,
                "Dynamic Punch confuses the target if it hits.");
    }
}
