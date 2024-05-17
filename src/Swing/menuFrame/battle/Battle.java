package Swing.menuFrame.battle;

import moves.base.Action;
import moves.base.BodySlam;
import moves.base.Frustration;
import moves.base.GigaImpact;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Frame per la Battaglia (nel quale andramo a implementare il sistema di combattimento principale

public class Battle extends JFrame {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Pokemon currentAttackPokemonInGame;
    private Pokemon currentDefensePokemonInGame;
    private Pokemon pokemonInGame1;
    private Pokemon pokemonInGame2;

    private PokePanel pokePanelPoke1;           // Pannelo Pokemon 1
    private PokePanel pokePanelPoke2;           // Pannello Pokemon 2

    private JPanel panelBattle = new JPanel(new BorderLayout());

    // Costruttore
    public Battle(Player player1InGame ,Player player2InGame) throws HeadlessException {
        this.player1 = player1InGame;
        this.player2 = player2InGame;

        this.setSize(600,650);//400 width and 500 height
        this.setLayout(null);//using no layout managers
        this.setLocationRelativeTo(null);//centro dello schermo
        this.setResizable(false);


        // Carico l'IMMAGINE DELLO SFONDO DEL COMBATTIMENTO
        BufferedImage img = null ;
        try {
            img = ImageIO.read(new File("src/Img/battleBack1.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image dimg = img.getScaledInstance(getWidth(), getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        // Impostiamo un'etichetta che rappresenta lo sfondo, assegnandoci l'immagine
        JLabel wallpaper= new JLabel("",imageIcon,JLabel.CENTER);
        wallpaper.setBounds(0,0,600,650);


        // Carico i Pokemon dei rispettivi giocatori (all'inzio sono quelli in posizione 0)
        pokemonInGame1=player1.getTeam().get(1);
        pokemonInGame2=player2.getTeam().get(0);

        // IMMAGINE POKEMON 1
        PokeImgLabel pokemon1Image = new PokeImgLabel(pokemonInGame1);
        pokemon1Image.setBounds(10,400,250,100);
        this.add(pokemon1Image);

        // IMMAGINE POKEMON 2
        PokeImgLabel pokemon2Image = new PokeImgLabel(pokemonInGame2);
        pokemon2Image.setBounds(350,250,250,100);
        this.add(pokemon2Image);




        //PANNELLO INFO POKEMON 1
        PokeBattleInfoPanel poke1InfoPanel=new PokeBattleInfoPanel(pokemonInGame1);
        poke1InfoPanel.setBounds(350,380,200,100);
        this.add(poke1InfoPanel);

        //PANNELLO INFO POKEMON 2
        PokeBattleInfoPanel poke2InfoPanel=new PokeBattleInfoPanel(pokemonInGame2);
        poke2InfoPanel.setBounds(50,80,200,100);
        this.add(poke2InfoPanel);




        //----TEXT AREA PRINCIPALE dove verrà scritto tutto cio che succede in battaglia-----------------------

        JTextArea battleTextArea = new JTextArea();
//        textArea.setText(player1.pokemonStringList());
        battleTextArea.setText("Make the right choice...");
        Font fontBattleTextArea = new Font("Arial", Font.ITALIC, 16);   // Creazione del font per la battleTextArea
        battleTextArea.setFont(fontBattleTextArea);                                 // Imposto un Font per la TextArea
        battleTextArea.setBounds(10,500,250,100);
        battleTextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        battleTextArea.setEditable(false);

        // All'inizio tutte due i giocatori partono con il pokemon della squadra in prima posizione
        // Impostazioni di prova --> pokemon1InGame Attacca e pokemon2InGame Difende

        currentAttackPokemonInGame = pokemonInGame1;
        currentDefensePokemonInGame = pokemonInGame2;

        /*
            NOTA : nelle turnazione è importante quando si assegna il turno, prima assegnare il turno al giocatore --> CurrentPlayerAttack e CurrentDefensePlayer
            ed una volta scelto il player, è importante assegnare il currentAttackPokemon del CurrentPlayerAttack e il currentDefensePokemon del CurrentDefensevePlayer
         */
        // Faccio una prova
        // Metto che nel pannello si visualizzano le mosse del pokemon corrente che vuole attaccare
        pokePanelPoke1 = new PokePanel(currentAttackPokemonInGame);





        /*
            ACTION LISTENER DEI BOTTONI DELLE MOSSE DI OGNI POKEMON
            Sistemiamo prima un bottone e facciamo lo stesso per il resto
         */


        // BOTTONE MOSSA 1
        pokePanelPoke1.getBottoneMossa1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controllo Principale, vedo se il pokemon avversario è vivo
                /*
                IMPORTANTE --> CONTROLLI CHE SI FANNO AL DI FUORI DEI PULSANTI, MA IN UN IMPOTETICO CICLO WHILE PRESENTE IN BATTLE, CHE E'
                QUELLO CHE GESTIRA' TUTTA LA BATTAGLIA
                 */
                if (currentDefensePokemonInGame.isAlive()) {

                    battleTextArea.setText("" + currentAttackPokemonInGame.getName() + " has used: " + currentAttackPokemonInGame.getMoves().get(0) + "!");     // Aggiorno la barra dell'azione

                    // Faccio il controllo sulla vita del pokemon
                    if (currentDefensePokemonInGame.getHealth() > 0) {
                        currentDefensePokemonInGame.setHealth(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(0).getDamage());    // modifico la vita del pokemon
                        poke2InfoPanel.getHpBar().setValue(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(0).getDamage());       // Aggiorno la barra
                        // Se con l'attacco vado oltre lo zero in negativo, la imposto automaticamente a 0
                        if (currentDefensePokemonInGame.getHealth() <= 0) {
                            currentDefensePokemonInGame.setHealth(0);
                            //----------------------------------------------------------------------------------------------------------------//
                            // NOTA IMPORTANTE ---------------------------------------------------------------------------------------------
                            // Questo tipo di controllo è meglio farli nel Ciclo della battaglia stesso, che va a controllare tutti i parametri in gioco!
                            currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                            Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                            Battle.super.repaint();                  // aggiorno il frame Battle
                            int IncrementValueExpBar = 15;
                            currentAttackPokemonInGame.setExpBase(IncrementValueExpBar);           // incremento di 3 punti vita pokemon
                            poke1InfoPanel.getExperienceBar().setValue(poke2InfoPanel.getExperienceBar().getValue() + IncrementValueExpBar);    // setto il valore della barraEXP
                            poke1InfoPanel.getExperienceBar().repaint();
                            // Stampo il messaggio che il pokemon non è più in grado di combattere
                            battleTextArea.setText("" + currentDefensePokemonInGame.getName() + " is exhausted. :(");
                            battleTextArea.repaint();

                        } // Fine if per settare il pokemon morto


                    } else {     // se la vita è minore di 0 imposto tutto a 0
                        poke2InfoPanel.getHpBar().setValue(0);
                        currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                        Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                        Battle.super.repaint();                  // aggiorno il frame Battle
                    }
                    // Aggiorno il Pannello e la barra
                    poke2InfoPanel.getHpBar().repaint();
                    // poke2InfoPanel.repaint();
                }
            }   // IN QUESTO MODO POSSO PREMERE IL BOTTONE SOLO SE IL POKEMON AVVERSARIO E' ANCORA VIVO
        });



        // BOTTONE MOSSA 2
        pokePanelPoke1.getBottoneMossa2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controllo Principale, vedo se il pokemon avversario è vivo
                /*
                IMPORTANTE --> CONTROLLI CHE SI FANNO AL DI FUORI DEI PULSANTI, MA IN UN IMPOTETICO CICLO WHILE PRESENTE IN BATTLE, CHE E'
                QUELLO CHE GESTIRA' TUTTA LA BATTAGLIA
                 */
                if (currentDefensePokemonInGame.isAlive()) {

                    battleTextArea.setText("" + currentAttackPokemonInGame.getName() + " has used: " + currentAttackPokemonInGame.getMoves().get(1) + "!");     // Aggiorno la barra dell'azione

                    // Faccio il controllo sulla vita del pokemon
                    if (currentDefensePokemonInGame.getHealth() > 0) {
                        currentDefensePokemonInGame.setHealth(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(1).getDamage());    // modifico la vita del pokemon
                        poke2InfoPanel.getHpBar().setValue(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(1).getDamage());       // Aggiorno la barra
                        // Se con l'attacco vado oltre lo zero in negativo, la imposto automaticamente a 0
                        if (currentDefensePokemonInGame.getHealth() <= 0) {
                            currentDefensePokemonInGame.setHealth(0);
                            //----------------------------------------------------------------------------------------------------------------//
                            // NOTA IMPORTANTE ---------------------------------------------------------------------------------------------
                            // Questo tipo di controllo è meglio farli nel Ciclo della battaglia stesso, che va a controllare tutti i parametri in gioco!
                            currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                            Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                            Battle.super.repaint();                  // aggiorno il frame Battle
                            int IncrementValueExpBar = 15;
                            currentAttackPokemonInGame.setExpBase(IncrementValueExpBar);           // incremento di 3 punti vita pokemon
                            poke1InfoPanel.getExperienceBar().setValue(poke2InfoPanel.getExperienceBar().getValue() + IncrementValueExpBar);    // setto il valore della barraEXP
                            poke1InfoPanel.getExperienceBar().repaint();
                            // Stampo il messaggio che il pokemon non è più in grado di combattere
                            battleTextArea.setText("" + currentDefensePokemonInGame.getName() + " is exhausted. :(");
                            battleTextArea.repaint();

                        } // Fine if per settare il pokemon morto


                    } else {     // se la vita è minore di 0 imposto tutto a 0
                        poke2InfoPanel.getHpBar().setValue(0);
                        currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                        Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                        Battle.super.repaint();                  // aggiorno il frame Battle
                    }
                    // Aggiorno il Pannello e la barra
                    poke2InfoPanel.getHpBar().repaint();
                    // poke2InfoPanel.repaint();
                }
            }   // IN QUESTO MODO POSSO PREMERE IL BOTTONE SOLO SE IL POKEMON AVVERSARIO E' ANCORA VIVO
        });


        // BOTTONE MOSSA 3
        pokePanelPoke1.getBottoneMossa3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controllo Principale, vedo se il pokemon avversario è vivo
                /*
                IMPORTANTE --> CONTROLLI CHE SI FANNO AL DI FUORI DEI PULSANTI, MA IN UN IMPOTETICO CICLO WHILE PRESENTE IN BATTLE, CHE E'
                QUELLO CHE GESTIRA' TUTTA LA BATTAGLIA
                 */
                if (currentDefensePokemonInGame.isAlive()) {

                    battleTextArea.setText("" + currentAttackPokemonInGame.getName() + " has used: " + currentAttackPokemonInGame.getMoves().get(2) + "!");     // Aggiorno la barra dell'azione

                    // Faccio il controllo sulla vita del pokemon
                    if (currentDefensePokemonInGame.getHealth() > 0) {
                        currentDefensePokemonInGame.setHealth(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(2).getDamage());    // modifico la vita del pokemon
                        poke2InfoPanel.getHpBar().setValue(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(2).getDamage());       // Aggiorno la barra
                        // Se con l'attacco vado oltre lo zero in negativo, la imposto automaticamente a 0
                        if (currentDefensePokemonInGame.getHealth() <=0) {
                            currentDefensePokemonInGame.setHealth(0);
                            //----------------------------------------------------------------------------------------------------------------//
                            // NOTA IMPORTANTE ---------------------------------------------------------------------------------------------
                            // Questo tipo di controllo è meglio farli nel Ciclo della battaglia stesso, che va a controllare tutti i parametri in gioco!
                            currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                            Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                            Battle.super.repaint();                  // aggiorno il frame Battle
                            int IncrementValueExpBar = 15;
                            currentAttackPokemonInGame.setExpBase(IncrementValueExpBar);           // incremento di 3 punti vita pokemon
                            poke1InfoPanel.getExperienceBar().setValue(poke2InfoPanel.getExperienceBar().getValue() + IncrementValueExpBar);    // setto il valore della barraEXP
                            poke1InfoPanel.getExperienceBar().repaint();
                            // Stampo il messaggio che il pokemon non è più in grado di combattere
                            battleTextArea.setText("" + currentDefensePokemonInGame.getName() + " is exhausted. :(");
                            battleTextArea.repaint();

                        } // Fine if per settare il pokemon morto


                    } else {     // se la vita è minore di 0 imposto tutto a 0
                        poke2InfoPanel.getHpBar().setValue(0);
                        currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                        Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                        Battle.super.repaint();                  // aggiorno il frame Battle
                    }
                    // Aggiorno il Pannello e la barra
                    poke2InfoPanel.getHpBar().repaint();
                    // poke2InfoPanel.repaint();
                }
            }   // IN QUESTO MODO POSSO PREMERE IL BOTTONE SOLO SE IL POKEMON AVVERSARIO E' ANCORA VIVO
        });


        // BOTTONE MOSSA 4
        pokePanelPoke1.getBottoneMossa4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Controllo Principale, vedo se il pokemon avversario è vivo
                /*
                IMPORTANTE --> CONTROLLI CHE SI FANNO AL DI FUORI DEI PULSANTI, MA IN UN IMPOTETICO CICLO WHILE PRESENTE IN BATTLE, CHE E'
                QUELLO CHE GESTIRA' TUTTA LA BATTAGLIA
                 */
                if (currentDefensePokemonInGame.isAlive()) {

                    battleTextArea.setText("" + currentAttackPokemonInGame.getName() + " has used: " + currentAttackPokemonInGame.getMoves().get(3) + "!");     // Aggiorno la barra dell'azione

                    // Faccio il controllo sulla vita del pokemon
                    if (currentDefensePokemonInGame.getHealth() > 0) {
                        currentDefensePokemonInGame.setHealth(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(3).getDamage());    // modifico la vita del pokemon
                        poke2InfoPanel.getHpBar().setValue(currentDefensePokemonInGame.getHealth() - currentAttackPokemonInGame.getMoves().get(3).getDamage());       // Aggiorno la barra
                        // Se con l'attacco vado oltre lo zero in negativo, la imposto automaticamente a 0
                        if (currentDefensePokemonInGame.getHealth() <= 0) {
                            currentDefensePokemonInGame.setHealth(0);
                            //----------------------------------------------------------------------------------------------------------------//
                            // NOTA IMPORTANTE ---------------------------------------------------------------------------------------------
                            // Questo tipo di controllo è meglio farli nel Ciclo della battaglia stesso, che va a controllare tutti i parametri in gioco!
                            currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                            Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                            Battle.super.repaint();                  // aggiorno il frame Battle
                            int IncrementValueExpBar = 15;
                            currentAttackPokemonInGame.setExpBase(IncrementValueExpBar);           // incremento di 3 punti vita pokemon
                            poke1InfoPanel.getExperienceBar().setValue(poke2InfoPanel.getExperienceBar().getValue() + IncrementValueExpBar);    // setto il valore della barraEXP
                            poke1InfoPanel.getExperienceBar().repaint();
                            // Stampo il messaggio che il pokemon non è più in grado di combattere
                            battleTextArea.setText("" + currentDefensePokemonInGame.getName() + " is exhausted. :(");
                            battleTextArea.repaint();


                        } // Fine if per settare il pokemon morto


                    }
                    else {     // se la vita è minore di 0 imposto tutto a 0
                        poke2InfoPanel.getHpBar().setValue(0);
                        currentDefensePokemonInGame.setAlive(false);        // metto che è stato sconfitto e non è più vivo
                        Battle.super.remove(pokemon2Image);        // rimuovo l'immagine del secondo pokemon (che SOLO IN QUESTO ESEMPIO è Pokemon2Image
                        Battle.super.repaint();                  // aggiorno il frame Battle
                        Battle.super.repaint();
                    }
                    // Aggiorno il Pannello e la barra
                    poke2InfoPanel.getHpBar().repaint();
//                    poke2InfoPanel.repaint();
                    System.out.println(currentDefensePokemonInGame.getHealth());
                }
            }   // IN QUESTO MODO POSSO PREMERE IL BOTTONE SOLO SE IL POKEMON AVVERSARIO E' ANCORA VIVO
        });



        // Aggiungo il pannello al Frame
        this.add(pokePanelPoke1);
        // Questa textArea verrà modificata ogni volta che verrà sferrato un attacco o altre azioni
        this.add(battleTextArea);


        //----PANNELLO PRINCIPALE DOVE SI SELEZIONA COSA FARE MOSSE ETC (Pannello in basso a destra) --------------

//        pokePanelPoke1=new PokePanel(pokemonInGame1);
//        this.add(pokePanelPoke1);
//        pokePanelPoke2.setVisible(true);                // all'inizio sarà visibile solo il pannello del primo giocatore
//
//        pokePanelPoke2=new PokePanel(pokemonInGame2);
//        this.add(pokePanelPoke2);                       // aggiungiamo il pannello del secondo giocatore al frame
//        pokePanelPoke2.setVisible(false);               // pannello del secondo giocatore nascosto fino al suo turno
//


        this.add(wallpaper);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);
    } // Fine costruttore



    //MAIN DI TEST

    public static void main(String[] arg) {
        Pokedex pokedex = new Pokedex();
        Player hash = new Player("Hash",0,0,"Male");
        Player red = new Player("Red",0,0,"Male");


        Image img = null;
        try {
            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image dimg = img.getScaledInstance(60, 60,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        hash.setImage(imageIcon);
        red.setImage(imageIcon);

        // Per adesso faccio questo ciclo solo per vedere il pannello con le mosse che deve riempire
        for(Pokemon pokem : pokedex.getPokedex()){
            pokem.addMove(new Action());
            pokem.addMove(new Frustration());
            pokem.addMove(new GigaImpact());
            pokem.addMove(new BodySlam());


            hash.addPokemon(pokem);
            red.addPokemon(pokem);
        }

        new Battle(hash,red);
    }
}
