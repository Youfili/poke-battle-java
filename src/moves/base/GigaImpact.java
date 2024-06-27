package moves.base;

import pokemon.Type;

public class GigaImpact extends DefaultMoves{
    public GigaImpact() {
        super("GigaImpact",
                Type.NORMAL,
                100,
                25,
                "GigaImpact is a high-powered move that requires a recharge turn after use" +
                " moves a Pokémon learns. It deals damage with no additional effects.");

    }
}
