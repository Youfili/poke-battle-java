package Swing.menuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameSelectPanel extends JPanel {

    JButton startButton;
    JButton continueButton;


    public GameSelectPanel(GridLayout gridLayout){
        super(gridLayout);

        this.startButton = new JButton("New Game");
        this.continueButton = new JButton("Continua Partita");

        // Set color background of the buttons del Pannello gameSelect
        startButton.setBackground(Color.GREEN);
        startButton.setBorder(BorderFactory.createLineBorder(Color.blue)); // Simple Line Border
        continueButton.setBackground(Color.BLUE);
        continueButton.setBorder(BorderFactory.createLineBorder(Color.yellow)); // Simple Line Border

        // Add the button on the Panell
        this.add(startButton); //adding button on the GameSelectPanel
        this.add(continueButton); //adding button on the GameSelectPanel

    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getContinueButton() {
        return continueButton;
    }

}
