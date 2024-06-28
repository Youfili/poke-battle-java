package swing.menuframe.battle.battleview;

import moves.Move;
import pokemon.Pokemon;
import swing.BackgroundImageJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameImparaMossa extends JDialog {

    private Pokemon pokemonInAttacco;
    private Move mossaDaImpara;
    private Move mossaDaCambiare;
    MoveButton bottoneMossa;

    public FrameImparaMossa(JFrame parent, Pokemon pokemonImparaMossa, Move mosaDaIMparare) {
        super(parent, true); // Imposta la modalità del dialogo
        this.pokemonInAttacco = pokemonImparaMossa;
        this.mossaDaImpara = mosaDaIMparare;

        // Dimensioni Frame Battaglia
        setSize(300,350);//600 width and 650 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);

        JPanel pannelloBottoniMossa = new JPanel(new GridLayout(2,2,2,2));
        pannelloBottoniMossa.setBounds(25, 25, 150,150);
        for(Move mossa : pokemonInAttacco.getMoves()){
            bottoneMossa = new MoveButton(mossa);

            // Faccio l'ActionListener del bottone
            bottoneMossa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // il bottone che clicco mi indica quale mossa voglio sostituire

                    // Immagine da inserire come dialogo di conferma
                    ImageIcon returnBackCustomIcon = new ImageIcon("src/Img/backToMenu.png");
                    // Inserisco il dialogo di conferma
                    int risposta = JOptionPane.showConfirmDialog(null, "Vuoi cambiare questa mossa?", "Si", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, returnBackCustomIcon);
                    if (risposta == JOptionPane.YES_OPTION) {           // se conferma il bottone premuto, torno indietro al menu
                        setMossaDaCambiare(bottoneMossa.getMove());
                        System.out.println("La mossa che ho deciso di cambiare è: " + mossaDaCambiare);
                        dispose();  // Chiudi il frame dopo la conferma di risposta
                    } else {
                        System.out.println("Ancora non ho deciso...");              // Azione se l'utente sceglie "No"
                    }
                }
            });

            // Aggiungo il bottone mossa al pannello
            pannelloBottoniMossa.add(bottoneMossa);
        }

        // Aggiungo il pannello al frame
        add(pannelloBottoniMossa);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina
        setVisible(true);
    }

    public Move returnMossaDaCambiare() {
        return this.mossaDaCambiare;
    }

    public void setMossaDaCambiare(Move mossaDaCambiare) {
        this.mossaDaCambiare = mossaDaCambiare;
    }
}
