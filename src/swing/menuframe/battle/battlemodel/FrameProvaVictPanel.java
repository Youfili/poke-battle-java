package swing.menuframe.battle.battlemodel;

import moves.base.Action;
import moves.base.BodySlam;
import moves.base.Frustration;
import moves.base.GigaImpact;
import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.VictoryPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FrameProvaVictPanel extends JFrame {

    public FrameProvaVictPanel(Player giocatore)  {

        // Dimensioni Frame Vitt prova
        setSize(600,650);//600 width and 650 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);

        this.getContentPane().removeAll();

        // Crea e aggiungi il nuovo pannello della vittoria
        VictoryPanel pannelloVittoria = new VictoryPanel(giocatore);
        this.add(pannelloVittoria);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        setVisible(true);


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
            pokem.addMove(new moves.base.Action());
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

        FrameProvaVictPanel frameVittoria = new FrameProvaVictPanel(red);

        System.out.println(red.pokemonStringList());
    }
}
