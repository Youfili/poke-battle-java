package swing.menuframe.battle.battlecontroller;

import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battlemodel.BattleModel;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.MoveButton;

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

    private BattleView returnViewBattaglia(BattleView viewAggiornata){
        return viewAggiornata;
    }

    // In questo modo ritorno la view dopo che è stata aggiornata
    public BattleView getViewBattaglia(){
        return returnViewBattaglia(viewBattaglia);
    }


//    private void initController() {
//        // Aggiungo ActionListener al bottone
//        view.getButton().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onButtonClick();
//            }
//        });
//    }
//
//    private void onButtonClick() {
//        // Logica che avviene al click del bottone
//        String text = view.getTextField().getText();
//        JOptionPane.showMessageDialog(view, "You entered: " + text);
//    }
//}


}
