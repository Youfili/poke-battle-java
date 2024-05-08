package Swing.menuFrame;

import Swing.menuPanel.ChoosePlayerPanel;
import Swing.menuPanel.GameSelectPanel;
import players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.BorderLayout.*;

public class Menu extends JFrame {

        private GameSelectPanel gameSelect;
        private ChoosePlayerPanel choosePlayerPanel;
        private ChooseTeam chooseTeam;
        private Player player;
        private JButton maleButton, femaleButton;

        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height
            setLocationRelativeTo(null);//centro dello schermo
            setResizable(false);
            setLayout(new BorderLayout());      // Layout del Menu

            // creo l'istanza di GameSelectPanel
            gameSelect = new GameSelectPanel(new GridLayout(2,1));      // Grid Layout con 3 colonne
            // Creo l'istanza di ChoosePlayerPanel
            choosePlayerPanel = new ChoosePlayerPanel(new GridLayout(1, 2)); // GridLayout con 2 righe e 1 colonna


//            // Questo comando mi toglie il Layout, invece devo metterlo Diversamente
//            gameSelect.setLayout(null);

            // Creo un panels di Cards, cosi posso muovermi nella cards
            JPanel panels = new JPanel(new CardLayout());
            panels.add(gameSelect, "Panel 1");
            panels.add(choosePlayerPanel, "Panel 2");



            // Aggiungo i Panelli (composti dalle carte) all'interno di un Conteiner
            Container pane = this.getContentPane();
            pane.add(panels, CENTER);                            // pannelli aggiunti al centro del Container
            CardLayout cl = (CardLayout)(panels.getLayout());


            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // GENDER BUTTON
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Icona Pokeball
            // IMMAGINE ICONA Pokeball --> ChoosePlayerPanel
            Image imgPokeball = null;
            try {
                imgPokeball = ImageIO.read(new File("src/Img/pokeball.png"));
            } catch (IOException er) {
                throw new RuntimeException(er);
            }

            Image dimgPokeball = imgPokeball.getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIconPokeball = new ImageIcon(dimgPokeball);

            // MALE Button
            JButton maleButton = choosePlayerPanel.getMaleButton();         // Istanzio il Bottone Maschile
            maleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String name = JOptionPane.showInputDialog("Inserisci nome: ");
                    if(name != null && !name.trim().isEmpty()) {
                        // IMMAGINE ICONA MASCHILE --> ChoosePlayerPanel
                        Image img = null;
                        try {
                            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
                        } catch (IOException er) {
                            throw new RuntimeException(er);
                        }
                        Image dimg = img.getScaledInstance(60, 60,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);

                        player = new Player(name, 0, 0, "Male");
                        player.setImage(imageIcon);
                        chooseTeam = new ChooseTeam(player);
                        setVisible(false);
                    }
                }
            });

            // FEMALE BUTTON
            JButton femaleButton = choosePlayerPanel.getFemaleButton();
            femaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String name = JOptionPane.showInputDialog(null,"Scegli il Nome: ", "Choose Name", JOptionPane.PLAIN_MESSAGE);

                    if(name != null && !name.trim().isEmpty()) {
                        // IMMAGINE ICONA FEMMINILE --> ChoosePlayerPanel
                        Image img = null;
                        try {
                            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
                        } catch (IOException er) {
                            throw new RuntimeException(er);
                        }
                        Image dimg = img.getScaledInstance(60, 60,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);

                        player = new Player(name, 0, 0, "Female");
                        player.setImage(imageIcon);
                        chooseTeam = new ChooseTeam(player);
                        setVisible(false);
                    }
                }
            });



//            // PANNELLO " gameSelect "
            JButton startButton = gameSelect.getStartButton();
//            startButton.setBounds(115,350,350,85);//x axis, y axis, width, height
            // Aggiungo il listener al mio StartButton
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cl.next(panels);
                }
            });

            JButton continueButton = gameSelect.getContinueButton();
//            continueButton.setBounds(115,250,350,85);//x axis, y axis, width, height
            // Aggiungo il listener al mio StartButton
            continueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementare
                }
            });


            setVisible(true);//making the frame visible
//            choosePlayerPanel.setVisible(false);    // set visibile of panel choose "False"
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        }


    }


    // Commento per vedere il commit