package swing.menuframe.battle.battleview;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PokeButton extends JButton {

    private Pokemon pokemonDelBottone;

    public PokeButton(Pokemon pokeSceltoDelBottone){
        this.pokemonDelBottone = pokeSceltoDelBottone;

        /*  Inserisco l'icona del Bottone (con l'immagine del Pokemon)  */
        // Carico l'immagine come un oggetto ImageIcon
        ImageIcon icon = new ImageIcon(pokeSceltoDelBottone.getImagePath());
        // Imposto l'icona del bottone
        this.setIcon(icon);


    }     // Fine COSTRUTTORE

    public Pokemon getPokemonDelBottone() {
        return pokemonDelBottone;
    }
}
