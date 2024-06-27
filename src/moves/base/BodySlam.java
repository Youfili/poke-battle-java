package moves.base;

import pokemon.Type;

public class BodySlam extends DefaultMoves{
    public BodySlam(){
        super("Body Slam",
                Type.NORMAL,
                11,
                32,
                "Known for its chance to paralyze the target, Body Slam has been a staple move for many Normal-type Pokémon over the generations," +
                " moves a Pokémon learns. It deals damage with no additional effects.");
    }
}
