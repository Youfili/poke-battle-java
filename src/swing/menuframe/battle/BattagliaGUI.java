package swing.menuframe.battle;

import moves.Move;
import moves.base.Action;
import moves.base.BodySlam;
import moves.base.Frustration;
import moves.base.GigaImpact;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;
import swing.menuframe.battle.battleview.ScoreOfBattles;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


public class BattagliaGUI extends JFrame implements ActionListener, Serializable {
    private Player giocatore1;
    private Player giocatore2;
    private Move mossaSelezionata1;
    private Move mossaSelezionata2;
    private JPanel pannelloAzioni;
    private JLabel statoBattaglia;
    private int giocatoreDiTurno = 1;
    private PokeBattleInfoPanel poke1InfoPanel;
    private PokeBattleInfoPanel poke2InfoPanel;
    private PokeImgLabel pokemon1Image;
    private PokeImgLabel pokemon2Image;
    private ScoreOfBattles scorePanel;


    public BattagliaGUI(Player player1, Player player2) {
        // Creazione dei giocatori
        giocatore1 = player1;
        giocatore2 = player2;


        setSize(600,650);//600 width and 650 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);


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


        // Aggiunta delle mosse ai Pokémon
        giocatore1.setPokemonAttivo(giocatore1.getTeam().get(0));
        giocatore2.setPokemonAttivo(giocatore2.getTeam().get(0));

        // Impostazione della finestra
        setTitle("Battaglia Pokémon");




        // Pannello per le azioni del giocatore
//        pannelloAzioni = new JPanel();
        pannelloAzioni = new JPanel(new GridLayout(2,2,2,2));
        pannelloAzioni.setBounds(245,500,345,100);
        pannelloAzioni.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        // Pannello per lo stato della battaglia
        statoBattaglia = new JLabel("Scegli un'azione per " + (giocatoreDiTurno==1?giocatore1.getPokemonAttivo().getName():giocatore2.getPokemonAttivo().getName()));
        JPanel pannelloStato = new JPanel();
        pannelloStato.setLayout(new BorderLayout());
        pannelloStato.setBounds(10,500,230,100);
        pannelloStato.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        pannelloStato.add(statoBattaglia);


        // IMMAGINE POKEMON 1
        pokemon1Image = new PokeImgLabel(giocatore1.getPokemonAttivo());
        pokemon1Image.setBounds(10,250,300,300);
        this.add(pokemon1Image);

        // IMMAGINE POKEMON 2
         pokemon2Image = new PokeImgLabel(giocatore2.getPokemonAttivo());
        pokemon2Image.setBounds(300,100,300,300);
        this.add(pokemon2Image);

        //PANNELLO INFO POKEMON 1
         poke1InfoPanel=new PokeBattleInfoPanel(giocatore1.getPokemonAttivo());
        poke1InfoPanel.setBounds(350,380,200,100);
        this.add(poke1InfoPanel);

        //PANNELLO INFO POKEMON 2
        poke2InfoPanel=new PokeBattleInfoPanel(giocatore2.getPokemonAttivo());
        poke2InfoPanel.setBounds(50,80,200,100);
        this.add(poke2InfoPanel);

        // Aggiunta dei pannelli alla finestra

        add(pannelloStato);
        add(pannelloAzioni);

        // Aggiunta del bottone per attaccare
        JButton attaccoButton = new JButton("Attacca");
        attaccoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pannelloAzioni.removeAll();
                pannelloAzioni.add(creaPannelloMosse(giocatore1.getPokemonAttivo().getMoves(), 1));
                revalidate();
                repaint();
            }
        });
        pannelloAzioni.add(attaccoButton);

        // Aggiunta del bottone per cambiare Pokémon
        JButton cambioButton = new JButton("Cambia Pokémon");
        cambioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pannelloAzioni.removeAll();
                pannelloAzioni.add(creaPannelloCambioPokemon(giocatore1.getTeam(), 1));
                statoBattaglia.setText("Scegli un nuovo Pokemon ");


                revalidate();
                repaint();
            }
        });
        pannelloAzioni.add(cambioButton);


        // Inizializzo e posiziono il Pannello del Punteggio
        scorePanel = new ScoreOfBattles(giocatore1, giocatore2);
        scorePanel.setBounds(375,35,200,30);                // Posizionato nel frame BattagliaGUI
        add(scorePanel);                                                        // lo aggiungo alla BattagliaGUI



        add(wallpaper);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);

    }  // FINE COSTRUTTORE



    private JPanel creaPannelloAzioni() {
        JPanel pannelloAzioni = new JPanel(new GridLayout(2, 2,2,2));
//        JPanel pannelloAzioni = new JPanel();
//        pannelloAzioni.setLayout(new GridLayout(2, 2,2,2));

        // Bottone "Attacca"
        JButton attaccaButton = new JButton("Attacca");
        attaccaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pannelloAzioni.removeAll();
                pannelloAzioni.add(creaPannelloMosse(giocatoreDiTurno == 1 ? giocatore1.getPokemonAttivo().getMoves() : giocatore2.getPokemonAttivo().getMoves(), giocatoreDiTurno));
                revalidate();
                repaint();
            }
        });
        pannelloAzioni.add(attaccaButton);

        // Bottone "Cambia Pokémon"
        JButton cambioButton = new JButton("Cambia Pokémon");
        cambioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pannelloAzioni.removeAll();
                pannelloAzioni.add(creaPannelloCambioPokemon(giocatoreDiTurno == 1 ? giocatore1.getTeam() : giocatore2.getTeam(), giocatoreDiTurno));
                statoBattaglia.setText("Scegli un nuovo Pokemon ");

                revalidate();
                repaint();
            }
        });
        pannelloAzioni.add(cambioButton);

        return pannelloAzioni;
    }

    // Metodo per creare un pannello con i bottoni delle mosse
    private JPanel creaPannelloMosse(List<Move> mosse, int giocatore) {
        JPanel pannelloMosse = new JPanel();
        pannelloMosse.setLayout(new GridLayout(2, 2));
        for (Move mossa : mosse) {
            JButton button = new JButton(mossa.getName());
            button.addActionListener(new ActionListener() {

                // Metodo per gestire l'azione del pannello delle mosse
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() instanceof JButton) {
                        JButton button = (JButton) e.getSource();
                        String nomeMossa = button.getText();

                        // Determina il giocatore corrente in base alla variabile giocatoreDiTurno
                        Player giocatoreCorrente = (giocatoreDiTurno == 1) ? giocatore1 : giocatore2;

                        // Seleziona la mossa scelta dal giocatore corrente
                        for (Move mossa : giocatoreCorrente.getPokemonAttivo().getMoves()) {
                            if (mossa.getName().equals(nomeMossa)) {
                                if (giocatoreDiTurno == 1) {
                                    mossaSelezionata1 = mossa;
                                } else {
                                    mossaSelezionata2 = mossa;
                                }
                                break;
                            }
                        }

                        // Passa al turno successivo (mostrando il pannello delle mosse dell'altro giocatore)
                        if (giocatoreDiTurno == 1) {
                            pannelloAzioni.removeAll();
                            giocatoreDiTurno = 2;
                            pannelloAzioni.add(creaPannelloAzioni());
                            statoBattaglia.setText("Scegli un'azione per " +giocatore2.getPokemonAttivo().getName());// Cambia il turno al giocatore 2
                        } else {
                            // Entrambi i giocatori hanno selezionato le mosse, esegui la battaglia
                            eseguiTurno();
                            // Ripristina il pannello delle azioni per il prossimo turno
                            pannelloAzioni.removeAll();
                            pannelloAzioni.add(creaPannelloAzioni());
                            giocatoreDiTurno = 1; // Torna al turno del giocatore 1
                        }

                        // Aggiorna il pannello delle azioni
                        revalidate();
                        repaint();
                    }
                }
            });
            pannelloMosse.add(button);
        }
        return pannelloMosse;
    }

    // Metodo per creare un pannello con i bottoni di cambio Pokémon
    private JPanel creaPannelloCambioPokemon(List<Pokemon> squadra, int giocatore) {
        JPanel pannelloCambio = new JPanel();
        pannelloCambio.setLayout(new GridLayout(1,6,2,2));
        for (Pokemon pokemon : squadra) {
            if(pokemon!=null) {
                JButton button = new JButton();

                Image pokeImg = pokemon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon pokeIm = new ImageIcon(pokeImg);
                button.setIcon(pokeIm);

                button.setOpaque(false);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pokemon.isAlive()) {


                            if (giocatore == 1) {
                                giocatore1.setPokemonAttivo(pokemon);
                                aggiornaBottoniMosse(1, true);
                                aggiornaImgPokemon(pokemon, 1);
                                aggiornaPokeInfoPanel(pokemon, 1);
                            } else {
                                giocatore2.setPokemonAttivo(pokemon);
                                aggiornaBottoniMosse(2, true);
                                aggiornaImgPokemon(pokemon, 2);
                                aggiornaPokeInfoPanel(pokemon, 2);

                            }
                            revalidate();
                            repaint();
                            statoBattaglia.setText("Scegli un'azione per  " + pokemon.getName());
                        }
                        JOptionPane.showMessageDialog(new JButton("ok"),pokemon.getName()+" é esausto non può entrare in campo");


                    }
                });

                pannelloCambio.add(button);
            }

        }
        return pannelloCambio;
    }

    // Metodo per aggiornare i bottoni delle mosse
    private void aggiornaBottoniMosse(int giocatore, boolean abilitati) {
        if (giocatore == 1) {
            pannelloAzioni.removeAll();
            pannelloAzioni.add(creaPannelloMosse(giocatore1.getPokemonAttivo().getMoves(), giocatore));
            revalidate();
            repaint();
            // Abilita o disabilita i bottoni delle mosse per il giocatore 1 in base al parametro "abilitati"
            for (Component componente : pannelloAzioni.getComponents()) {
                componente.setEnabled(abilitati);
            }
        } else {
            pannelloAzioni.removeAll();
            pannelloAzioni.add(creaPannelloMosse(giocatore2.getPokemonAttivo().getMoves(), giocatore));
            revalidate();
            repaint();
            // Abilita o disabilita i bottoni delle mosse per il giocatore 2 in base al parametro "abilitati"
            for (Component componente : pannelloAzioni.getComponents()) {
                componente.setEnabled(abilitati);
            }
            
        }
    }
    public void aggiornaImgPokemon(Pokemon pokemon,int giocatore) {
        Image pokeImg= pokemon.getImage().getScaledInstance(300, 300,
                Image.SCALE_SMOOTH);
        ImageIcon pokeIm = new ImageIcon(pokeImg);
        if (giocatore == 1) {
            pokemon1Image.setIcon(pokeIm);
            pokemon1Image.setVisible(true);
            revalidate();
            repaint();

        }
        else{
            pokemon2Image.setIcon(pokeIm);
            pokemon2Image.setVisible(true);
            revalidate();
            repaint();
        }
    }

    public void aggiornaPokeInfoPanel(Pokemon pokemon,int giocatore) {
        if (giocatore == 1) {
            poke1InfoPanel.setPokemon(pokemon);
            poke1InfoPanel.repaint();
            revalidate();
            repaint();

        }
        else{
            poke2InfoPanel.setPokemon(pokemon);
            poke2InfoPanel.repaint();
            revalidate();
            repaint();
        }

    }


    // Metodo per eseguire il turno di battaglia
    private void eseguiTurno() {
        // Controlla se entrambi i giocatori hanno selezionato una mossa
        if (mossaSelezionata1 != null && mossaSelezionata2 != null) {
            // Effettua il confronto della velocità per determinare chi attacca per primo
            if (giocatore1.getPokemonAttivo().getSpeed() > giocatore2.getPokemonAttivo().getSpeed()) {
                eseguiMossa(giocatore1, giocatore2, mossaSelezionata1);
                if (!giocatore2.getPokemonAttivo().isDead()) {
                    eseguiMossa(giocatore2, giocatore1, mossaSelezionata2);
                }
            } else if (giocatore1.getPokemonAttivo().getSpeed() < giocatore2.getPokemonAttivo().getSpeed()) {
                eseguiMossa(giocatore2, giocatore1, mossaSelezionata2);
                if (!giocatore1.getPokemonAttivo().isDead()) {
                    eseguiMossa(giocatore1, giocatore2, mossaSelezionata1);
                }
            } else { // Se i Pokémon hanno la stessa velocità, l'attacco avviene casualmente
                //IMPLEMENTARE VELCITà RELATIVA ALLA MOSSA
                System.out.println(giocatore1.getPokemonAttivo().equals(giocatore2.getPokemonAttivo()));
                double random = Math.random();
                if (random < 0.5) {
                    eseguiMossa(giocatore1, giocatore2, mossaSelezionata1);
                    if (!giocatore2.getPokemonAttivo().isDead()) {
                        eseguiMossa(giocatore2, giocatore1, mossaSelezionata2);
                    }
                } else {
                    eseguiMossa(giocatore2, giocatore1, mossaSelezionata2);
                    if (!giocatore1.getPokemonAttivo().isDead()) {
                        eseguiMossa(giocatore1, giocatore2, mossaSelezionata1);
                    }
                }
            }




            // Resetta le mosse selezionate
            mossaSelezionata1 = null;
            mossaSelezionata2 = null;

            // Aggiorna le barre della vita
            poke1InfoPanel.getHpBar().setValue(giocatore1.getPokemonAttivo().getHealth());
            poke2InfoPanel.getHpBar().setValue(giocatore2.getPokemonAttivo().getHealth());

            // Controlla se uno dei Pokémon è stato sconfitto AGGIUNGI OBLIGO DI CAMBIO POKEMON
            // //SETTA IMMAGINE NON VISIBILE E POKEMON NON UTILIZZABILE
            if (giocatore1.getPokemonAttivo().isDead()) {
                statoBattaglia.setText(giocatore1.getPokemonAttivo().getName() + " è stato sconfitto!");
                pokemon1Image.setVisible(false);
                // Disabilita i bottoni delle mosse per il giocatore 1
                aggiornaBottoniMosse(1, false);
            }

            if (giocatore2.getPokemonAttivo().isDead()) {
                statoBattaglia.setText(giocatore2.getPokemonAttivo().getName() + " è stato sconfitto!");
                pokemon2Image.setVisible(false);
                // Disabilita i bottoni delle mosse per il giocatore 2
                aggiornaBottoniMosse(2, false);
            }
        }
    }
    // Metodo per gestire l'azione del giocatore di turno
    @Override
    public void actionPerformed(ActionEvent e) {
        if (giocatoreDiTurno == 1) {
            // Azioni del giocatore 1
            if (e.getSource() instanceof JButton) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("Attacca")) {
                    pannelloAzioni.removeAll();
                    pannelloAzioni.add(creaPannelloMosse(giocatore1.getPokemonAttivo().getMoves(), giocatoreDiTurno));
                } else if (button.getText().equals("Cambia Pokémon")) {
                    pannelloAzioni.removeAll();
                    pannelloAzioni.add(creaPannelloCambioPokemon(giocatore1.getTeam(), giocatoreDiTurno));
                } else {
                    // Azione del giocatore 1 selezionata
                    String nomeMossa = button.getText();
                    for (Move mossa : giocatore1.getPokemonAttivo().getMoves()) {
                        if (mossa.getName().equals(nomeMossa)) {
                            mossaSelezionata1 = mossa;
                            break;
                        }
                    }
                    eseguiTurno();
                }
            }
        } else {
            // Azioni del giocatore 2
            if (e.getSource() instanceof JButton) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("Attacca")) {
                    pannelloAzioni.removeAll();
                    pannelloAzioni.add(creaPannelloMosse(giocatore2.getPokemonAttivo().getMoves(), giocatoreDiTurno));
                } else if (button.getText().equals("Cambia Pokémon")) {
                    pannelloAzioni.removeAll();
                    pannelloAzioni.add(creaPannelloCambioPokemon(giocatore2.getTeam(), giocatoreDiTurno));
                } else {
                    // Azione del giocatore 2 selezionata
                    String nomeMossa = button.getText();
                    for (Move mossa : giocatore2.getPokemonAttivo().getMoves()) {
                        if (mossa.getName().equals(nomeMossa)) {
                            mossaSelezionata2 = mossa;
                            break;
                        }
                    }
                    eseguiTurno();
                }
            }
        }

        // Dopo che entrambi i giocatori hanno eseguito le loro azioni, passa al turno successivo
        giocatoreDiTurno = (giocatoreDiTurno == 1) ? 2 : 1;
    }

    private void eseguiMossa(Player attaccante, Player difensore, Move mossa) {
        Pokemon pokemonAttaccante = attaccante.getPokemonAttivo();
        Pokemon pokemonDifensore = difensore.getPokemonAttivo();

        // Calcola il danno dell'attacco in base alla potenza della mossa
        int danno = mossa.getDamage();

        // Modifica il danno in base al tipo di mossa e al tipo del Pokémon difensore (implementazione a tuo criterio)
        // Ad esempio, puoi implementare un sistema di efficacia basato sui tipi di Pokémon, come in Pokémon originale

        // Applica il danno al Pokémon difensore
        pokemonDifensore.setHealth(pokemonDifensore.getHealth()-danno);

        // Aggiorna lo stato della battaglia
        statoBattaglia.setText(pokemonAttaccante.getName() + " usa " + mossa.getName() + " su " + pokemonDifensore.getName() +
                " e infligge " + danno + " punti vita di danno!");
    }

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

                BattagliaGUI gui = new BattagliaGUI(red,hash);
            gui.setVisible(true);

            System.out.println(red.pokemonStringList());
    }

}
