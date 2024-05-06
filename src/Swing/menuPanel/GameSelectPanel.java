package Swing.menuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelectPanel extends JPanel {

    private ImageBackgroundButton startButton, continueButton;
    // ImageBackGrounButton è una sottoclasse di Button, con l'aggiunto del parametro dell'immagine nel costruttore

    public GameSelectPanel(GridLayout gridLayout){
        super(gridLayout);

        // Creazione dei pulsanti con immagine e testo
        this.startButton = new ImageBackgroundButton("", "src/Img/new_Game_Edited.png");
        this.continueButton = new ImageBackgroundButton("", "src/Img/continue_Game_Edited.png");

        // Setting the BorderLine of the Button
        startButton.setBorder(BorderFactory.createLineBorder(Color.RED)); // Simple Line Border
        continueButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW)); // Simple Line Border

        // Aggiungi i pannelli dei pulsanti al pannello principale
        this.add(startButton); // Aggiungi il pannello del pulsante "New Game"
        this.add(continueButton); // Aggiungi il pannello del pulsante "Continue Game"
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
