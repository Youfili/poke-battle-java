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


        //PLAYER INFO
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
        teamPanel=new PartyPokemonPanel(player);
        JButton pokemon1 = teamPanel.getPokemon1();
        JButton pokemon2 = teamPanel.getPokemon2();
        JButton pokemon3 = teamPanel.getPokemon3();
        JButton pokemon4 = teamPanel.getPokemon4();
        JButton pokemon5 = teamPanel.getPokemon5();
        JButton pokemon6 = teamPanel.getPokemon6();




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
                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList());
                teamPanel.repaint();



            }
        });

        // Listener Bottone Player2
        selectPlayerTeamButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = player2;
                ChooseTeam.super.repaint();
                pokeInfoTextArea.setText(player.playerInfo()+player.pokemonStringList());
                teamPanel.repaint();

            }
        });

//        selectPlayerTeamButton.setIcon(immBattleSelectTeamButton);
        selectPlayerTeamPanel.add(selectPlayerTeamButton1, BorderLayout.CENTER);           // Imposto il pulsante al centro del pannello
        selectPlayerTeamPanel.add(selectPlayerTeamButton2, BorderLayout.CENTER);
        selectPlayerTeamPanel.setBounds(325,420,110,85);     // posiziono il pannello nello spazio
        add(selectPlayerTeamPanel);             // Aggiungo il pannello al frame ChooseTeam







        /*//TEAM PANEL-----------------------------------------------
        *//*JTextArea partyPokeTxt = new JTextArea(player.pokemonStringList());
        JScrollPane tm = new JScrollPane(partyPokeTxt);*//*
        JPanel teamPanel = new JPanel(new GridLayout(1,6));         // Pannello del team con una riga e 6 colonne (ogni colonna è un bottone del pokemon selezionato)
        teamPanel.setBorder(new TitledBorder("PARTY POKEMON"));
        //teamPanel.add(tm);
        teamPanel.setBounds(200,500,380,100);
        teamPanel.setVisible(true);

        JButton pokemon1 = new JButton("1");
        JButton pokemon2 = new JButton("2");
        JButton pokemon3 = new JButton("3");
        JButton pokemon4 = new JButton("4");
        JButton pokemon5 = new JButton("5");
        JButton pokemon6 = new JButton("6");

        //IMPOSTIAMO IMMAGINE DI DEFAULT PILSANTI TEAM ---> POKEBALL
        BufferedImage imgPoke =null ;
        try {
            imgPoke = ImageIO.read(new File("src/Img/pokeball.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image imPoke = imgPoke.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);

        ImageIcon imgPokeball = new ImageIcon(imPoke);

        // Setto le immagini di default del pannello delle pokeball
        if(player.getTeam().get(0)==null)
            pokemon1.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(0);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon1.setIcon(selectPartyPokeImage);
        }

        pokemon2.setIcon(imgPokeball);
        pokemon3.setIcon(imgPokeball);
        pokemon4.setIcon(imgPokeball);
        pokemon5.setIcon(imgPokeball);
        pokemon6.setIcon(imgPokeball);
*/

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
                    if(input==0){
                        player.getTeam().set(6,null);
                        pokemon6.setIcon(imgPokeball);
                        teamPanel.repaint();
                    }
                }
            }});







        add(teamPanel);


        //-----------------------------------------------

        //--PULSANTE AGGINGI POKEMON SELEZIONATO ALLA SQUADRA &  CAMBIA IMMAGINE RELATIVA AL PULSANTE DEL POKEMON NEL TEAM

        addTeam=new JButton("add");
        //addTeam.setBounds(330,100, 50, 50);
        addTeam.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                *//**//*player.replacePokemon(inGame,evolution);
                 *//*playerInfo.setText(player.toString());
                playerInfo.repaint();*/
                List<Pokemon> newTeam=player.getTeam();
                int index =-1;

                for(int i=0; i<newTeam.size(); i++) {
                    if (newTeam.get(i) == null) {
                        newTeam.set(i, selectedPokemon);
                        player.setTeam(newTeam);
                         index = i;
                        break;
                    }
                }
                Image immNewPokemon = selectedPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon selectPokeImage = new ImageIcon(immNewPokemon);


                // Metodo sostitutivo agli if sotto .... che eleganza !!
                switch(index){
                    case 0:  pokemon1.setIcon(selectPokeImage); break;
                    case 1:  pokemon2.setIcon(selectPokeImage); break;
                    case 2:  pokemon3.setIcon(selectPokeImage); break;
                    case 3:  pokemon4.setIcon(selectPokeImage); break;
                    case 4:  pokemon5.setIcon(selectPokeImage); break;
                    case 5:  pokemon6.setIcon(selectPokeImage); break;
                    default: break;
                }
//
//
                //player.addPokemon(selectedPokemon);

                //scrivi i party pokemon nell textarea
                /*partyPokeTxt.setText("");
                partyPokeTxt.append(player.pokemonStringList());
                partyPokeTxt.repaint();*/

                teamPanel.repaint();

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
