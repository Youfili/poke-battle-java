package Swing.menuFrame;

import players.Player;
import pokemon.Bulbasaur;
import pokemon.Pokemon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/*
IMPLEMENTARE VARIE CLASSI PANNELLI OGNUNA CON RELATIVE INFORMAZIONI E PULSANTI
METTERLE POI IN COLLEGAMENTO IN QUESTO FRAME
 */
public class ChooseTeam extends JFrame {

    private List<Pokemon> pokemon=new ArrayList<Pokemon>();
    private Player player;
    private JPanel pokeInfoPanel;
    private JTextArea pokeInfoTextArea;

    public ChooseTeam(Player player) {

        this.player=player;
        setSize(600,650);//400 width and 500 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);

        //lista pokemon .. magari prendere da una classe Pokedex
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());



        //pannelli da aggiungere al frame : L'idea sarebbe creare tre pannelli
        // (scelta pokemon |
        // info pokemon selezionato |
        // info allenatore con visualizzazione  della squadra che si aggiorna man mano che selzioniamo o meno pokemon
        pokeInfoPanel=new JPanel();
        pokeInfoTextArea=new JTextArea();






        int x=0;
        int y=0;
        for (Pokemon poke : pokemon) {

            Image dimg = poke.getImage().getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            // Bottone dei Pokemon
            JCheckBox startButton = new JCheckBox(poke.getName());//creating instance of JButton --> Return pokemon name
            startButton.setBounds(x,y, 200, 50);//x axis, y axis, width, height
            startButton.setIcon(imageIcon);
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog((Component) null, poke.toString(), null, JOptionPane.INFORMATION_MESSAGE, imageIcon);

                    if(startButton.isSelected()){
                        player.addPokemon(poke);
                    }else{
                        player.removePokemon(poke);
                    }
                    repaint();
                }
            });

            y+=50;
            add(startButton);
        }

        // Bottone del giocatore
        JButton playerButton=new JButton();//creating instance of JButton
        playerButton.setBounds(450,500,100,75);//x axis, y axis, width, height

        // Controllo se il Gender = Maschio
        if(player.getGender().equals("Male")){
            playerButton.setIcon(player.getImage());
            playerButton.setBackground(Color.CYAN);
            playerButton.setBorder(BorderFactory.createLineBorder(Color.BLUE)); // Simple Line Border
        }else{
            playerButton.setIcon(player.getImage());
            playerButton.setBackground(Color.PINK);
            playerButton.setBorder(BorderFactory.createLineBorder(Color.RED)); // Simple Line Border
        }
        // Aggiungo l' Action Listener al player
        playerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog((Component) null, player.toString(), null, JOptionPane.INFORMATION_MESSAGE);

            }


        });

        //add(pokeInfoTextArea, BorderLayout.CENTER);//Posizione relativa
        add(playerButton);//adding button in JFrame

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);


    }
    public void setPlayer(Player player) {
        this.player=player;
    }
}
