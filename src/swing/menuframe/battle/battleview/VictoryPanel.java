package swing.menuframe.battle.battleview;

import players.Player;
import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Pannello per la vittoria del giocatore

public class VictoryPanel extends JPanel {

    private Player winner; // Giocatore vincitore
    private JButton menuButton;
    private JTextArea playerInfoText;
    private JTextArea pokemonInfoText;

    public VictoryPanel(Player winner) {
        this.winner = winner;

        setLayout(null);
        // lo faccio della stessa dimensione del frame
        setSize(600, 650); // 600 width and 650 height

        // Pannello per l'immagine del giocatore vincitore (sinistra)
        JPanel playerImagePanel = new JPanel();
        JLabel playerImageLabel = new JLabel();     // inizializzo poi lo implemento in base al gender

        // In base al gender scelgo quale immagine dell'allenatore selezionare
        if(winner.getGender().equals("Male")){
            playerImageLabel = new JLabel(new ImageIcon("src/Img/male_trainer_victory.png"));
        }else{
            playerImageLabel = new JLabel(new ImageIcon("src/Img/femaleTrainer.png"));

        }

        playerImagePanel.setBounds(30, 30, 300, 400);
        playerImagePanel.add(playerImageLabel);
        add(playerImagePanel);

        // Pannello per i bottoni delle squadre Pokemon (sotto l'immagine)
        JPanel pokemonPanel = new JPanel();
        pokemonPanel.setBounds(30, 440, 300, 150); // Posizionato sotto l'immagine del giocatore
        pokemonPanel.setLayout(new GridLayout(2, 3)); // 2 righe, 3 colonne

        // Aggiungi i bottoni delle squadre Pokemon (esempio)
        for (int i = 0; i < winner.getTeam().size(); i++) {
            Pokemon pokemonIterazioneAttuale = winner.getTeam().get(i);
            JButton pokemonButton = new JButton(new ImageIcon(pokemonIterazioneAttuale.getImagePath()));
            pokemonButton.setEnabled(true);
            // MouseListener
            pokemonButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    pokemonInfoText.setText(pokemonIterazioneAttuale.toString());
                }
            });
            // ActionListener
            pokemonButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pokemonInfoText.setText(pokemonIterazioneAttuale.toString());
                }
            });

            // Aggiungo il bottone al pannello
            pokemonPanel.add(pokemonButton);
        }
        add(pokemonPanel);

        // Pannello per le informazioni del player che ha vinto (destra)
        JPanel playerInfoPanel = new JPanel();
        playerInfoPanel.setLayout(new BorderLayout());
        playerInfoPanel.setBounds(350, 30, 220, 180); // Ridimensionato
        JLabel playerInfoLabel = new JLabel("Informazioni Giocatore");
        playerInfoPanel.add(playerInfoLabel, BorderLayout.NORTH);
        // Inserisco un area di testo al suo interno
        playerInfoText = new JTextArea();
        playerInfoText.setText(winner.playerInfo()); // inserisco le informazioni del player
        playerInfoText.setEditable(false);
        playerInfoPanel.add(new JScrollPane(playerInfoText), BorderLayout.CENTER);
        add(playerInfoPanel);

        // Pannello per le informazioni del Pokemon selezionato (sotto l'informazione del player)
        JPanel pokemonInfoPanel = new JPanel();
        pokemonInfoPanel.setLayout(new BorderLayout());
        pokemonInfoPanel.setBounds(350, 220, 220, 200); // Posizionato sotto l'informazione del player
        JLabel pokemonInfoLabel = new JLabel("Informazioni Pokemon");
        pokemonInfoPanel.add(pokemonInfoLabel, BorderLayout.NORTH);
        // Inserisco un area di testo al suo interno
        pokemonInfoText = new JTextArea();
        pokemonInfoText.setEditable(false);
        pokemonInfoPanel.add(new JScrollPane(pokemonInfoText), BorderLayout.CENTER);
        add(pokemonInfoPanel);

        // Pannello per il bottone "Torna al Menu" (in basso a destra)



        menuButton = new JButton("Torna al Menu");
        menuButton.setBounds(370, 500, 200, 70); // Posizionato in basso a destra

        add(menuButton);
    }

    public JButton getMenuButton() {
        return menuButton;
    }
}
