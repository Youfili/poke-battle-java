package swing.menuframe.battle.battlecontroller;

import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battlemodel.BattleModel;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.MoveButton;
import swing.menuframe.battle.battleview.PokeButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleController {

    private Player player1;
    private Player player2;

    private BattleModel modelBattaglia;
    private BattleView viewBattaglia;

    // COSTRUTTORE UNICO PER IL MODEL E LA VIEW
    public BattleController(BattleModel modelloBattaglia, BattleView frameDellaView) {
        this.viewBattaglia = frameDellaView;
        this.modelBattaglia = modelloBattaglia;

        // Vedere nel dettaglio questo comando init che li collega
        // initController();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    /*  Metodi che facciano comunicare la parte grafica con la parte del Model  */

    public void eseguiMoveBotton(MoveButton selectedMove, Pokemon pokemonInCampoAttacco, Pokemon pokemonInCampoDifensore){
        this.modelBattaglia.eseguiMossa(selectedMove, pokemonInCampoAttacco, pokemonInCampoDifensore);
        // Aggiorno la barraHp del pokemon difensore
        // NOTA: getPokeInfoPanel va generalizzato come pannello della difesa (per decrementare vita). --> e quello di attacco va generalizzato come PokeInfoPanelAttacco (serve a aumentare exp)
        this.viewBattaglia.getPokeAttPanel().getHpBar().setValue(pokemonInCampoDifensore.getHealth());
        // Aggiungere anche l'aggiornamento dell'area di testo quando il pokemon di attacco sferra l'attacco.
        // es: Bulbasaur usa "Azione"
    }


    public boolean isTurnoGiocatore1() {
        return modelBattaglia.isTurnoGiocatore1();
    }

    public void cambioPokemon(Pokemon pokeInAttacco) {
        this.modelBattaglia.cambioPokemon(pokeInAttacco);
        System.out.println("cambioPokemon() nel controller");
    }

    public Pokemon getPokemonInAttacco() {
        return modelBattaglia.getPokemonInAttacco();
    }

}
