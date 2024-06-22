package swing.menuframe.battle.battleview;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PokePanel extends JPanel {
    private Pokemon pokemon;
    // Bottoni che riprendo nel frame principale
    private JButton bottoneMossa1;
    private JButton bottoneMossa2;
    private JButton bottoneMossa3;
    private JButton bottoneMossa4;



    public PokePanel(Pokemon pokemon) {
        super(new GridLayout(2,2));
        this.pokemon = pokemon;

        //teamPanel.add(tm);
       setBounds(270,500,300,100);
       setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

       // Riempio il pannello con le 4 mosse del Pokemon
//       for(Move move : pokemon.getMoves()) {
//           JButton moveButton = new JButton(move.getName());
//               moveButton.addActionListener(e -> {}); DA IMPLEMENTARE
//           add(moveButton);
//       }

        // Creo i Bottoni del Pannello del Pokemon
        bottoneMossa1 = new JButton(this.pokemon.getMoves().get(0).getName());
        bottoneMossa2 = new JButton(this.pokemon.getMoves().get(1).getName());
        bottoneMossa3 = new JButton(this.pokemon.getMoves().get(2).getName());
        bottoneMossa4 = new JButton(this.pokemon.getMoves().get(3).getName());

        // Aggiungo i bottoni al pannello del azione pokemon
        this.add(bottoneMossa1);
        this.add(bottoneMossa2);
        this.add(bottoneMossa3);
        this.add(bottoneMossa4);

       setVisible(true);
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
