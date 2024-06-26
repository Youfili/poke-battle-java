package swing.menuframe.battle.battleview;

import players.Player;

import javax.swing.*;
import java.awt.*;

// Pannello per la vittoria del giocatore
public class VictoryPanel extends JPanel {

    private Player winner; // Giocatore vincitore

    public VictoryPanel(Player winner) {
        this.winner = winner;

        setLayout(null);
        // lo faccio della stessa dimensione del frame
        setSize(600,650);//600 width and 650 height



        // Pannello per l'immagine del giocatore vincitore (sinistra)
        JPanel playerImagePanel = new JPanel();
        playerImagePanel.setLayout(new FlowLayout());
        JLabel playerImageLabel = new JLabel(winner.getImage());
        playerImagePanel.add(playerImageLabel);
        add(playerImagePanel, BorderLayout.WEST);

        // Pannello per i bottoni delle squadre Pokemon (sotto l'immagine)
        JPanel pokemonPanel = new JPanel();
        pokemonPanel.setLayout(new GridLayout(2, 3)); // 2 righe, 3 colonne

        // Aggiungi i bottoni delle squadre Pokemon (esempio)
        for (int i = 1; i <= 6; i++) {
            JButton pokemonButton = new JButton("Pokemon " + i);
            pokemonPanel.add(pokemonButton);
        }
        add(pokemonPanel, BorderLayout.CENTER);

        // Pannello per le informazioni del player che ha vinto (destra)
        JPanel playerInfoPanel = new JPanel();
        playerInfoPanel.setLayout(new BorderLayout());

        JTextArea playerInfoText = new JTextArea();
        playerInfoText.setText("Nome del giocatore: " + winner.getName() + "\nAltre informazioni...");
        playerInfoText.setEditable(false);
        playerInfoPanel.add(playerInfoText, BorderLayout.CENTER);

        add(playerInfoPanel, BorderLayout.EAST);

        // Pannello per il bottone "Torna al Menu" (in basso a destra)
        JPanel menuButtonPanel = new JPanel();
        menuButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton menuButton = new JButton("Torna al Menu");
        menuButtonPanel.add(menuButton);

        add(menuButtonPanel, BorderLayout.SOUTH);
    }

}
