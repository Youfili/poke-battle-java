package Swing.menuFrame;

import Swing.menuFrame.battle.Battle;
import Swing.menuFrame.battle.PartyPokemonPanel;
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

import static java.lang.System.exit;

/*
IMPLEMENTARE VARIE CLASSI PANNELLI OGNUNA CON RELATIVE INFORMAZIONI E PULSANTI
METTERLE POI IN COLLEGAMENTO IN QUESTO FRAME
 */
public class ChooseTeam extends JFrame {

    //private List<Pokemon> pokemon=new ArrayList<Pokemon>();
    private Player player;
    private Player player1;
    private Player player2;
    private JPanel pokeInfoPanel;
    private JTextArea pokeInfoTextArea;
    private Pokedex pokedex;
    private JButton evolution;
    private JLabel playerIcon;
    private JTextArea playerInfo;
    private JButton addTeam;
    private JPanel playerInfoPanel;

    private PartyPokemonPanel teamPanel;
    private PartyPokemonPanel teamPanel2;

    private Pokemon selectedPokemon;
    private  Pokemon selectedPartyPokemon;

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
        pokedex= new Pokedex();

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

        teamPanel2 = new PartyPokemonPanel(player2);
        JButton pokemon1_2 = teamPanel2.getPokemon1();
        JButton pokemon2_2 = teamPanel2.getPokemon2();
        JButton pokemon3_2 = teamPanel2.getPokemon3();
        JButton pokemon4_2 = teamPanel2.getPokemon4();
        JButton pokemon5_2 = teamPanel2.getPokemon5();
        JButton pokemon6_2 = teamPanel2.getPokemon6();




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
                JOptionPane.setRootFrame(new Battle(player1, player2));
               // JOptionPane.setRootFrame(new Battle(player,null));
                setVisible(false);
            }
        });
        add(battleButtonPanel);             // Aggiungo il pannello al frame ChooseTeam



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
                player = player1;   // imposto come player che è in fase di scelta, quello premuto dal bottone
                ChooseTeam.super.repaint();          // faccio il repaint cosi si aggiorna
//                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList());
                teamPanel.repaint();
//                teamPanel2.repaint();
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
                ChooseTeam.super.repaint();
//                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList());
//                teamPanel.repaint();
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
        // Action Listener del tasto Pokemon1
        pokemon1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon1.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(0);
                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                   int input= JOptionPane.showConfirmDialog(new JButton("Elimina"),"Vuoi rimuovere "+ player.getTeam().get(0).getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                   if(input==0){
                       player.replacePokemon(selectedPartyPokemon,null);

                       System.out.println(player.pokemonStringList());
                       pokemon1.setIcon(imgPokeball);
                       teamPanel.repaint();
//                       teamPanel2.repaint();
                   }
                }
            }
        });
        // Action Listener del tasto Pokemon2
        pokemon2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(1);
                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.getTeam().set(1,null);

                        pokemon2.setIcon(imgPokeball);
                        teamPanel.repaint();
//                        teamPanel2.repaint();
                }
            }
        }});
        // Action Listener del tasto Pokemon3
        pokemon3.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon3.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(2);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.getTeam().set(2,null);
                        pokemon3.setIcon(imgPokeball);
                        teamPanel.repaint();
//                        teamPanel2.repaint();
                    }
                }
            }});

        // Action Listener del tasto Pokemon4
        pokemon4.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon4.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(3);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.getTeam().set(3,null);
                        pokemon4.setIcon(imgPokeball);
                        teamPanel.repaint();
//                        teamPanel2.repaint();
                    }
                }
            }});
        // Action Listener del tasto Pokemon5
        pokemon5.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon5.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(4);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.getTeam().set(4,null);
                        pokemon5.setIcon(imgPokeball);
                        teamPanel.repaint();
//                        teamPanel2.repaint();
                    }
                }
            }});
        // Action Listener del tasto Pokemon6
        pokemon6.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon6.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(5);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){       // Rimuovo il pokemon dalla squadra
                        player.getTeam().set(6,null);
                        pokemon6.setIcon(imgPokeball);
                        teamPanel.repaint();
//                        teamPanel2.repaint();
                    }
                }
            }});


        //  --------------- TASTI POKEMON PANNELO PLAYER 2  ----------------- ////
        // Action Listener del tasto Pokemon1
        pokemon1_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon1_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(0);
                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("Elimina"),"Vuoi rimuovere "+ player.getTeam().get(0).getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player2.replacePokemon(selectedPartyPokemon,null);

                        System.out.println(player2.pokemonStringList());
                        pokemon1_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }
        });
        // Action Listener del tasto Pokemon2
        pokemon2_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon2_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(1);
                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player2.getTeam().set(1,null);

                        pokemon2_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }});
        // Action Listener del tasto Pokemon3
        pokemon3_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon3_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(2);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player2.getTeam().set(2,null);
                        pokemon3_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }});

        // Action Listener del tasto Pokemon4
        pokemon4_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon4_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(3);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player2.getTeam().set(3,null);
                        pokemon4_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }});
        // Action Listener del tasto Pokemon5
        pokemon5_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon5_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(4);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player2.getTeam().set(4,null);
                        pokemon5_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }});
        // Action Listener del tasto Pokemon6
        pokemon6_2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon6_2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player2.getTeam().get(5);

                    Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){       // Rimuovo il pokemon dalla squadra
                        player2.getTeam().set(6,null);
                        pokemon6_2.setIcon(imgPokeball);
//                        teamPanel.repaint();
                        teamPanel2.repaint();
                    }
                }
            }});









        // Aggiungo i due teamPanel
        add(teamPanel);
        add(teamPanel2);


        //-----------------------------------------------

        //--PULSANTE AGGINGI POKEMON SELEZIONATO ALLA SQUADRA &  CAMBIA IMMAGINE RELATIVA AL PULSANTE DEL POKEMON NEL TEAM

        addTeam=new JButton("Add");
        //addTeam.setBounds(330,100, 50, 50);
        addTeam.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                *//**//*player.replacePokemon(inGame,evolution);
                 *//*playerInfo.setText(player.toString());
                playerInfo.repaint();*/
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
                            break;
                        }
                    }
                }

                // CODICE CORRETTO QUESTO SOTTO, --> Copiato nell'if sopra
//                for(int i=0; i<newTeam.size(); i++) {
//                    if (newTeam.get(i) == null) {
//                        newTeam.set(i, selectedPokemon);
//                        player.setTeam(newTeam);
//                         index = i;
//                        break;
//                    }
//                }
                Image immNewPokemon = selectedPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon selectPokeImage = new ImageIcon(immNewPokemon);


                // IMPOSTO L'IMMAGINE DEL BOTTONE
                // Metodo sostitutivo agli if sotto .... che eleganza !!
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

                //scrivi i party pokemon nell textarea
                /*partyPokeTxt.setText("");
                partyPokeTxt.append(player.pokemonStringList());
                partyPokeTxt.repaint();*/

                teamPanel.repaint();
                teamPanel2.repaint();

            }});

        wrapper.add(addTeam,BorderLayout.PAGE_END);







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






        //CREAZIONE PULSANTI POKEMON PER OGNI POKEMON NEL POKEDEX
        int x=20;
        int y=30;
        for (Pokemon poke : pokedex.getPokedex()) {

            Image dimg = poke.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            JButton pokeButton = new JButton(poke.getName());//creating instance of JButton --> Return pokemon name
            pokeButton.setBounds(x,y, 50, 50);//x axis, y axis, width, height
            pokeButton.setIcon(imageIcon);
            pokeButton.setOpaque(false);
            pokeButton.setBorderPainted(false);

            pokeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //JOptionPane.showMessageDialog((Component) null, poke.toString(), null, JOptionPane.INFORMATION_MESSAGE, imageIcon);

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
            y+=60;


            pokedexPanel.add(pokeButton);


        }
        pokedexPanel.add(back);
        pokedexPanel.setVisible(true);
        add(pokedexPanel);


        //PULSANTE DI TEST PER EVOLUZIONI
       /* evolution=new JButton("Evolution");
        evolution.setBounds(50,400, 50, 50);
        evolution.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                player.replacePokemon(inGame,evolution);
                playerInfo.setText(player.toString());
                playerInfo.repaint();


            }
        });

        add(evolution);
*/



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);


    }

}
