package moves.normal;

import pokemon.Type;

public class HyperBeam extends DefaultMoves{
    public HyperBeam() {
        super("Hyper Beam",
                Type.NORMAL,
                28,
                "Hyper Beam deals massive damage, but the user must recharge on the next turn.");
    }
}
