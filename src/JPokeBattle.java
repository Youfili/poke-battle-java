//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import players.Player;
import pokemon.Bulbasaur;

//TEST

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.
//Test
public class JPokeBattle {
    public static void main(String[] arg) {

        Player hash = new Player("Hash",0,0,"Male");

        hash.addPokemon(new Bulbasaur());
        hash.addPokemon(new Bulbasaur());

        System.out.println(hash);
        System.out.println(hash.getPokemonInfo(1));

        hash.addPokemon(new Bulbasaur());

        System.out.println(hash);




        //pokemon.forEach(poke -> System.out.println(poke));


    }
}