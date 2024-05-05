package Swing.menu;

import Swing.ChooseTeam;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePlayerPanel extends JPanel {

    private Player choosenPlayer;
    private String name;


    public ChoosePlayerPanel() {

        setLayout(null);

        // Create Male Button
        JButton maleButton = new JButton("Male");//creating instance of JButton
        maleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
        maleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choosenPlayer = new Player("",0,0,"Male");
                choosenPlayer.setName(JOptionPane.showInputDialog("nome"));
                //System.out.println(choosenPlayer);
                //JOptionPane.setRootFrame(new ChooseTeam(choosenPlayer));
                //setVisible(false);
            }
        });


        // Create feMale Button
        JButton femaleButton = new JButton("Female");//creating instance of JButton
        femaleButton.setBounds(240, 200, 100, 40);//x axis, y axis, width, height
        femaleButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                choosenPlayer = new Player("",0,0,"Female");
                choosenPlayer.setName(JOptionPane.showInputDialog("nome"));
                System.out.println(choosenPlayer);
                //JOptionPane.setRootFrame(new ChooseTeam(choosenPlayer));
                setVisible(false);
            }
        });


        // Set color background of the buttons
        maleButton.setBackground(Color.BLUE);
        maleButton.setBorder(BorderFactory.createLineBorder(Color.black)); // Simple Line Border
        femaleButton.setBackground(Color.RED);
        femaleButton.setBorder(BorderFactory.createLineBorder(Color.yellow)); // Simple Line Border

        add(maleButton);
        add(femaleButton);

        // Commento per vedere il commit
        // Comment commit online
    }
    public Player getChoosenPlayer() {
        return choosenPlayer;
    }
}
