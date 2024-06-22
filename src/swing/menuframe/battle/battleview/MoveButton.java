package swing.menuframe.battle.battleview;

import moves.Move;

import javax.swing.*;

public class MoveButton extends JButton {

    private Move mossaAssociataAlBottone;

    public MoveButton(Move mossaAssociataAlBottone) {
        this.mossaAssociataAlBottone = mossaAssociataAlBottone;
        // Imposto il nome del bottone con il nome della mossa
        this.setText("" + mossaAssociataAlBottone.getName());
    }

    // Metodo che mi ritorno la mossa associata al bottone
    public Move getMove() {
        return mossaAssociataAlBottone;
    }

    public MoveButton setMove(Move mossaAggiornata){
        // Aggiorno la mossa di quel Bottone assegnandone uno nuovo con la mossa diversa
        return new MoveButton(mossaAggiornata);
    }



}
