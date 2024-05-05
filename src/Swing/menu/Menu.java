package Swing.menu;

import Swing.ChooseTeam;
import players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {

        private JPanel gameSelect;
        private ChoosePlayerPanel choosePlayerPanel;
        private ChooseTeam chooseTeam;
        private Player player;

        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height
            gameSelect = new JPanel();
            choosePlayerPanel = new ChoosePlayerPanel();

            gameSelect.setLayout(null);

            JPanel cards = new JPanel(new CardLayout());
            cards.add(gameSelect, "Panel 1");
            cards.add(choosePlayerPanel, "Panel 2");
            chooseTeam=new ChooseTeam();
            cards.add(chooseTeam, "Panel 3");

            Container pane = this.getContentPane();
            pane.add(cards, BorderLayout.CENTER);



            JButton startButton=new JButton("Nuova Partita");//creating instance of JButton
            startButton.setBounds(115,350,350,85);//x axis, y axis, width, height
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //gameSelect.setVisible(false);
                    //choosePlayerPanel.setVisible(true);    // set visibile of panel choose "False"
                    CardLayout cl = (CardLayout)(cards.getLayout());
                    cl.next(cards);
                    player=choosePlayerPanel.getChoosenPlayer();


                    //pane.add(choosePlayerPanel);
                    //JOptionPane.setRootFrame(new ChooseTeam(player));
                    //setVisible(false);
                    chooseTeam.setPlayer(player);
                    cl.next(cards);
                }
            });


            JButton continueButton=new JButton("Continua Partita");//creating instance of JButton
            continueButton.setBounds(115,250,350,85);//x axis, y axis, width, height
            continueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementare
                }
            });






            // Set color background of the buttons
            startButton.setBackground(Color.GREEN);
            startButton.setBorder(BorderFactory.createLineBorder(Color.blue)); // Simple Line Border
            continueButton.setBackground(Color.BLUE);
            continueButton.setBorder(BorderFactory.createLineBorder(Color.yellow)); // Simple Line Border

            // Add the button on the Frame
            gameSelect.add(startButton); //adding button in JFrame
            gameSelect.add(continueButton); //adding button in JFrame


            setVisible(true);//making the frame visible
//            choosePlayerPanel.setVisible(false);    // set visibile of panel choose "False"
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        }


    }


    // Commento per vedere il commit