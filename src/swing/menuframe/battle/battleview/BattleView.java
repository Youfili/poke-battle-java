package swing.menuframe.battle.battleview;

import swing.menuframe.battle.battlecontroller.BattleController;
import moves.base.Action;
import moves.base.BodySlam;
import moves.base.Frustration;
import moves.base.GigaImpact;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;
import swing.menuframe.battle.battlemodel.BattleModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLOutput;

public class BattleView extends JFrame implements Serializable {

    // Controller della battaglia, collega la BattleView con la BattleModel


    private Player giocatore1;
    private Player giocatore2;

    // Creo l'istanza del controller all'interno della BattleView
    private BattleController controllerBattaglia = new BattleController(new BattleModel(giocatore1, giocatore2, this),this);;



    private JLabel statoBattaglia;
    private int giocatoreDiTurno = 1;
    private PokeBattleInfoPanel poke1InfoPanel;
    private PokeBattleInfoPanel poke2InfoPanel;
    private PokeImgLabel pokemon1Image;
    private PokeImgLabel pokemon2Image;
    private ScoreOfBattles scorePanel;


    // Pannelli della scelta del tipo di azioni da far fare al pokemon
    private CardLayout cardLayout1;
    private CardLayout cardLayout2;
    //Pannelli da associare al CardLayout
    private JPanel panPrincAzi1 = new JPanel();
    private JPanel panPrincAzi2 = new JPanel();

    // SottoPannelli
    private JPanel pannelloAzioni1;
    private JPanel pannelloAzioni2;
    // SottoPannelli Giocatore 1
    private PannelloMosse pannelloMosse1;
    private PannelloCambioPokemon pannelloCambio1;
    // SottoPannelli Giocatore 2
    private PannelloMosse pannelloMosse2;
    private PannelloCambioPokemon pannelloCambio2;

    private JButton attaccoButton1;
    private JButton attaccoButton2;
    private JButton cambioButton1;
    private JButton cambioButton2;

    private Pokemon pokemon1InCampo;
    private Pokemon pokemon2InCampo;


    public BattleView(Player giocatore1, Player giocatore2) {
        // Creazione dei giocatori
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;

        // Dimensioni Frame Battaglia
        setSize(600,650);//600 width and 650 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);


//        // Carico il controller
//        modelBattaglia = new BattleModel(giocatore1, giocatore2);
//        controllerBattaglia = new BattleController(modelBattaglia,this);


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
        // Aggiunta dei Pokémon alle squadre dei giocatori

        // Impostazione della finestra
        setTitle("Battaglia Pokémon");

        // Pannello per le azioni del giocatore
        pannelloAzioni1 = new JPanel(new GridLayout(2,2,3,3));
        pannelloAzioni1.setBounds(245,500,345,100);
        pannelloAzioni1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        // Bottoni del pannello azioni
        attaccoButton1 = new JButton("Attacca");
        cambioButton1 = new JButton("Cambia Pokémon");

        // Pannello per le azioni del giocatore
        pannelloAzioni2 = new JPanel(new GridLayout(2,2,2,2));
        pannelloAzioni2.setBounds(245,500,345,100);
        pannelloAzioni2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        // Bottoni del pannello azioni
        attaccoButton2 = new JButton("Attacca");
        cambioButton2 = new JButton("Cambia Pokémon");


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*      Action Listener legati alla grafica      */

        // Pannello1   ////
        attaccoButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaPannello(panPrincAzi1, "Mosse1");
            }
        });
        // Pannello1
        cambioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaPannello(panPrincAzi1, "Cambio1");
            }
        });

        // Pannello2        ////
        attaccoButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaPannello(panPrincAzi1, "Mosse1");
            }
        });
        // Pannello2
        cambioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiaPannello(panPrincAzi1, "Cambio1");
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////


        // Aggiungo i bottoni al pannello Azioni
        pannelloAzioni1.add(attaccoButton1);
        pannelloAzioni1.add(cambioButton1);
        pannelloAzioni2.add(attaccoButton2);
        pannelloAzioni2.add(cambioButton2);

        // Inizializzo i pokemon in campo delle due squadre (sono i due pokemon starter
        pokemon1InCampo = giocatore1.getTeam().get(0);
        pokemon2InCampo = giocatore2.getTeam().get(0);

        // IMMAGINE POKEMON 1  --> Di Default uso quella del primo pokemon in squadra del giocatore1
        pokemon1Image = new PokeImgLabel(pokemon1InCampo);
        pokemon1Image.setBounds(10,250,300,300);
        this.add(pokemon1Image);

        // IMMAGINE POKEMON 2  --> Di Default uso quella del primo pokemon in squadra del giocatore2
        pokemon2Image = new PokeImgLabel(pokemon2InCampo);
        pokemon2Image.setBounds(300,100,300,300);
        this.add(pokemon2Image);

        //PANNELLO INFO POKEMON 1
        poke1InfoPanel=new PokeBattleInfoPanel(pokemon1InCampo);
        poke1InfoPanel.setBounds(350,380,200,100);
        this.add(poke1InfoPanel);

        //PANNELLO INFO POKEMON 2
        poke2InfoPanel=new PokeBattleInfoPanel(pokemon2InCampo);
        poke2InfoPanel.setBounds(50,80,200,100);
        this.add(poke2InfoPanel);

        // Pannello per lo stato della battaglia
        statoBattaglia = new JLabel("Scegli un'azione per " + (giocatoreDiTurno==1?pokemon1InCampo.getName():pokemon2InCampo.getName()));
        JPanel pannelloStato = new JPanel(new BorderLayout());
        pannelloStato.setBounds(10,500,230,100);
        pannelloStato.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        pannelloStato.add(statoBattaglia);



        /*    SottoPannelli del pannelloAzioni   */
        // SottoPannelli Giocatore 1
        this.pannelloMosse1 = new PannelloMosse(pokemon1InCampo);
        this.pannelloCambio1 = new PannelloCambioPokemon(giocatore1);
        // SottoPannelli Giocatore 2
        this.pannelloMosse2 = new PannelloMosse(pokemon2InCampo);
        this.pannelloCambio2 = new PannelloCambioPokemon(giocatore2);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*   Aggiungo gli ActionListener dei bottoni delle mosse e dei cambio pokemon  */
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*  ACTIONLISTENER BOTTONI MOSSE */
        for(Component bottone : pannelloMosse1.getComponents()){
            // Faccio il casting del bottone che è un Component in MoveButton
            MoveButton bottoneMossa = (MoveButton) bottone;
            // Aggiungo l'ActionListener al bottoneMossa
            bottoneMossa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // In questo caso Pokemon1InCampo è il Pokemon che ATTACCA, pokemon2InCampo è il Pokemon che DIFENDE
                    controllerBattaglia.eseguiMoveBotton(bottoneMossa, pokemon1InCampo, pokemon2InCampo);
                }
            });
        }

        /*  ACTIONLISTENER BOTTNI CAMBIOPOKEMON   */
        for(Component bottone : pannelloCambio1.getComponents()){
            // Casting del Component in PokeButton
            PokeButton bottoneCambio = (PokeButton) bottone;
            // Aggiungo ActionListener al bottoneCambio
            bottoneCambio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // cambio con il pokemon del bottone
                    controllerBattaglia.cambioPokemon(bottoneCambio.getPokemonDelBottone());
                    // Metodo nel view che va a switchare l'immagine del pokmeon in campo
                    cambioPokemonGrafica(bottoneCambio.getPokemonDelBottone());
                }
            });
        }




















        // Inizializzo e posiziono il Pannello del Punteggio
        scorePanel = new ScoreOfBattles(giocatore1, giocatore2);
        scorePanel.setBounds(375,35,200,30);                // Posizionato nel frame BattagliaGUI
        add(scorePanel);                                                        // lo aggiungo alla BattagliaGUI



        // CardLayout per muovermi.
        cardLayout1 = new CardLayout();
        panPrincAzi1.setLayout(cardLayout1);
        cardLayout2 = new CardLayout();
        panPrincAzi2.setLayout(cardLayout2);

        // Aggiungo i sotto pannelli
        // Sistemo il CardLayout e aggiungo i pannelli
        // Sistemo il CardLayout e aggiungo i pannelli
        panPrincAzi1.setBounds(245,500,345,100);
        panPrincAzi1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        // Aggiungo i CardPanel
        panPrincAzi1.add(pannelloAzioni1, "Azioni1");
        panPrincAzi1.add(pannelloMosse1, "Mosse1");
        panPrincAzi1.add(pannelloCambio1, "Cambio1");

        // Sistemo il CardLayout e aggiungo i pannelli
        panPrincAzi2.setBounds(245,500,345,100);
        panPrincAzi2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        // Aggiungo i CardPanel
        panPrincAzi2.add(pannelloAzioni2, "Azioni2");
        panPrincAzi2.add(pannelloMosse2, "Mosse2");
        panPrincAzi2.add(pannelloCambio2, "Cambio2");


        // Aggiungo tutto ciò che è necessario al frame principale
        add(pannelloStato);
        add(panPrincAzi2);
        add(panPrincAzi1);
        add(wallpaper);

        // All'inizio viene visualizzato quello del player1
        panPrincAzi1.setVisible(true);
        panPrincAzi2.setVisible(false);

        /*
        ESEMPIO DI COME CAMBIARE I PANNELLI

            // Cambia al pannello "Mosse1" nel panPrincAzi1
            cambiaPannello(panPrincAzi1, "Mosse1");

            // Cambia al pannello "Cambio2" nel panPrincAzi2
            cambiaPannello(panPrincAzi2, "Cambio2");
        */


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        setVisible(true);


    }  // FINE COSTRUTTORE

    // Metodo per cambiare il pannello all'interno dell'area di scelta azione del pokeAllenatore
    // Metodo per cambiare i pannelli

    private void cambiaPannello(JPanel cardPanel, String nomePannello) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, nomePannello);
    }

    private void resettaPannello1() {
        cardLayout1.show(panPrincAzi1, "Azioni1");
    }

    public void resettaPannello2() {
            cardLayout2.show(panPrincAzi2, "Azioni2");
    }

    public void cambioPokemonGrafica(Pokemon nuovoPokemon1InCampo) {
        // Debug stampa
        System.out.println("Ho cambiato pokemon e inserito: " + nuovoPokemon1InCampo.getName());

        // Rimposta l'immagine del pokemon in campo
        this.remove(pokemon1Image); // lo rimuove dal BattleView
        pokemon1Image = new PokeImgLabel(nuovoPokemon1InCampo); // lo aggiorna
        pokemon1Image.setBounds(10, 250, 300, 300);
        this.add(pokemon1Image);

        // Rimposta l'infoPanel del pokemon in campo
        this.remove(poke1InfoPanel); // lo rimuove dal BattleView
        poke1InfoPanel = new PokeBattleInfoPanel(nuovoPokemon1InCampo); // lo aggiorna
        poke1InfoPanel.setBounds(350, 380, 200, 100);
        this.add(poke1InfoPanel);

        // Cambia il pokemon in attacco
        this.pokemon1InCampo = nuovoPokemon1InCampo;
        // Reset del pannello (se necessario)
        resettaPannello1();

        // Forza il rilayout e il ridisegno del frame
        this.revalidate();
        this.repaint();
    }


    public void aggiornaPokemonEsausto(Pokemon pokeEsausto){
        // Implementare i CAMBIAMENTI VISIVI che comporta avere un pokemon esausto
        // ad esempio la "cancellazione" dell'immagine del pokemon dal campo di battaglia
        // ....
        // Il pokemon è stato impostato a isAlive = false (è Esausto)

        System.out.println("Metodo aggiornaPokemonEsausto ancora da implementare");
        /*   NOTA : in questo caso va forzato il player a cambiare pokemon, aggiornando il tasto del pokemon esausto mettendolo Opaco o comunque non selezionabile
                    del pokemon esausto
         */
    }



























    // MAIN PROVA

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        Pokedex pokedex2 = new Pokedex();
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
        }
        for(Pokemon pokem : pokedex2.getPokedex()){
            pokem.addMove(new Action());
            pokem.addMove(new Frustration());
            pokem.addMove(new GigaImpact());
            pokem.addMove(new BodySlam());


            red.addPokemon(pokem);
        }

            BattleView battle = new BattleView(red,hash);
            battle.setVisible(true);

            System.out.println(red.pokemonStringList());
    }

    public PokeBattleInfoPanel getPoke2InfoPanel() {
        return poke2InfoPanel;
    }
}