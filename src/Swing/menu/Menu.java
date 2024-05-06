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

            gameSelect = new JPanel();
            choosePlayerPanel = new JPanel();

            maleButton = new JButton("Male");//creating instance of JButton
            //maleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
            choosePlayerPanel.add(maleButton);

            femaleButton = new JButton("Female");
            //femaleButton.setBounds(240, 200, 100, 40);//x axis, y axis, width, height
            choosePlayerPanel.add(femaleButton);


            gameSelect.setLayout(null);

            //giocatore di prova

            JPanel panels = new JPanel(new CardLayout());
            panels.add(gameSelect, "Panel 1");
            panels.add(choosePlayerPanel, "Panel 2");




            Container pane = this.getContentPane();
            pane.add(panels, BorderLayout.CENTER);
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




            //cl.show(pane, "Panel 1");
            Image img = null;
            try {
                img = ImageIO.read(new File("src/Img/maleTrainer.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Image dimg = img.getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            maleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = JOptionPane.showInputDialog("Inserisci nome: ");
                    player = new Player(name,0,0,"Male");

                    player.setImage(imageIcon);
                    chooseTeam=new ChooseTeam( player);
                    setVisible(false);
                    //panels.add(chooseTeam, "Panel 3");
                    //cl.next(panels);
                }

            });
            femaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player = new Player("",0,0,"Female");
                    chooseTeam=new ChooseTeam( player);
                    panels.add(chooseTeam, "Panel 3");
                    cl.next(panels);                }
            });






            JButton startButton=new JButton("Nuova Partita");//creating instance of JButton
            startButton.setBounds(115,350,350,85);//x axis, y axis, width, height
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //gameSelect.setVisible(false);
                    //choosePlayerPanel.setVisible(true);    // set visibile of panel choose "False"
cl.next(panels);                    //cards.remove(gameSelect);
                    //player=choosePlayerPanel.getChoosenPlayer();
                    //cards.remove(choosePlayerPanel);
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