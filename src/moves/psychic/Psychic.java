package moves.psychic;

import moves.Move;
import pokemon.Type;

public class Psychic extends Move {
    public Psychic() {
        super("Psychic",
                Type.PSYCHIC,
                17,
                "Psychic hit the target");
    }
}
