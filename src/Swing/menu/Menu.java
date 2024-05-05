package Swing.menu;

import Swing.ChooseTeam;
import players.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height

            setLayout(null);

            //using no layout managers
            /*BufferedImage img = null;
            try {
                img = ImageIO.read(new File("/Users/leonardo/Desktop/wallpaper.jpg"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

            Image dimg = img.getScaledInstance(getWidth(), getHeight(),
                    Image.SCALE_SMOOTH);

            ImageIcon imageIcon = new ImageIcon(dimg);

            JLabel wallpaper= new JLabel("",imageIcon,JLabel.CENTER);
            wallpaper.setBounds(0,0,600,650);*/


            JButton startButton=new JButton("Nuova Partita");//creating instance of JButton
            startButton.setBounds(0,0,400,70);//x axis, y axis, width, height
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.setRootFrame(new ChooseTeam(new Player("Hash",0,0,"Male")));
                    setVisible(false);
                }
            });


            JButton continueButton=new JButton("Continua Partita");//creating instance of JButton
            startButton.setBounds(240,500,100,40);//x axis, y axis, width, height
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.setRootFrame(new ChooseTeam(new Player("Hash",0,0,"Male")));
                    setVisible(false);
                }
            });






            add(startButton); //adding button in JFrame
            add(continueButton); //adding button in JFrame

            //add(wallpaper);

            setVisible(true);//making the frame visible
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        }


    }
