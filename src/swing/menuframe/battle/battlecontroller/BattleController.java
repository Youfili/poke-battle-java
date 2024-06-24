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
        this.modelBattaglia = modelloBattaglia;
        this.viewBattaglia = frameDellaView;

        // Vedere nel dettaglio questo comando init che li collega
        // initController();
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    /*  Metodi che facciano comunicare la parte grafica con la parte del Model  */

    public void eseguiMoveBotton(MoveButton selectedMove, Pokemon pokemonInCampoAttacco, Pokemon pokemonInCampoDifensore){
        modelBattaglia.eseguiMossa(selectedMove, pokemonInCampoAttacco, pokemonInCampoDifensore);
        // Aggiorno la barraHp del pokemon difensore
        viewBattaglia.getPoke2InfoPanel().getHpBar().setValue(pokemonInCampoDifensore.getHealth());
        // Aggiungere anche l'aggiornamento dell'area di testo quando il pokemon di attacco sferra l'attacco.
        // es: Bulbasaur usa "Azione"
    }

    public void aggiornaPokemonEsausto(Pokemon pokeEsausto){
        viewBattaglia.aggiornaPokemonEsausto(pokeEsausto);
    }

    public void cambioPokemon(Pokemon pokemon1InCampo) {
        modelBattaglia.cambioPokemon(pokemon1InCampo);
        System.out.println("cambioPokemon() nel controller");
    }


    public void aggiornaScorerPunteggio1(Player playerAggiornaScorer) {
        viewBattaglia.aggiornaScorerPunteggio1(playerAggiornaScorer);
    }
    public void aggiornaScorerPunteggio2(Player playerAggiornaScorer) {
        viewBattaglia.aggiornaScorerPunteggio2(playerAggiornaScorer);
    }
}
