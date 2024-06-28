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
        // ci setto la mossa
        this.bottoneMossa1.setMove(pokemonInCampo.getMoves().get(0));
        // ci setto il testo del bottone
        this.bottoneMossa1.setText("" + pokemonInCampo.getMoves().get(0));

        // ci setto la mossa
        this.bottoneMossa2.setMove(pokemonInCampo.getMoves().get(1));
        // ci setto il testo del bottone
        this.bottoneMossa2.setText("" + pokemonInCampo.getMoves().get(1));

        // ci setto la mossa
        this.bottoneMossa3.setMove(pokemonInCampo.getMoves().get(2));
        // ci setto il testo del bottone
        this.bottoneMossa3.setText("" + pokemonInCampo.getMoves().get(2));

        // ci setto la mossa
        this.bottoneMossa4.setMove(pokemonInCampo.getMoves().get(3));
        // ci setto il testo del bottone
        this.bottoneMossa4.setText("" + pokemonInCampo.getMoves().get(3));



        // Aggiorno la grafica dei bottoni per riflettere le nuove mosse
        this.bottoneMossa1.repaint();
        this.bottoneMossa2.repaint();
        this.bottoneMossa3.repaint();
        this.bottoneMossa4.repaint();
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
