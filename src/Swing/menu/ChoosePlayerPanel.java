package Swing.menu;

import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePlayerPanel extends JPanel {

    private Player choosenPlayer;
    private String name;


    public ChoosePlayerPanel() {

        // Create Male Button
        JButton maleButton = new JButton("Male");//creating instance of JButton
        maleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
        maleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.setRootFrame(new Menu());
                setVisible(false);
            }
        });


        // Create Male Button
        JButton femaleButton = new JButton("Female");//creating instance of JButton
        femaleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
        femaleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.setRootFrame(new Menu());
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

    }
}
