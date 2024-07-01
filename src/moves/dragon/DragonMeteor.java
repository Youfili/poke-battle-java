package moves.dragon;

import moves.Move;
import pokemon.Type;

public class DragonMeteor extends Move {
    public DragonMeteor() {
        super("Draco Meteor",
                Type.DRAGON,
                32,
                "Draco Meteor lowers the user's Special Attack by two stages after use.");
    }
}
