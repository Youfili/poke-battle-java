package Swing.menuFrame.battle;

import moves.Move;
import pokemon.Pokemon;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PokePanel extends JPanel {
    private Pokemon pokemon;
    public PokePanel(Pokemon pokemon) {
        super(new GridLayout(2,2));
        this.pokemon = pokemon;

        //teamPanel.add(tm);
       setBounds(270,500,300,100);
       setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

       for(Move move : pokemon.getMoves()) {
           JButton moveButton = new JButton(move.getName());
               //moveButton.addActionListener(e -> {}); DA IMPLEMENTARE
           add(moveButton);
       }


       setVisible(true);
    }
}
