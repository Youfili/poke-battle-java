//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Swing.BackgroundImageJFrame;
import players.Player;
//import pokemon.Bulbasaur;
import pokemon.Pokedex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//TEST

//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.
//Test
public class JPokeBattle {
    public static void main(String[] arg) {
        Pokedex pokedex = new Pokedex();
        Player hash = new Player("Hash",0,0, "Male");

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

        /*
        Pokemon evolution=hash.getTeam().get(0).getEvolution();
        Pokemon inGame=hash.getTeam().get(0);

        System.out.println(hash);
        hash.replacePokemon(inGame,evolution);
        //hash.addPokemon(evolution);
        System.out.println(hash);*/

        new BackgroundImageJFrame();






        //pokemon.forEach(poke -> System.out.println(poke));


    }
}