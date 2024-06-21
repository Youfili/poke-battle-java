package swing.menuframe.battle;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PokeImgLabel extends JLabel {
    private Pokemon pokemon;
    public PokeImgLabel(Pokemon pokemon) {

        this.pokemon = pokemon;
        Image pokeImg= pokemon.getImage().getScaledInstance(300, 300,
                Image.SCALE_SMOOTH);
        ImageIcon pokeIm = new ImageIcon(pokeImg);

        setIcon(pokeIm);

        setVisible(true);

    }
}
