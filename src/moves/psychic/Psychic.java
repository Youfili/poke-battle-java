package moves.psychic;

import moves.Move;
import pokemon.Type;

public class Psychic extends Move {
    public Psychic() {
        super("Psychic",
                Type.PSYCHIC,
                20,
                "Psychic has a 10% chance of lowering the target's Special Defense by one stage.");
    }
}
