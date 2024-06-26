package swing.menupanel;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FrameProvaPlayersSavedPanel extends JFrame {

    public FrameProvaPlayersSavedPanel() {
        setTitle("Players Saved Panel Example");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creazione di giocatori di esempio
        List<Player> players = createSamplePlayers(); // Da implementare

        // Creazione del pannello dei giocatori salvati
        PlayersSavedPanel playersSavedPanel = new PlayersSavedPanel(players);
        playersSavedPanel.setBounds(0, 0, 600, 650);

        // Aggiunta del pannello al frame principale
        add(playersSavedPanel);

        setVisible(true);
    }

    // Funzione di esempio per creare giocatori
    private List<Player> createSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", 10, 5, "Male"));
        players.add(new Player("Player 2", 8, 7, "Female"));
        players.add(new Player("Player 3", 15, 3, "Male"));
        // Aggiungi altri giocatori se necessario
        return players;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrameProvaPlayersSavedPanel());
    }
}
