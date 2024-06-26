package swing.menupanel;

import database.Database;
import players.Player;
import swing.menuframe.ChooseTeam;
import swing.menuframe.battle.battleview.BattleView;

import javax.swing.*;
import javax.swing.border.Border;
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

    public PlayersSavedPanel(List<Player> players) {
        this.listaGiocatoriSalvati = players;

        System.out.println(listaGiocatoriSalvati);

        setLayout(null); // Disabilita il layout manager di default
        setBounds(0, 0, 600, 650); // Imposta le dimensioni e la posizione del pannello
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordo nero spesso 2 pixel

        // Pannello per i bottoni dei giocatori (area scrollabile)
        playerButtonsPanel = new JPanel();
        playerButtonsPanel.setLayout(null); // Disabilita il layout manager
        playerButtonsPanel.setBackground(Color.WHITE);
        playerButtonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Bordo nero spesso 2 pixel

        JScrollPane scrollPane = new JScrollPane(playerButtonsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 10, 450, 600); // Posizione e dimensioni per l'area scrollabile
        add(scrollPane);

        // Area per le informazioni del giocatore
        playerInfoTextArea = new JTextArea();
        playerInfoTextArea.setEditable(false);
        playerInfoTextArea.setLineWrap(true);
        playerInfoTextArea.setWrapStyleWord(true);


        JScrollPane playerInfo = new JScrollPane(playerInfoTextArea);
        playerInfo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        playerInfo.setBounds(465, 50, 115, 280); // Posizione e dimensioni per l'area testo
        add(playerInfo);


        // Creo il pannello che conterrà i bottoni
        JPanel bottoniPlayer = new JPanel(new GridLayout(2,1,2,2));
        bottoniPlayer.setBounds(465, 380, 115, 80);

        // Bottoni per switchare tra la scelta del player
        JButton selectPlayerButton1 = new JButton("Player 1");
        selectPlayerButton1.setBounds(0,0,55,35);
        JButton selectPlayerButton2 = new JButton("Player 2");
        selectPlayerButton2.setBounds(0,0,55,35);

        // Inserisco i bottoni nel pannello
        bottoniPlayer.add(selectPlayerButton1);
        bottoniPlayer.add(selectPlayerButton2);

        // Aggiungo il pannello al Pannello principale
        this.add(bottoniPlayer);


        // Creo il pannello che conterrà i bottoni

        // Bottoni per switchare tra la scelta del player
        JButton bottoneConferma = new JButton("Conferma");
        bottoneConferma.setBounds(465, 500, 115, 70);


        /*
                INSERIRE ACTION lISTENER CHE CLICCANDO SUL BOTTONE CONFERMA PASSO DIRETTAMENTE AL ChooseTeam e quindi la scelta
                del team dei rispettivi giocatori
         */

        // Aggiungo il pannello al Pannello principale
        this.add(bottoneConferma);



        // Do il Listener ai pulsanti
        // Listener Bottone Player1
        selectPlayerButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player1=player ; // imposto come player che è in fase di scelta, quello premuto dal bottone
                playerInfoTextArea.setText(player1.playerInfo());

                // cambiare l'immagine del pannello in base al player1 in questo caso
            }
        });

        // Listener Bottone Player2
        selectPlayerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2=player;
                playerInfoTextArea.setText(player2.playerInfo());
                // cambiare l'immagine del pannello in base al player2 in questo caso

            }
        });






        // Aggiungi i giocatori alla lista
        addPlayers(listaGiocatoriSalvati);
    }

    // Metodo per aggiungere giocatori al pannello
    public void addPlayers(List<Player> players) {
        int y = 10;
        for (Player player : players) {
            PlayerButton button = new PlayerButton(player);
            button.setBounds(7, y, 415, 45); // Modifica la posizione x qui
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    playerInfoTextArea.setText(player.playerInfo());
                    setPlayer(player);
                    // cambiare l'immagine del pannello in base al player2 in questo caso

                }
            });
            playerButtonsPanel.add(button);
            y += 50; // Spazio tra i bottoni
        }
    }

    // Metodo per impostare le informazioni del giocatore nella JTextArea
    public void setPlayerInfo(Player player) {
        playerInfoTextArea.setText(player.playerInfo());
    }
    public void setPlayer(Player player){
        this.player=player;
    }

    // Classe PlayerButton di esempio (da adattare alla tua implementazione)
    private static class PlayerButton extends JButton {
        private Player player;

        public PlayerButton(Player player) {
            super(player.getName());
            this.player = player;
            setHorizontalAlignment(SwingConstants.CENTER); // Allinea il testo a sinistra nel bottone
            setPreferredSize(new Dimension(415, 45)); // Dimensioni preferite per il bottone
            setBorder(BorderFactory.createLineBorder(Color.BLUE, 1)); // Bordo nero spesso 1 pixel
        }

        public Player getPlayer() {
            return player;
        }
    }
    public Player getPlayer2(){
        return player2;
    }
    public Player getPlayer1(){
        return player1;
    }

    public static void main(String[] args) {
         Database databaseDatiPlayer = new Database();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Players Saved Panel Test");
            frame.setSize(600, 650);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Creazione del pannello PlayersSavedPanel con dei giocatori di esempio
            try {
                databaseDatiPlayer.caricaDaFile(databaseDatiPlayer.getPathFileDatabase());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            PlayersSavedPanel panel = new PlayersSavedPanel(databaseDatiPlayer.getPlayerSalvati());
            frame.add(panel);

            frame.setVisible(true);
        });
    }
}
