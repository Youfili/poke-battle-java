package Swing.menuPanel;

import Swing.menuFrame.ChooseTeam;
import players.Player;

/*
 Creo una classe apparte per il pannello
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ChoosePlayerPanel extends JPanel {

    private ImageBackgroundButton maleButton, femaleButton;
    private JButton continueToChooseTeamButton;
    private JComboBox<String> selectGamePlayer;

    public ChoosePlayerPanel(BorderLayout borderLayout) {
        super(borderLayout);

        maleButton = new ImageBackgroundButton("", "src/Img/male_trainer.png");
        femaleButton = new ImageBackgroundButton("", "src/Img/femaleTrainer.png");
        continueToChooseTeamButton = new JButton("Continue for Choose your Team");
//        // Inizializzo il JComboBox con le opzioni "Player 1" e "Player 2" --> Devono essere scelte tutte e due per continuare
//        String[] players = {"Player 1", "Player 2"};            // faccio un array di stringhe dove vado a inserire nella tendina le opzioni
//        selectGamePlayer = new JComboBox<>(players);

        // Male Button
        maleButton.setBackground(Color.CYAN);
        maleButton.setFont(new Font("Arial", Font.ITALIC, 60));
        maleButton.setSize(350, 550);

        // Female Button
        femaleButton.setBackground(Color.PINK);
        femaleButton.setFont(new Font("Arial", Font.BOLD, 60));
        femaleButton.setSize(350, 550);

        // Pannello per i pulsanti al centro --> Aggiungo questo pannello cosi da centrare i pulsanti --> Pannello GridLayout a sua volta nel BorderLayout
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 riga, 2 colonne, 10px di gap orizzontale e verticale
        centerPanel.add(maleButton);
        centerPanel.add(femaleButton);

        // Aggiunta del pannello centrale al BorderLayout
        this.add(centerPanel, BorderLayout.CENTER);

        // Aggiunta dei pulsanti per il menu e la selezione del giocatore
        this.add(continueToChooseTeamButton, BorderLayout.SOUTH);

//        // modifico il selectGamePlayer per centrare il testo "Player 1" e "Player" scritta al centro del JComboBox
//        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
//        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
//        selectGamePlayer.setRenderer(listRenderer);
//        this.add(selectGamePlayer, BorderLayout.NORTH);
    }

    public JButton getMaleButton() {
        return maleButton;
    }

    public JButton getFemaleButton() {
        return femaleButton;
    }

    public JButton getContinueToChooseTeamButton() {
        return continueToChooseTeamButton;
    }

    public JComboBox<String> getSelectGamePlayer() {
        return selectGamePlayer;
    }
}
