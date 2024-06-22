package swing.menuframe.battle.battlemodel;

import swing.menuframe.battle.battlecontroller.BattleController;
import moves.Move;
import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.MoveButton;

import javax.swing.*;

public class BattleModel {

    private Player player1;
    private Player player2;
    private Pokemon pokeInCampo1;
    private Pokemon pokeInCampo2;
    private BattleView viewBattaglia;

    // inizializzo
    private BattleController controllerBattaglia;



    // Costruttore
    public BattleModel(Player player1, Player player2, BattleView viewBattaglia){
        // Collego il controller al BattleModel
        controllerBattaglia = new BattleController(this, viewBattaglia);
        /* Model della Battaglia (Logica) */

    } // Fine Costruttore


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///              METODI              ///

    /* Metodi che influiscono sulla logica della battaglia     */
    public void eseguiMossa(MoveButton selectedMove, Pokemon pokemonInCampoAttaccante, Pokemon pokemonInCampoDifensore){
        // Implementare la logica di questo metodo che permetta di eseguire la mossa
        // In questa logica vado a diminuire a livello logico la vita del pokemon
        // quindi mi basta andare a settare la BarraHp in base alla vita del pokemon stesso

        Move mossaScelta = selectedMove.getMove();
        int vitaPostAttacco = pokemonInCampoDifensore.getHealth() - mossaScelta.getDamage();
        if(vitaPostAttacco > 0) {
            pokemonInCampoDifensore.setHealth(vitaPostAttacco);
        }else {
            // Altrimenti il pokemon è Esausto!
            pokemonInCampoDifensore.setHealth(0);       // imposto la vita a 0 del pokemon
            pokemonEsausto(pokemonInCampoDifensore);    // uso il metodo pokemonEsausto
        }
    }


    public void pokemonEsausto(Pokemon pokeEsausto){
        // Implementare la logica di cambiamento del pokemon esausto
        // Dopo aver implementato a livello logico la "morte" del pokemon notifico al controller il cambiamento della view
        controllerBattaglia.aggiornaPokemonEsausto(pokeEsausto);
        System.out.println("Sono nel BattleModel");

    }





}
