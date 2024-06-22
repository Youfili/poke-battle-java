package swing.menuframe.battle;

import controller.BattleController;
import moves.Move;
import players.Player;
import pokemon.Pokemon;

import javax.swing.*;

public class BattleModel {

    private Player player1;
    private Player player2;
    private BattleController controller = new BattleController(player1, player2);
    private BattleController controllerBattaglia = new BattleController(player1, player2);
    private Pokemon pokeInCampo1;
    private Pokemon pokeInCampo2;



    // Costruttore
    public BattleModel(Player player1, Player player2){
        /* Model della Battaglia (Logica) */
    } // Fine Costruttore


    /* Metodi che influiscono sulla logica della battaglia     */
    public void eseguiMossa(JButton selectedMove, Pokemon pokemonInCampoAttaccante, Pokemon pokemonInCampoDifensore){
        // Implementare la logica di questo metodo che permetta di eseguire la mossa
        // In questa logica vado a diminuire a livello logico la vita del pokemon
        // quindi mi basta andare a settare la BarraHp in base alla vita del pokemon stesso

        /* Trovare un modo per il quale dal bottone si risale alla mossa effettiva del pokemon */
        // la mossa scelta ricavata dal bottone (in questo caso "mossa scelta")

        Move mossaScelta;
        int vitaPostAttacco = pokemonInCampoDifensore.getHealth() - mossaScelta.getDamage();
        if(vitaPostAttacco > 0)
            pokemonInCampoDifensore.setHealth(vitaPostAttacco);
        else
            pokemonInCampoDifensore.setHealth(0);

        // Aggiorno la barraHP
        aggiornaBarraHp(pokemonInCampoDifensore.getHealth());



    }

    public void aggiornaBarraHp(int vitaAggiornata){
        // Implementare la logica in cui si va a modificare la barra
        controller.aggiornaBarraHp(vitaAggiornata);
    }




}
