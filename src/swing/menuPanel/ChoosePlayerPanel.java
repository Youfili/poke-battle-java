package swing.menuPanel;

/*
 Creo una classe apparte per il pannello
 */

import javax.swing.*;
        import java.awt.*;

public class ChoosePlayerPanel extends JPanel {

    private ImageBackgroundButton maleButton, femaleButton;
    private JButton continueToChooseTeamButton, backToGameSelect;

    public ChoosePlayerPanel(BorderLayout borderLayout) {
        super(borderLayout);

        maleButton = new ImageBackgroundButton("", "src/Img/male_trainer.png");
        femaleButton = new ImageBackgroundButton("", "src/Img/femaleTrainer.png");
        continueToChooseTeamButton = new JButton("Choose your Team");
        backToGameSelect = new JButton("Back...");

        // Inizializzo il JComboBox con le opzioni "Player 1" e "Player 2" --> Devono essere scelte tutte e due per continuare
//        String[] players = {"Player 1", "Player 2"};            // faccio un array di stringhe dove vado a inserire nella tendina le opzioni
//        selectGamePlayer = new JComboBox<>(players);

        // Male Button
        maleButton.setBackground(Color.CYAN);
//        maleButton.setFont(new Font("Arial", Font.ITALIC, 100));
//        maleButton.setSize(350, 550);
//
        // Female Button
        femaleButton.setBackground(Color.PINK);
//        femaleButton.setFont(new Font("Arial", Font.ITALIC, 100));
//        femaleButton.setSize(350, 550);

        // Pannello per i pulsanti al centro --> Aggiungo questo pannello cosi da centrare i pulsanti --> Pannello GridLayout a sua volta nel BorderLayout
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 riga, 2 colonne, 10px di gap orizzontale e verticale
        centerPanel.add(maleButton);
        centerPanel.add(femaleButton);

        // Aggiunta del pannello centrale al BorderLayout
        this.add(centerPanel, BorderLayout.CENTER);


        // Aggiunta dei pulsanti per il menu e la selezione del giocatore
        JPanel buttonChoicePanel = new JPanel(new GridLayout(1,2));         // Creo il pannello per i tasti della scelta
        // Modifico i bottoni
        backToGameSelect.setFont(new Font("Choose your Team", Font.ITALIC,20));
        continueToChooseTeamButton.setFont(new Font("Back to choose Game", Font.ITALIC, 15));


        buttonChoicePanel.add(backToGameSelect);
        buttonChoicePanel.add(continueToChooseTeamButton);          // aggiungo al pannello dei bottoni il bottone per scegliere di proseguire alla scelta del team

        buttonChoicePanel.setPreferredSize(new Dimension(400, 30));  //
        this.add(buttonChoicePanel, BorderLayout.SOUTH);

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

    public JButton getBackToGameSelect() { return backToGameSelect;}
}
