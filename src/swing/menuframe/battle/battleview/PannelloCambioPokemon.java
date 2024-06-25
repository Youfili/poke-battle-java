package swing.menuframe.battle.battleview;

import players.Player;
import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;

public class PannelloCambioPokemon extends JPanel {

    private Player playerDelPannello;

    // Dichiaro i bottoni dei pokemon nel pannello cambio pokemon
    private PokeButton bottonePokemon1;
    private PokeButton bottonePokemon2;
    private PokeButton bottonePokemon3;
    private PokeButton bottonePokemon4;
    private PokeButton bottonePokemon5;
    private PokeButton bottonePokemon6;

    public PannelloCambioPokemon(Player playerInGioco) {

        this.setBounds(245, 500, 345, 100);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));

        // Imposto il layout del pannello
        this.setLayout(new GridLayout(1, 6, 2, 2));

        this.playerDelPannello = playerInGioco;

        // Bottoni per il cambio di pokemon --> Me li preparo di default con tutti i pokemon disponibili!
        this.bottonePokemon1 = new PokeButton(playerDelPannello.getTeam().get(0));
        this.bottonePokemon2 = new PokeButton(playerDelPannello.getTeam().get(1));
        this.bottonePokemon3 = new PokeButton(playerDelPannello.getTeam().get(2));
        this.bottonePokemon4 = new PokeButton(playerDelPannello.getTeam().get(3));
        this.bottonePokemon5 = new PokeButton(playerDelPannello.getTeam().get(4));
        this.bottonePokemon6 = new PokeButton(playerDelPannello.getTeam().get(5));


        // Aggiungo i bottoni al pannello del Cambio Pokemon
        this.add(bottonePokemon1);
        this.add(bottonePokemon2);
        this.add(bottonePokemon3);
        this.add(bottonePokemon4);
        this.add(bottonePokemon5);
        this.add(bottonePokemon6);

    }   // Fine Costruttore

}
