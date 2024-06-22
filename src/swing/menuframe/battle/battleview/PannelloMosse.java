package swing.menuframe.battle.battleview;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PannelloMosse extends JPanel {

    private Pokemon pokemonInCampo;

    // Dichiaro i seguenti valori
    private MoveButton bottoneMossa1;
    private MoveButton bottoneMossa2;
    private MoveButton bottoneMossa3;
    private MoveButton bottoneMossa4;

    // Costruttore
    public PannelloMosse(Pokemon pokemonInCampo){

        this.setBounds(245,500,345,100);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        // Imposto il layout del pannello
        this.setLayout(new GridLayout(2, 2,5,5));

        this.pokemonInCampo = pokemonInCampo;

        // Bottoni del pannello mossa
        this.bottoneMossa1 = new MoveButton(pokemonInCampo.getMoves().get(0));
        this.bottoneMossa2 = new MoveButton(pokemonInCampo.getMoves().get(1));
        this.bottoneMossa3 = new MoveButton(pokemonInCampo.getMoves().get(2));
        this.bottoneMossa4 = new MoveButton(pokemonInCampo.getMoves().get(3));

        //Aggiungo i bottoni al pannello delle mosse
        this.add(bottoneMossa1);
        this.add(bottoneMossa2);
        this.add(bottoneMossa3);
        this.add(bottoneMossa4);
    }   // Fine Costruttore



    public void aggiornaMosse(){
        this.bottoneMossa1.setMove(pokemonInCampo.getMoves().get(0));
        this.bottoneMossa2.setMove(pokemonInCampo.getMoves().get(1));
        this.bottoneMossa3.setMove(pokemonInCampo.getMoves().get(2));
        this.bottoneMossa4.setMove(pokemonInCampo.getMoves().get(3));
    }

    // SetPokemon in campo per cambiare il pokemon che è in campo

    public void setPokemonInCampo(Pokemon pokemonInCampo) {
        this.pokemonInCampo = pokemonInCampo;
    }

    public JButton getBottoneMossa1() {
        return bottoneMossa1;
    }

    public JButton getBottoneMossa2() {
        return bottoneMossa2;
    }

    public JButton getBottoneMossa3() {
        return bottoneMossa3;
    }

    public JButton getBottoneMossa4() {
        return bottoneMossa4;
    }
}
