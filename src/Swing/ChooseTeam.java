package Swing;

import players.Player;
import pokemon.Bulbasaur;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseTeam extends JFrame {
    private List<Pokemon> pokemon=new ArrayList<Pokemon>();
    private Player player;
    public ChooseTeam(Player player) {
        this.player=player;
        setTitle("Choose Team");
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());
        pokemon.add(new Bulbasaur());


        setSize(600,650);//400 width and 500 height
        setLayout(null);//using no layout managers

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        int x=0;
        int y=0;
        for (Pokemon poke : pokemon) {

            JCheckBox startButton = new JCheckBox(poke.getName());//creating instance of JButton
            startButton.setBounds(x,y, 100, 40);//x axis, y axis, width, height

            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Image dimg = poke.getImage().getScaledInstance(60, 60,
                            Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);

                    JOptionPane.showMessageDialog((Component) null, poke.toString(), null, JOptionPane.INFORMATION_MESSAGE, imageIcon);

                    player.addPokemon(poke);
                }
            });
            y+=50;
            add(startButton);
        }

        JButton playerButton=new JButton(player.getName());//creating instance of JButton
        playerButton.setBounds(240,500,100,40);//x axis, y axis, width, height
        playerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog((Component) null, player.toString(), null, JOptionPane.INFORMATION_MESSAGE);

            }


        });
        add(playerButton);//adding button in JFrame
        setVisible(true);

    }
}
