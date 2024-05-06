package Swing.menuPanel;

import Swing.menuFrame.ChooseTeam;
import players.Player;

/*
 Creo una classe apparte per il pannello
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ChoosePlayerPanel extends JPanel {

    private JButton maleButton, femaleButton;

    public ChoosePlayerPanel(GridLayout gridLayout){
        super(gridLayout);

        maleButton = new JButton("Male");//creating instance of JButton
        maleButton.setBackground(Color.CYAN);
        maleButton.setFont(new Font("Arial", Font.ITALIC, 60)); // Imposta il font del testo
        maleButton.setSize(450, 450);
//            maleButton.setBounds(240, 500, 100, 40);//x axis, y axis, width, height
        this.add(maleButton);      // aggiungo il pulsante al pannello

        femaleButton = new JButton("Female");
        femaleButton.setBackground(Color.PINK);
        femaleButton.setFont(new Font("Arial", Font.BOLD, 60)); // Imposta il font del testo
        femaleButton.setSize(450, 450);
//            femaleButton.setBounds(240, 200, 100, 40);//x axis, y axis, width, height
        this.add(femaleButton);
    }           // Fine Costruttore

    public JButton getMaleButton() {
        return maleButton;
    }

    public JButton getFemaleButton() {
        return femaleButton;
    }
}
