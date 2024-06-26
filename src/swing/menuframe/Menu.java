package swing.menuframe;

import swing.BackgroundImageJFrame;
import swing.menuframe.battle.battleview.BattleView;
import swing.menupanel.ChoosePlayerPanel;
import swing.menupanel.GameSelectPanel;
import players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.BorderLayout.*;

public class Menu extends JFrame {

        private GameSelectPanel gameSelect;
        private ChoosePlayerPanel choosePlayerPanel;
        private JButton maleButton, femaleButton, continueToChooseTeamButton, backToChoiceGame;
        private ArrayList<Player> playerCreated;   // creo un ArrayList di giocatori (dovranno essere minimo due)


        // Costruttore Menu
        public Menu() {
            //creating instance of JFrame
            setSize(600,650);//400 width and 500 height
            setLocationRelativeTo(null);//centro dello schermo
            setResizable(false);
            setLayout(new BorderLayout());      // Layout del Menu

            // Inizializzo l'arrayList PLAYER CREATI con i due elementi a null
            playerCreated = new ArrayList<Player>();
            playerCreated.add(null);
            playerCreated.add(null);


            // creo l'istanza di GameSelectPanel
            gameSelect = new GameSelectPanel(new GridLayout(2,1));      // Grid Layout con 3 colonne
            // Creo l'istanza di ChoosePlayerPanel
            choosePlayerPanel = new ChoosePlayerPanel(new BorderLayout()); // GridLayout con 2 righe e 1 colonna



            // Creo un panels di Cards, cosi posso muovermi nella cards
            JPanel panels = new JPanel(new CardLayout());
            panels.add(gameSelect, "Panel 1");
            panels.add(choosePlayerPanel, "Panel 2");


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
                        if (playerCreated.size() >= 2) {
                                playerCreated.remove(0);    // prima rimuovo l'ultimo ad essere stato aggiunto
                                // Poi aggiungo il player
                                playerCreated.add(new Player(name, 0, 0, "Male"));
                                playerCreated.get(playerCreated.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati
                        } else {
                            playerCreated.add(new Player(name, 0, 0, "Male"));
                            playerCreated.get(playerCreated.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
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
                        if (playerCreated.size() >= 2) {
                            playerCreated.remove(0);    // prima rimuovo l'ultimo ad essere stato aggiunto
                            // Poi aggiungo il player
                            playerCreated.add(new Player(name, 0, 0, "Female"));
                            playerCreated.get(playerCreated.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
//                        playerChoosen++;            // incremento il numero di giocatori creati
                        } else {
                            playerCreated.add(new Player(name, 0, 0, "Female"));
                            playerCreated.get(playerCreated.size()-1).setImage(imageIcon); // Setto l'immagine del player creato (ultimo ad essere stato aggiunto)
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
                    if(playerCreated.get(0)!= null && playerCreated.get(1)!= null) {
                        // Se i due giocatori non sono null, quindi sono stati modificati
                                        // player1             // player2
                        JOptionPane.setRootFrame( new ChooseTeam(playerCreated.get(0), playerCreated.get(1)));
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
//            startButton.setBounds(115,350,350,85);//x axis, y axis, width, height
            // Aggiungo il listener al mio StartButton
            startButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cl.next(panels);
                }
            });

            JButton continueButton = gameSelect.getContinueButton();
            // Aggiungo il listener al mio StartButton
            continueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementare un pannello dove vengono salvati i giocatori, e dove verranno scelti per giocare
                    // Il pannello ripreso da un file in cui andiamo a salvare tutti i giocatori all'interno di questo TextField

                }
            });


            setVisible(true);//making the frame visible
//            choosePlayerPanel.setVisible(false);    // set visibile of panel choose "False"
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina






        } // FINE COSTRUTTORE MENU




    }


    // Commento per vedere il commit