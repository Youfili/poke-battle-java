package swing.menuframe;

import database.Database;
import swing.BackgroundImageJFrame;
import swing.menuframe.battle.battleview.BattleView;
import swing.menupanel.ChoosePlayerPanel;
import swing.menupanel.GameSelectPanel;
import players.Player;
import swing.menupanel.PlayersSavedPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BorderLayout.*;

public class Menu extends JFrame {

        private GameSelectPanel gameSelect;
        private ChoosePlayerPanel choosePlayerPanel;
        private JButton maleButton, femaleButton, continueToChooseTeamButton, backToChoiceGame;
        private List<Player> giocatoriSalvati = new ArrayList<>();   // creo un ArrayList di giocatori (dovranno essere minimo due)
        private PlayersSavedPanel pannelloContinuaPartita;
        private JButton bottoneConferma;
        private JButton selectPlayerButton1;
        private JButton selectPlayerButton2;
        private Player player;
        private Player player1;
        private Player player2;

        // Costruttore Menu
        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height
            setLocationRelativeTo(null);//centro dello schermo
            setResizable(false);
            setLayout(new BorderLayout());      // Layout del Menu


            // creo l'istanza di GameSelectPanel
            gameSelect = new GameSelectPanel(new GridLayout(2,1));      // Grid Layout con 3 colonne
            // Creo l'istanza di ChoosePlayerPanel
            choosePlayerPanel = new ChoosePlayerPanel(new BorderLayout());

            // Devo caricare gli elementi all'interno del fileDataBase
            Database db = new Database();
            giocatoriSalvati = db.getPlayerSalvati();
            pannelloContinuaPartita = new PlayersSavedPanel(giocatoriSalvati);


            // Creo un panels di Cards, cosi posso muovermi nella cards
            JPanel panels = new JPanel(new CardLayout());
            panels.add(gameSelect, "Panel GameSelect");
            panels.add(choosePlayerPanel, "Panel NuovaPartita");
            panels.add(pannelloContinuaPartita, "Panel ContinuaPartita");


            // Aggiungo i Panelli (composti dalle carte) all'interno di un Conteiner
            Container pane = this.getContentPane();
            pane.add(panels, CENTER);                            // pannelli aggiunti al centro del Container
            CardLayout cl = (CardLayout)(panels.getLayout());


            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            // GENDER BUTTON
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Icona Pokeball
            // IMMAGINE ICONA Pokeball --> ChoosePlayerPanel
            Image imgPokeball = null;
            try {
                imgPokeball = ImageIO.read(new File("src/Img/pokeball.png"));
            } catch (IOException er) {
                throw new RuntimeException(er);
            }

            Image dimgPokeball = imgPokeball.getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIconPokeball = new ImageIcon(dimgPokeball);


            /*  ACTION LISTENER DEL PANELLO CONTINUA-PARTITA  */

            // VANNO RIVISTI BENE QUESTI LISTENER --> NON SONO CORRETTI
            selectPlayerButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player = player1;
                }
            });
            selectPlayerButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player = player2;
                }
            });


            bottoneConferma = pannelloContinuaPartita.getBottoneConferma();
            bottoneConferma.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.setRootFrame(new BattleView(player1, player2));
                    Menu.super.setVisible(false);
                }
            });




























            // MALE Button
            maleButton = choosePlayerPanel.getMaleButton();         // Istanzio il Bottone Maschile
            maleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String name = JOptionPane.showInputDialog("Inserisci nome: ");


                    if(name != null && !name.trim().isEmpty()) {
                        // IMMAGINE ICONA MASCHILE --> ChoosePlayerPanel
                        Image img = null;
                        try {
                            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
                        } catch (IOException er) {
                            throw new RuntimeException(er);
                        }
                        Image dimg = img.getScaledInstance(60, 60,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);

                        // SOSTITUIBILE CON UNO SWITCH CASE --> DA FARE
                        if (Menu.this.giocatoriSalvati.size() >= 2) {
                                Menu.this.giocatoriSalvati.remove(0);    // prima rimuovo l'ultimo ad essere stato aggiunto
                                // Poi aggiungo il player
                                Menu.this.giocatoriSalvati.add(new Player(name, 0, 0, "Male"));
                                Menu.this.giocatoriSalvati.get(Menu.this.giocatoriSalvati.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati
                        } else {
                            Menu.this.giocatoriSalvati.add(new Player(name, 0, 0, "Male"));
                            Menu.this.giocatoriSalvati.get(Menu.this.giocatoriSalvati.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati

                        }
                    }
                }
            });

            // FEMALE BUTTON
            femaleButton = choosePlayerPanel.getFemaleButton();
            femaleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String name = JOptionPane.showInputDialog(null,"Scegli il Nome: ", "Choose Name", JOptionPane.PLAIN_MESSAGE);

                    if(name != null && !name.trim().isEmpty()) {
                        // IMMAGINE ICONA FEMMINILE --> ChoosePlayerPanel
                        Image img = null;
                        try {
                            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
                        } catch (IOException er) {
                            throw new RuntimeException(er);
                        }
                        Image dimg = img.getScaledInstance(60, 60,
                                Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(dimg);

                        // SOSTITUIBILE CON UNO SWITCH CASE --> DA FARE
                        if (Menu.this.giocatoriSalvati.size() >= 2) {
                            Menu.this.giocatoriSalvati.remove(0);    // prima rimuovo l'ultimo ad essere stato aggiunto
                            // Poi aggiungo il player
                            Menu.this.giocatoriSalvati.add(new Player(name, 0, 0, "Female"));
                            Menu.this.giocatoriSalvati.get(Menu.this.giocatoriSalvati.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati
                        } else {
                            Menu.this.giocatoriSalvati.add(new Player(name, 0, 0, "Female"));
                            Menu.this.giocatoriSalvati.get(Menu.this.giocatoriSalvati.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati

                        }
                    }
                }
            });


            // Pulsante dopo aver scelto i personaggi e andare a scegliere il team
            continueToChooseTeamButton = choosePlayerPanel.getContinueToChooseTeamButton();     // creo un istanza del bottone del pannello{
            continueToChooseTeamButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Menu.this.giocatoriSalvati.get(0)!= null && Menu.this.giocatoriSalvati.get(1)!= null) {
                        // Se i due giocatori non sono null, quindi sono stati modificati
                                        // player1             // player2
                        JOptionPane.setRootFrame( new ChooseTeam(Menu.this.giocatoriSalvati.get(0), Menu.this.giocatoriSalvati.get(1)));
                        setVisible(false);
                    }
                }
            });

            // Pulsante per tornare indietro alla scelta della partita
            backToChoiceGame = choosePlayerPanel.getBackToGameSelect();
            backToChoiceGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    ImageIcon returnBackCustomIcon = new ImageIcon("src/Img/backToMenu.png");           // Carico l'icona personalizzata da inserire nel ConfirmDialog

                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to go back?", "Confirm to go Back", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, returnBackCustomIcon);
                    if (response == JOptionPane.YES_OPTION) {           // se conferma il bottone premuto, torno indietro al menu
                        new BackgroundImageJFrame();                    // torno al Menu Principale
                        Menu.super.setVisible(false);
                        System.out.println("Torno indietro...");
                    } else {
                        System.out.println("Debug su console annulla Operazione di tornare indietro");              // Azione se l'utente sceglie "No"
                    }
                }
            });




//            // PANNELLO " gameSelect "  --> Bottoni vecchia e nuova Partita
            JButton startButton = gameSelect.getStartButton();
//
            // Aggiungo il listener al mio StartButton
            // StartButton mi inizia una NUOVA PARTITA
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mi sposto nel pannello della NuovaPartita (quindi quello della creazione del personaggio)
                    cl.show(panels, "Panel NuovaPartita");
                }
            });

            JButton continueButton = gameSelect.getContinueButton();
            // Aggiungo il listener al mio StartButton
            continueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mi sposto nel pannello del Continua Partita, quello con i playerSalvati.
                    cl.show(panels, "Panel ContinuaPartita");
                }
            });


            setVisible(true);//making the frame visible
//            choosePlayerPanel.setVisible(false);    // set visibile of panel choose "False"
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina






        } // FINE COSTRUTTORE MENU




    }


    // Commento per vedere il commit