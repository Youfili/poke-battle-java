package swing.menuframe;

import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.PokeButton;
import swing.menupanel.PartyPokemonPanel;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/*
IMPLEMENTARE VARIE CLASSI PANNELLI OGNUNA CON RELATIVE INFORMAZIONI E PULSANTI
METTERLE POI IN COLLEGAMENTO IN QUESTO FRAME
 */
public class ChooseTeam extends JFrame {

    //private List<Pokemon> pokemon=new ArrayList<Pokemon>();
    private Player player;
    private Player player1;
    private Player player2;
    private JTextArea pokeInfoTextArea;
    private Pokedex pokedex;
    private Pokedex pokedex1=new Pokedex();
    private Pokedex pokedex2= new Pokedex();

    private JLabel playerIcon;
    private JTextArea playerInfo;
    private JButton addTeam;
    private JPanel playerInfoPanel;

    private PartyPokemonPanel teamPanel;
    private PartyPokemonPanel teamPanel2;

    private Pokemon selectedPokemon;
    private  Pokemon selectedPartyPokemon;

    private PokeButton bottonePokemonSelezionato;

    public ChooseTeam(Player player1, Player player2) {
        // Nel costruttore va aggiunto un altro Player che si interfacci con la propria squadra, cosi da farli entrare in battaglia

        this.player1=player1;
        this.player2=player2;
        setSize(600,650);//400 width and 500 height --> Dimensione dei ChooseTeam JFrame
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);// size della finestra non modificabile di dimensione

        player = player1;
        // di base metto che il player con qui si pre la scelta team è il primo

        //lista pokemon .. magari prendere da una classe Pokedex
        pokedex= pokedex1;

//        playerInfo=new JTextArea();
        playerIcon=new JLabel();
        pokeInfoTextArea=new JTextArea();
        playerInfoPanel=new JPanel(new BorderLayout());


        //PLAYER INFO --> Info del giocatore
        playerInfo=new JTextArea(player.playerInfo());
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        playerInfo.setFont(new Font("Arial", Font.BOLD,13));

        //PLAYER ICON
        playerIcon.setIcon(player.getImage());

        //Aggiungo PlayerInfo e PlayerIcon a PlayerInfoPanel (Il pannello che contiene questi due componenti)
        //PLAYER INFO PANEL
        playerInfoPanel.setBounds(5,500,190,100);
        playerInfoPanel.setBorder(new TitledBorder("PLAYER INFO"));
        playerInfoPanel.add(playerInfo,BorderLayout.CENTER);
        playerInfoPanel.add(playerIcon,BorderLayout.WEST);
        playerInfoPanel.setVisible(true);
        add(playerInfoPanel);

        //PARTY POKE PANEL
        teamPanel=new PartyPokemonPanel(player1);
        JButton pokemon1 = teamPanel.getPokemon1();
        JButton pokemon2 = teamPanel.getPokemon2();
        JButton pokemon3 = teamPanel.getPokemon3();
        JButton pokemon4 = teamPanel.getPokemon4();
        JButton pokemon5 = teamPanel.getPokemon5();
        JButton pokemon6 = teamPanel.getPokemon6();
        teamPanel.setVisible(true);                 // parto con il teamPanel del giocatore1


        teamPanel2 = new PartyPokemonPanel(player2);
        JButton pokemon1_2 = teamPanel2.getPokemon1();
        JButton pokemon2_2 = teamPanel2.getPokemon2();
        JButton pokemon3_2 = teamPanel2.getPokemon3();
        JButton pokemon4_2 = teamPanel2.getPokemon4();
        JButton pokemon5_2 = teamPanel2.getPokemon5();
        JButton pokemon6_2 = teamPanel2.getPokemon6();
        teamPanel2.setVisible(false);                 // parto con il teamPanel del giocatore2 non visibile





        //POKEMON INFO AREA---------------------------

        JScrollPane sp = new JScrollPane(pokeInfoTextArea);     // Area di testo dove apparirà il Pokemon quando selezionato (e si vedranno le informazioni)
        JPanel wrapper = new JPanel(new BorderLayout());        // Pannello della PokemonInfoArea --> wrapper
        wrapper.setBorder(new TitledBorder("POKEMON INFO"));
        wrapper.add(sp, BorderLayout.CENTER);
        wrapper.setBounds(325,20,250,400);
        wrapper.setBackground(Color.WHITE);
        wrapper.setVisible(true);
        add(wrapper);

        JLabel pokeIcon = new JLabel();
        wrapper.add(pokeIcon, BorderLayout.PAGE_START);


        // BATTLE BUTTON /////////////////////////////////////////////////////////////////7
        JPanel battleButtonPanel = new JPanel(new BorderLayout());
        battleButtonPanel.setBorder(new TitledBorder("FIGHT!"));

        // Immagine Icon del Bottone Battaglia
        BufferedImage immBattle =null ;
        try {
            immBattle = ImageIO.read(new File("src/Img/batlle_Icon_Button.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image immBattleButton = immBattle.getScaledInstance(115, 50,
                Image.SCALE_SMOOTH);
        ImageIcon immBattleButtonIcon = new ImageIcon(immBattleButton);

        // Creo il pulsante Battaglia
        JButton battleButton = new JButton();
        battleButton.setIcon(immBattleButtonIcon);
        battleButtonPanel.add(battleButton, BorderLayout.CENTER);           // Imposto il pulsante al centro del pannello
        battleButtonPanel.setBounds(440,420,135,85);     // posiziono il pannello nello spazio

        // ActionListener del Battle_Button
        battleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean okInBattaglia = true;

                // Controllo se c'è almeno un valore null quando il giocatore lo seleziona
                for(int i=0; i < player.getTeam().size(); i ++){
                    // controllo effettuato su entrambi i giocatori, basta che solo uno dei pokemon tra i due player è null e non si entra in battaglia
                    if(player1.getTeam().get(i) == null || player2. getTeam().get(i) == null)
                        okInBattaglia = false;
                }
                if(okInBattaglia != false) {
                    //Solo se il team di entrambi i giocatori è al completo vado in battaglia Vado in battaglia
                    JOptionPane.setRootFrame(new BattleView(player1, player2));
                    setVisible(false);              // rendo questo frame non più visibile
                }else{
                    System.out.println("Il Team deve essere Completo!");
                }
            }
        });
        add(battleButtonPanel);             // Aggiungo il pannello al frame ChooseTeam

        // PANNELLO POKEDEX 1 ------------------------------------------------//
        JPanel pokedexPanel = new JPanel();
        pokedexPanel.setLayout(null);
        pokedexPanel.setBorder(new TitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createBevelBorder(3)),"POKEDEX",0,0,Font.getFont("Arail"),Color.BLACK));
        pokedexPanel.setBounds(5,5,300,450);
        BufferedImage img =null ;
        try {
            img = ImageIO.read(new File("src/Img/wallpaper.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

        Image im = img.getScaledInstance(getWidth(), getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imgicn = new ImageIcon(im);

        JLabel back= new JLabel("",imgicn,JLabel.CENTER);
        back.setBounds(10,15,280,425);






        //CREAZIONE PULSANTI POKEMON PER OGNI POKEMON NEL POKEDEX1
        int x=20;
        int y=30;
        for (Pokemon poke : pokedex1.getPokedex()) {

            Image dimg = poke.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            PokeButton pokeButton = new PokeButton(poke);//creating instance of JButton --> Return pokemon name
            pokeButton.setBounds(x,y, 50, 50);//x axis, y axis, width, height
            pokeButton.setIcon(imageIcon);
            pokeButton.setOpaque(false);
            pokeButton.setBorderPainted(false);

            pokeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    // Una volta cliccato un pokemon nel pokedex metto che è di nuovo cliccabile il tasto add per aggiungere quel pokemon
                    // al propria squadra
                    addTeam.setOpaque(false);
                    addTeam.setEnabled(true);


                    //MOSTRO LE INFO DEL POKEMON SELEZIONATO
                    selectedPokemon=poke;
                    pokeInfoTextArea.setText("");
                    pokeInfoTextArea.append(poke.toString());
                    pokeInfoTextArea.repaint();
                    pokeIcon.setIcon(imageIcon);
                    pokeIcon.repaint();
                    wrapper.repaint();
                    /*playerButton.setText(player.toString());
                    playerButton.repaint();
                    repaint();*/
                }
            });
            // Faccio un controllo di spazio
            if (y < 300 && x < 400) {           // non sforo dalle dimensioni
                y += 60;
            }else{
                x+= 70;
                y = 30;      // imposto le cordinate per spostarmi nella colonna dopo e scendere con la nuova y da capo
            }

            pokedexPanel.add(pokeButton);


        }
        pokedexPanel.add(back);                         // aggiungo il back al pokedeb Panel
        pokedexPanel.setVisible(true);                  // metto il pannello visibile
        add(pokedexPanel);                              // aggiungo il pannello Pokedex al ChooseTeam Frame

        // PANNELLO POKEDEX 2 ------------------------------------------------//

        JPanel pokedexPanel2 = new JPanel();
        pokedexPanel2.setLayout(null);
        pokedexPanel2.setBorder(new TitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createBevelBorder(3)),"POKEDEX",0,0,Font.getFont("Arail"),Color.BLACK));
        pokedexPanel2.setBounds(5,5,300,450);

        BufferedImage imgi =null ;
        try {
            imgi = ImageIO.read(new File("src/Img/wallpaper.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

        Image imm = imgi.getScaledInstance(getWidth(), getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imgic = new ImageIcon(im);

        JLabel backg= new JLabel("",imgic,JLabel.CENTER);
        backg.setBounds(10,15,280,425);






        //CREAZIONE PULSANTI POKEMON PER OGNI POKEMON NEL POKEDEX2
        int x2=20;
        int y2=30;
        for (Pokemon poke : pokedex2.getPokedex()) {

            Image dimg = poke.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon imageIcon2 = new ImageIcon(dimg);

            PokeButton pokeButton2 = new PokeButton(poke);//creating instance of JButton --> Return pokemon name
            pokeButton2.setBounds(x2,y2, 50, 50);//x axis, y axis, width, height
            pokeButton2.setIcon(imageIcon2);
            pokeButton2.setOpaque(false);
            pokeButton2.setBorderPainted(false);

            pokeButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    // Una volta cliccato un pokemon nel pokedex metto che è di nuovo cliccabile il tasto add per aggiungere quel pokemon
                    // al propria squadra
                    addTeam.setOpaque(false);
                    addTeam.setEnabled(true);


                    //MOSTRO LE INFO DEL POKEMON SELEZIONATO
                    selectedPokemon=poke;
                    pokeInfoTextArea.setText("");
                    pokeInfoTextArea.append(poke.toString());
                    pokeInfoTextArea.repaint();
                    pokeIcon.setIcon(imageIcon2);
                    pokeIcon.repaint();
                    wrapper.repaint();
                    /*playerButton.setText(player.toString());
                    playerButton.repaint();
                    repaint();*/
                }
            });
            y2+=60;


            pokedexPanel2.add(pokeButton2);


        }
        pokedexPanel2.add(backg);                         // aggiungo il back al pokedeb Panel
        pokedexPanel2.setVisible(false);                  // metto il pannello visibile
        add(pokedexPanel2);                              // aggiungo il pannello Pokedex al ChooseTeam Frame




        // SELECT PLAYER TEAM BUTTON /////////////////////////////////////////////////////////////////7
        JPanel selectPlayerTeamPanel = new JPanel(new GridLayout(2,1));         // due righe e 1 colonna (devo mettere due pulsanti in orizzontale)


        // Creo il pulsante SelectTeam
        JButton selectPlayerTeamButton1 = new JButton("Player 1");
        JButton selectPlayerTeamButton2 = new JButton("Player 2");

        // Do il Listener ai pulsanti
        // Listener Bottone Player1
        selectPlayerTeamButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player1;
                pokedex=pokedex1;// imposto come player che è in fase di scelta, quello premuto dal bottone
                ChooseTeam.super.repaint();          // faccio il repaint cosi si aggiorna
//                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList())
                pokedexPanel.repaint();
                pokedexPanel.setVisible(true);
                pokedexPanel2.setVisible(false);

                teamPanel.repaint();
                teamPanel.setVisible(true);
                teamPanel2.setVisible(false);

                playerInfo.setText(player1.playerInfo());
                playerIcon.setIcon(player1.getImage());


            }
        });

        // Listener Bottone Player2
        selectPlayerTeamButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player2;
                pokedex=pokedex2;
                ChooseTeam.super.repaint();
//                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList());
//                teamPanel.repaint();
                pokedexPanel2.repaint();
                pokedexPanel2.setVisible(true);
                pokedexPanel.setVisible(false);

                teamPanel2.repaint();
                teamPanel2.setVisible(true);
                teamPanel.setVisible(false);

                playerInfo.setText(player2.playerInfo());
                playerIcon.setIcon(player2.getImage());

            }
        });

//        selectPlayerTeamButton.setIcon(immBattleSelectTeamButton);
        selectPlayerTeamPanel.add(selectPlayerTeamButton1, BorderLayout.CENTER);           // Imposto il pulsante al centro del pannello
        selectPlayerTeamPanel.add(selectPlayerTeamButton2, BorderLayout.CENTER);
        selectPlayerTeamPanel.setBounds(325,420,110,85);     // posiziono il pannello nello spazio
        add(selectPlayerTeamPanel);             // Aggiungo il pannello al frame ChooseTeam





        BufferedImage imgPoke =null ;
        try {
            imgPoke = ImageIO.read(new File("src/Img/pokeball.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image imPoke = imgPoke.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);

        ImageIcon imgPokeball = new ImageIcon(imPoke);

        /*
        ACTION LISTENER DEI TASTI CON I POKEMON GIA' SELEZIONATI IN SQUADRA (LI RIMUOVO DALLA SQUADRA)
         */

        // Set up action listener per il player1 e quindi teamPanel1
        setupPokemonButtonListener(pokemon1, 0, player, teamPanel, imgPokeball);
        setupPokemonButtonListener(pokemon2, 1, player, teamPanel, imgPokeball);
        setupPokemonButtonListener(pokemon3, 2, player, teamPanel, imgPokeball);
        setupPokemonButtonListener(pokemon4, 3, player, teamPanel, imgPokeball);
        setupPokemonButtonListener(pokemon5, 4, player, teamPanel, imgPokeball);
        setupPokemonButtonListener(pokemon6, 5, player, teamPanel, imgPokeball);

        // Set up action listener per il player2 e quindi teamPanel2
        setupPokemonButtonListener(pokemon1_2, 0, player2, teamPanel2, imgPokeball);
        setupPokemonButtonListener(pokemon2_2, 1, player2, teamPanel2, imgPokeball);
        setupPokemonButtonListener(pokemon3_2, 2, player2, teamPanel2, imgPokeball);
        setupPokemonButtonListener(pokemon4_2, 3, player2, teamPanel2, imgPokeball);
        setupPokemonButtonListener(pokemon5_2, 4, player2, teamPanel2, imgPokeball);
        setupPokemonButtonListener(pokemon6_2, 5, player2, teamPanel2, imgPokeball);


        // Aggiungo i due teamPanel
        add(teamPanel);
        add(teamPanel2);


        //-----------------------------------------------

        //--PULSANTE AGGINGI POKEMON SELEZIONATO ALLA SQUADRA &  CAMBIA IMMAGINE RELATIVA AL PULSANTE DEL POKEMON NEL TEAM

        addTeam=new JButton("Add");

        // Parto che fino a quando non viene selezionato un pokemon dal pokedex questo tasto non è cliccabile
        addTeam.setOpaque(true);
        addTeam.setEnabled(false);



        //addTeam.setBounds(330,100, 50, 50);
        addTeam.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Una volta cliccato il bottone metto che non è più cliccabile fino a che non viene ricliccato un pokemon all'interno
                // dei pokedex.
                addTeam.setOpaque(true);
                addTeam.setEnabled(false);


                List<Pokemon> newTeam=player.getTeam();
                List<Pokemon> newTeam2=player2.getTeam();

                int index =-1;

                if (player == player1){
                    for(int i=0; i<newTeam.size(); i++) {
                        if (newTeam.get(i) == null) {
                            newTeam.set(i, selectedPokemon);
                            player1.setTeam(newTeam);
                            index = i;
                            System.out.println(player1.playerInfo());
                            System.out.println(player1.pokemonStringList());       // stampo in concsole il team del player per debuggare

                            // Imposto che il bottone di quel pokemon dopo che è stato selezionato, diventa non utilizzabile e opaco
                            PokeButton bottonePokemonAppenaAggiuntoInSquadra = selectedPokemon.getPokeButton();
                            bottonePokemonAppenaAggiuntoInSquadra.setOpaque(true);
                            bottonePokemonAppenaAggiuntoInSquadra.setEnabled(false);

                            // dopo averlo aggiunto, faccio il break
                            break;
                        }
                    }
                }else if (player == player2){
                    for(int i=0; i<newTeam2.size(); i++) {
                        if (newTeam2.get(i) == null) {
                            newTeam2.set(i, selectedPokemon);
                            player2.setTeam(newTeam2);
                            index = i;
                            System.out.println(player2.playerInfo());
                            System.out.println(player2.pokemonStringList());      // stampo in concsole il team del player per debuggare

                            // Imposto che il bottone di quel pokemon dopo che è stato selezionato, diventa non utilizzabile e opaco
                            PokeButton bottonePokemonAppenaAggiuntoInSquadra = selectedPokemon.getPokeButton();
                            bottonePokemonAppenaAggiuntoInSquadra.setOpaque(true);
                            bottonePokemonAppenaAggiuntoInSquadra.setEnabled(false);


                            break;
                        }
                    }
                }


                Image immNewPokemon = selectedPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon selectPokeImage = new ImageIcon(immNewPokemon);


                // IMPOSTO L'IMMAGINE DEL BOTTONE
                if(player == player1) {
                    switch (index) {
                        case 0: pokemon1.setIcon(selectPokeImage); break;
                        case 1: pokemon2.setIcon(selectPokeImage); break;
                        case 2: pokemon3.setIcon(selectPokeImage); break;
                        case 3: pokemon4.setIcon(selectPokeImage); break;
                        case 4: pokemon5.setIcon(selectPokeImage); break;
                        case 5: pokemon6.setIcon(selectPokeImage);break;
                        default: break;
                    }
                } else if (player == player2){
                    switch(index){
                        case 0:  pokemon1_2.setIcon(selectPokeImage); break;
                        case 1:  pokemon2_2.setIcon(selectPokeImage); break;
                        case 2:  pokemon3_2.setIcon(selectPokeImage); break;
                        case 3:  pokemon4_2.setIcon(selectPokeImage); break;
                        case 4:  pokemon5_2.setIcon(selectPokeImage); break;
                        case 5:  pokemon6_2.setIcon(selectPokeImage); break;
                        default: break;
                    }
                }
//
//
                //player.addPokemon(selectedPokemon);

                teamPanel.repaint();
                teamPanel2.repaint();

            }});

        wrapper.add(addTeam,BorderLayout.PAGE_END);


        // Alla chiusura di X si chiude tutto il frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        setVisible(true);

    }       // FINE COSTRUTTORE:




    // Metodo per i bottoni dei Pokemon selezionati nella squadra
    private void setupPokemonButtonListener(JButton button, int index, Player player, JPanel teamPanel, ImageIcon imgPokeball) {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (button.getIcon() != imgPokeball) {
                    selectedPartyPokemon = player.getTeam().get(index);

                    // Verifica se il selectedPartyPokemon è null
                    if (selectedPartyPokemon == null) {
                        JOptionPane.showMessageDialog(null, "Nessun Pokémon selezionato in questa posizione.", "Errore", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input = JOptionPane.showConfirmDialog(new JButton("Elimina"),
                            "Vuoi rimuovere " + selectedPartyPokemon.getName() + " dalla squadra?",
                            "remove?",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            selectPartyPokeImage);
                    if (input == JOptionPane.YES_OPTION) {
                        // Rendo il pokemon di nuovo selezionabile nel pokedex
                        JButton bottonePokemonSelezionato = selectedPartyPokemon.getPokeButton();
                        bottonePokemonSelezionato.setOpaque(false);
                        bottonePokemonSelezionato.setEnabled(true);

                        // Remove the Pokémon from the team
                        player.getTeam().set(index, null);
                        button.setIcon(imgPokeball);

                        // Update the panel
                        teamPanel.repaint();
                    }
                }
            }
        });
    }






















}     // FINE CLASSE
