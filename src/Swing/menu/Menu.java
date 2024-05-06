package Swing.menu;

import Swing.BackgroundImageJFrame;
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

        private JPanel gameSelect;
        private JPanel choosePlayerPanel;
        private ChooseTeam chooseTeam;
        private Player player;
        private JButton maleButton, femaleButton;

        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height
            setLocationRelativeTo(null);//centro dello schermo
            setResizable(false);
            setLayout(new BorderLayout());

            gameSelect = new JPanel();
            choosePlayerPanel = new JPanel(new GridLayout(1, 2)); // GridLayout con 2 righe e 1 colonna

            maleButton = new JButton("Male");//creating instance of JButton
            maleButton.setBackground(Color.CYAN);
            maleButton.setFont(new Font("Arial", Font.ITALIC, 60)); // Imposta il font del testo
            maleButton.setSize(450, 450);
//            maleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
            choosePlayerPanel.add(maleButton);      // aggiungo il pulsante al pannello

            femaleButton = new JButton("Female");
            femaleButton.setBackground(Color.PINK);
            femaleButton.setFont(new Font("Arial", Font.BOLD, 60)); // Imposta il font del testo
            femaleButton.setSize(450, 450);
//            femaleButton.setBounds(240, 200, 100, 40);//x axis, y axis, width, height
            choosePlayerPanel.add(femaleButton);


            gameSelect.setLayout(null);


            // Creo un panels di Cards, cosi posso muovermi nella cards
            JPanel panels = new JPanel(new CardLayout());
            panels.add(gameSelect, "Panel 1");
            panels.add(choosePlayerPanel, "Panel 2");




            Container pane = this.getContentPane();
            pane.add(panels, CENTER);
            CardLayout cl = (CardLayout)(panels.getLayout());

            BufferedImage imgBackGround =null ;
            try {
                imgBackGround = ImageIO.read(new File("src/Img/wallpaper.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

            Image dimgB = imgBackGround.getScaledInstance(getWidth(), getHeight(),
                    Image.SCALE_SMOOTH);

            ImageIcon imageBack = new ImageIcon(dimgB);

            JLabel wallpaper= new JLabel("",imageBack,JLabel.CENTER);
            wallpaper.setBounds(0,0,600,650);
            wallpaper.setIcon(imageBack);



            // IMMAGINE ICONA MASCHILE --> ChoosePlayerPanel
            Image img = null;
            try {
                img = ImageIO.read(new File("src/Img/maleTrainer.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Image dimg = img.getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            // MALE BUTTON
            maleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Inserisci nome: ");
                    player = new Player(name,0,0,"Male");

                    player.setImage(imageIcon);
                    chooseTeam=new ChooseTeam( player);
                    setVisible(false);
                }

            });
            femaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Inserisci nome: ");
                    player = new Player(name,0,0,"Female");

                    player.setImage(imageIcon);
                    chooseTeam=new ChooseTeam( player);
                    setVisible(false);               }
            });





            // PANNELLO " gameSelect "
            JButton startButton=new JButton("Nuova Partita");//creating instance of JButton
            startButton.setBounds(115,350,350,85);//x axis, y axis, width, height
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cl.next(panels);
                }
            });

            JButton continueButton=new JButton("Continua Partita");//creating instance of JButton
            continueButton.setBounds(115,250,350,85);//x axis, y axis, width, height
            continueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementare
                }
            });

            // Set color background of the buttons del Pannello gameSelect
            startButton.setBackground(Color.GREEN);
            startButton.setBorder(BorderFactory.createLineBorder(Color.blue)); // Simple Line Border
            continueButton.setBackground(Color.BLUE);
            continueButton.setBorder(BorderFactory.createLineBorder(Color.yellow)); // Simple Line Border


            // Add the button on the Panell
            gameSelect.add(startButton); //adding button in JFrame
            gameSelect.add(continueButton); //adding button in JFrame

            setVisible(true);//making the frame visible
//            choosePlayerPanel.setVisible(false);    // set visibile of panel choose "False"
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        }


    }


    // Commento per vedere il commit