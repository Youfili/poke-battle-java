//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import pokemon.Bulbasaur;
import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

//TEST

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.
//Test
public class JPokeBattle {
        public static void main(String[] arg){
            //DefaultMoves move = new Action();
            List<Pokemon> pokemon= new ArrayList<Pokemon>();
            pokemon.add(new Bulbasaur());
            pokemon.add(new Bulbasaur());
            //System.out.println(pokemon);
            pokemon.forEach( poke -> System.out.println(poke));

            // Prova Stampa Commit
            System.out.println("aaaaaaaaaaaaaa");
        }
}