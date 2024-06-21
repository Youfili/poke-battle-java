package swing.menuFrame.battle.pannelloGioco;

import players.Player;

import javax.swing.*;
import java.awt.*;

public class PannelloCambioPokemon extends JPanel {

    private Player playerDelPannello;

    // Dichiaro i bottoni dei pokemon nel pannello cambio pokemon
    private JButton bottonePokemon1;
    private JButton bottonePokemon2;
    private JButton bottonePokemon3;
    private JButton bottonePokemon4;
    private JButton bottonePokemon5;
    private JButton bottonePokemon6;

    public PannelloCambioPokemon(Player playerInGioco){

        this.setBounds(245,500,345,100);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        // Imposto il layout del pannello
        this.setLayout(new GridLayout(1,6,2,2));

        this.playerDelPannello = playerInGioco;

        // Bottoni per il cambio di pokemon --> Me li preparo di default con tutti i pokemon disponibili!
        this.bottonePokemon1 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(0).getImagePath()));
        this.bottonePokemon2 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(1).getImagePath()));
        this.bottonePokemon3 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(2).getImagePath()));
        this.bottonePokemon4 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(3).getImagePath()));
        this.bottonePokemon5 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(4).getImagePath()));
        this.bottonePokemon6 = new JButton(new ImageIcon(playerDelPannello.getTeam().get(5).getImagePath()));

        // Aggiungo i bottoni al pannello del Cambio Pokemon
        this.add(bottonePokemon1);
        this.add(bottonePokemon2);
        this.add(bottonePokemon3);
        this.add(bottonePokemon4);
        this.add(bottonePokemon5);
        this.add(bottonePokemon6);

    }   // Fine Costruttore

    // Setters usati per modificare i tasti dei pokemon con i bottoni disponibili o meno

    public JButton getBottonePokemon1() {
        return bottonePokemon1;
    }

    public void setBottonePokemon1(JButton bottonePokemon1) {
        this.bottonePokemon1 = bottonePokemon1;
    }

    public JButton getBottonePokemon2() {
        return bottonePokemon2;
    }

    public void setBottonePokemon2(JButton bottonePokemon2) {
        this.bottonePokemon2 = bottonePokemon2;
    }

    public JButton getBottonePokemon3() {
        return bottonePokemon3;
    }

    public void setBottonePokemon3(JButton bottonePokemon3) {
        this.bottonePokemon3 = bottonePokemon3;
    }

    public JButton getBottonePokemon4() {
        return bottonePokemon4;
    }

    public void setBottonePokemon4(JButton bottonePokemon4) {
        this.bottonePokemon4 = bottonePokemon4;
    }

    public JButton getBottonePokemon5() {
        return bottonePokemon5;
    }

    public void setBottonePokemon5(JButton bottonePokemon5) {
        this.bottonePokemon5 = bottonePokemon5;
    }

    public JButton getBottonePokemon6() {
        return bottonePokemon6;
    }

    public void setBottonePokemon6(JButton bottonePokemon6) {
        this.bottonePokemon6 = bottonePokemon6;
    }
}
