package swing.menuFrame.battle;

import players.Player;

import javax.swing.*;
import java.awt.*;

/*
Creo questo pannello per avere in tempo reale il punteggio delle partite giocate, quando uno dei due giocatori arriva a 3 vittorie
terminano le Battaglie, si salvano i progressi e poi si decide se svolgere altri combattimenti (da capo) o chiudere il gioco

 Implementato con i bottoni, sicuramente si può fare in un modo migliore

 */
public class ScoreOfBattles extends JPanel {

    Player player1, player2;
    int score1 = 0, score2 = 0;
    JButton scoreButton1, scoreButton2, vsButton;
    // Costruttore
    public ScoreOfBattles(Player player1, Player player2){
        super();                        // richiamo il costruttore di JPanel
        this.player1 = player1;
        this.player2 = player2;

        this.setSize(250, 100);                       // Imposto le dimensione del pannello
        setLayout(new GridLayout(1,3));                 // una riga e due colonne

        // Imposto i Bottoni dello Score
        scoreButton1 = new JButton("" + score1);
        scoreButton2 = new JButton("" + score2);
        vsButton = new JButton();

        // Disabilito i pulsanti (non cliccabili)
        scoreButton1.setEnabled(false);
        scoreButton2.setEnabled(false);
        vsButton.setEnabled(false);

        // Modifico i Pulsanti
        vsButton.setIcon(new ImageIcon("src/Img/vs.png"));    // Icona del VS
        // Setto il font del numero che contengono e inserisco l'icona
        scoreButton1.setFont(new Font("", Font.ITALIC, 15));
        scoreButton2.setFont(new Font("", Font.ITALIC, 15));

        // Imposto lo sfondo del conteggio (in base al sesso del player selezionato)
        // BACKGROUN PLAYER1
        if(player1.getGender().equals("Male"))
            scoreButton1.setBackground(Color.CYAN);
        else if(player1.getGender().equals("Female"))
            scoreButton1.setBackground(Color.PINK);

        // BACKGROUN PLAYER2
        if(player2.getGender().equals("Male"))
            scoreButton1.setBackground(Color.CYAN);
        else if(player2.getGender().equals("Female"))
            scoreButton1.setBackground(Color.PINK);


        // Imposto la dimensione dei pulsanti in modo proporzionato a come voglio visualizzarle
        scoreButton1.setPreferredSize(new Dimension(70,100));
        scoreButton2.setPreferredSize(new Dimension(70,100));
        vsButton.setPreferredSize(new Dimension(100,100));

        // Aggiungo i bottoni al pannello
        this.add(scoreButton1);
        this.add(vsButton);
        this.add(scoreButton2);








    }   // FINE COSTRUTTORE

    // Getters e Setters dei Metodi
    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public JButton getScoreButton1() {
        return scoreButton1;
    }

    public JButton getScoreButton2() {
        return scoreButton2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }
}
