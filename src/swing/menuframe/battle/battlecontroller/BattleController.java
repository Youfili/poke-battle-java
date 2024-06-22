package swing.menuframe.battle.battlecontroller;

import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battlemodel.BattleModel;
import swing.menuframe.battle.battleview.BattleView;

import javax.swing.*;

public class BattleController {

    private Player player1;
    private Player player2;


    private BattleModel modelBattaglia = new BattleModel(player1, player2);
    private BattleView graficaBattaglia = new BattleView(player1, player2);


    public BattleController(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;

    }


    public void attivazioneBottoneAttacca(){
        /*
        All'interno di questo metodo vado a richiamare un metodo presente le Model che va a influire sulla logica della battaglia
        una molta modificata la logica, viene inviato un comando di aggiornamento alla "parte grafica" ad esempio un "repaint" per aggiornare i valori "disegnati"
        a schermo, ad esempio: vitaPokemon, expPOkemon, IconaPokemonSePokemonMorto.... etc
        */
    }

    /*  Metodi che facciano comunicare la parte grafica con la parte del Model  */


    public void eseguiMoveBotton(JButton selectedMove, Pokemon pokemonInCampoAttacco, Pokemon pokemonInCampoDifensore){
        modelBattaglia.eseguiMossa(selectedMove, pokemonInCampoAttacco, pokemonInCampoDifensore);
        // Aggiorno la barraHp del pokemon difensore
        graficaBattaglia.getPoke2InfoPanel().getHpBar().setValue(pokemonInCampoDifensore.getHealth());
    }


}
