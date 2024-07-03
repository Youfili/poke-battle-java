package swing.menupanel;

import database.Database;
import players.Player;
import swing.menupanel.PlayersSavedPanel.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class PlayersSavedPanel extends JPanel {

    private JPanel playerButtonsPanel;
    private JTextArea playerInfoTextArea;
    private List<Player> listaGiocatoriSalvati;
    private Player player;
    private Player player1;
    private Player player2;
    private JButton bottoneConferma = new JButton();
    private JButton selectPlayerButton1 = new JButton("Player 1");
    private JButton selectPlayerButton2 = new JButton("Player 2");

    public PlayersSavedPanel(List<Player> players) {
        this.listaGiocatoriSalvati = players;

        System.out.println(listaGiocatoriSalvati);

        // Carica l'immagine di sfondo
        ImageIcon icon = new ImageIcon("src/Img/player_saved_wallpaper.png");
        Image backgroundImage = icon.getImage();

        // Usa BackgroundPanel come pannello principale
        BackgroundPanel backgroundPanel = new BackgroundPanel(backgroundImage);
        backgroundPanel.setLayout(null); // Disabilita il layout manager di default
        backgroundPanel.setBounds(0, 0, 575, 600); // Imposta le dimensioni e la posizione del pannello
        backgroundPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordo nero spesso 2 pixel

        // Pannello per i bottoni dei giocatori (area scrollabile)
        playerButtonsPanel = new JPanel();
        playerButtonsPanel.setLayout(new BoxLayout(playerButtonsPanel, BoxLayout.Y_AXIS)); // Utilizza BoxLayout
        playerButtonsPanel.setBackground(Color.CYAN);
        playerButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4)); // Bordo nero spesso 2 pixel

        JScrollPane scrollPane = new JScrollPane(playerButtonsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(25, 25, 350, 480); // Posizione e dimensioni per l'area scrollabile
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordo nero spesso 2 pixel
        backgroundPanel.add(scrollPane);

        // Area per le informazioni del giocatore
        playerInfoTextArea = new JTextArea();
        playerInfoTextArea.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Bordo nero spesso 2 pixel
        playerInfoTextArea.setEditable(false);
        playerInfoTextArea.setLineWrap(true);
        playerInfoTextArea.setWrapStyleWord(true);

        JScrollPane playerInfo = new JScrollPane(playerInfoTextArea);
        playerInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        playerInfo.setBounds(465, 50, 115, 280); // Posizione e dimensioni per l'area testo
        backgroundPanel.add(playerInfo);

        // Creo il pannello che conterrà i bottoni
        JPanel bottoniPlayer = new JPanel(new GridLayout(2, 1, 2, 2));
        bottoniPlayer.setBounds(410, 430, 150, 80);
        bottoniPlayer.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2)); // Bordo blu spesso 2 pixel

        // Bottoni per switchare tra la scelta del player
        selectPlayerButton1.setText("Player 1");
        selectPlayerButton1.setBounds(0, 0, 55, 35);
        selectPlayerButton1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Bordo blu spesso 2 pixel
        selectPlayerButton1.setBackground(Color.cyan);
        selectPlayerButton2.setText("Player 2");
        selectPlayerButton2.setBounds(0, 0, 55, 35);
        selectPlayerButton2.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // Bordo blu spesso 2 pixel
        selectPlayerButton2.setBackground(Color.cyan);

        // Di default li metto non cliccabili e opachi fino a quando uno dei bottoni dei giocatori non viene cliccato
        selectPlayerButton1.setOpaque(true);
        selectPlayerButton1.setEnabled(false);
        selectPlayerButton2.setOpaque(true);
        selectPlayerButton2.setEnabled(false);


        // Inserisco i bottoni nel pannello
        bottoniPlayer.add(selectPlayerButton1);
        bottoniPlayer.add(selectPlayerButton2);

        // Aggiungo il pannello al Pannello principale
        backgroundPanel.add(bottoniPlayer);

        // Creo il pannello che conterrà i bottoni
        bottoneConferma.setText("Confirm");
        bottoneConferma.setBounds(125, 535, 340, 60);
        bottoneConferma.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4)); // Bordo nero spesso 2 pixel
        bottoneConferma.setBackground(Color.CYAN);

        /*
                INSERIRE ACTION lISTENER CHE CLICCANDO SUL BOTTONE CONFERMA PASSO DIRETTAMENTE AL ChooseTeam e quindi la scelta
                del team dei rispettivi giocatori
         */

        // Aggiungo il pannello al Pannello principale
        backgroundPanel.add(bottoneConferma);


        // Aggiungi il backgroundPanel al pannello principale
        this.setLayout(new BorderLayout());
        this.add(backgroundPanel, BorderLayout.CENTER);

        // Metodo per aggiungere giocatori al pannello
        for (Player player : this.listaGiocatoriSalvati) {
            PlayerButton button = new PlayerButton(player);
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // Allinea i bottoni al centro
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45)); // Dimensione massima per evitare overflow
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Imposto queste info nella textArea e assegno al player corrente (in base al pulsante player che ho premuto)
                    // il valore del player associato al bottone
                    playerInfoTextArea.setText(player.playerInfo());
                    setPlayer(player);
                    // cambiare l'immagine del pannello in base al player2 in questo caso

                    // Setto i bottoni del Player1, Player2 cliccabili
                    selectPlayerButton1.setOpaque(false);
                    selectPlayerButton1.setEnabled(true);
                    selectPlayerButton2.setOpaque(false);
                    selectPlayerButton2.setEnabled(true);
                }
            });
            playerButtonsPanel.add(button);
            playerButtonsPanel.add(Box.createVerticalStrut(10)); // Spazio tra i bottoni
        }
    }       // fine Costruttore

    // Metodo per impostare le informazioni del giocatore nella JTextArea
    public void setPlayerInfo(Player player) {
        playerInfoTextArea.setText(player.playerInfo());
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    // Classe PlayerButton
    private static class PlayerButton extends JButton {
        private Player player;

        public PlayerButton(Player player) {
            super(player.getName());
            this.player = player;
            setHorizontalAlignment(SwingConstants.CENTER); // Allinea il testo al centro nel bottone
            setPreferredSize(new Dimension(315, 45)); // Dimensioni preferite per il bottone
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 1)); // Bordo nero spesso 1 pixel
        }

        public Player getPlayer() {
            return player;
        }
    }

    // INNER CLASS per il background panel
    public class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    // GETTERS E SETTERS

    public Player getPlayer() {
        return player;
    }

    public JButton getBottoneConferma() {
        return bottoneConferma;
    }

    public JButton getSelectPlayerButton1() {
        return selectPlayerButton1;
    }

    public JButton getSelectPlayerButton2() {
        return selectPlayerButton2;
    }

    public void setPlayerInfoTextArea(String infoPassate) {
        this.playerInfoTextArea.setText(infoPassate);
    }


}
