package Swing.menuFrame.battle;

import moves.base.Action;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Frame per la Battaglia (nel quale andramo a implementare il sistema di combattimento principale

public class Battle extends JFrame {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Pokemon pokemonInGame1;
    private Pokemon pokemonInGame2;

    private PokePanel pokePanel;

    private JPanel panelBattle = new JPanel(new BorderLayout());

    // QUESTO E' QUELLO CORRETTO CON DUE GIOCATORI
//    public Battle (Player player1InGame, Player player2InGame){
//        this.player1 = player1InGame;
//        this.player2 = player2InGame;
//    }

    // Costruttore
    public Battle(Player player1InGame ,Player player2) throws HeadlessException {
        this.player1 = player1InGame;
        this.player2 = player2;

        setSize(600,650);//400 width and 500 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);

        pokemonInGame1=player1.getTeam().get(0);
        pokemonInGame2=player2.getTeam().get(0);


        BufferedImage img = null ;
        try {
            img = ImageIO.read(new File("src/Img/battleBack1.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

        Image dimg = img.getScaledInstance(getWidth(), getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        JLabel wallpaper= new JLabel("",imageIcon,JLabel.CENTER);
        wallpaper.setBounds(0,0,600,650);

        //----TEXT AREA PRINCIPALE dove verrà scritto tutto cio che succede in battagli-----------------------

        JTextArea textArea = new JTextArea();
        textArea.setText(player1.pokemonStringList());
        textArea.setBounds(10,500,250,100);
        textArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        add(textArea);


        //IMMAGINE POKEMON 1

        PokeImgLabel pokemon1Image = new PokeImgLabel(pokemonInGame1);
        pokemon1Image.setBounds(10,400,250,100);
        add(pokemon1Image);

        //IMMAGINE POKEMON "

        PokeImgLabel pokemon2Image = new PokeImgLabel(pokemonInGame2);
        pokemon2Image.setBounds(350,250,250,100);
        add(pokemon2Image);



        //----PANNELLO PRINCIPALE DOVE SI SELEZIONA COSA FARE MOSSE ETC---------------------

        pokePanel=new PokePanel(pokemonInGame1);
        add(pokePanel);

        System.out.println(pokemonInGame1);


        //PANNELLO INFO POKEMON 1
        PokeBattleInfoPanel poke1InfoPanel=new PokeBattleInfoPanel(pokemonInGame1);
        poke1InfoPanel.setBounds(350,380,200,100);

        add(poke1InfoPanel);

        //PANNELLO INFO POKEMON 2
        PokeBattleInfoPanel poke2InfoPanel=new PokeBattleInfoPanel(pokemonInGame2);
        poke2InfoPanel.setBounds(50,80,200,100);
        add(poke2InfoPanel);



        add(wallpaper);
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

        for(Pokemon pokem : pokedex.getPokedex()){
            pokem.addMove(new Action());
            pokem.addMove(new Action());
            pokem.addMove(new Action());
            pokem.addMove(new Action());


            hash.addPokemon(pokem);
            red.addPokemon(pokem);
        }

        new Battle(hash,red);
    }
}
