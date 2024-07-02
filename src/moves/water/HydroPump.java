package moves.water;

import moves.Move;
import pokemon.Type;

public class HydroPump extends Move {
    public HydroPump() {
        super("Hydro Pump",
                Type.WATER,
                30,
                "Hydro Pump deals damage with no additional effect.");
    }
}
