package Swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//TEST SCHERMATA INIZIALE DI AVVIO

public class BackgroundImageJFrame extends JFrame {

    public BackgroundImageJFrame() {
        //creating instance of JFrame
        setSize(600,650);//400 width and 500 height

        setLayout(null);//using no layout managers
        BufferedImage img =null ;
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
        wallpaper.setBounds(0,0,600,650);


        JButton startButton=new JButton("START");//creating instance of JButton
        startButton.setBounds(240,500,100,40);//x axis, y axis, width, height
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.setRootFrame(new SelectGame());
                setVisible(false);
            }


        });

        add(startButton);//adding button in JFrame

        add(wallpaper);

        setVisible(true);//making the frame visible
    }


    public static void main(String[] args) {
    new BackgroundImageJFrame();
    }
}