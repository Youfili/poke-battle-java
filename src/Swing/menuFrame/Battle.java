package Swing.menuFrame;

import players.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Frame per la Battaglia (nel quale andramo a implementare il sistema di combattimento principale

public class Battle extends JFrame {

    private Player player1;
    private Player player2;
    private JPanel panelBattle = new JPanel(new BorderLayout());

    // QUESTO E' QUELLO CORRETTO CON DUE GIOCATORI
//    public Battle (Player player1InGame, Player player2InGame){
//        this.player1 = player1InGame;
//        this.player2 = player2InGame;
//    }

    // Costruttore
    public Battle(Player player1InGame) throws HeadlessException {
        this.player1 = player1InGame;
        setSize(600,650);//400 width and 500 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);


        panelBattle.setBounds(10,10 , 400,300);
        panelBattle.setBorder(new TitledBorder("Prova Pannello Battaglia"));

        // Immagine Icon del Bottone Battaglia
        BufferedImage immBattle =null ;
        try {
            immBattle = ImageIO.read(new File("src/Img/masi_face.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image immBattleButton = immBattle.getScaledInstance(205, 280,
                Image.SCALE_SMOOTH);
        ImageIcon immBattleButtonIconMasi = new ImageIcon(immBattleButton);

        JButton battleMasi = new JButton();                     // Creo bottone
        battleMasi.setIcon(immBattleButtonIconMasi);            // imposto icona del bottone
        panelBattle.add(battleMasi, BorderLayout.CENTER);       // aggiungo bottone al pannello

        add(panelBattle);                           // aggiungo il pannello al frame





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);
    } // Fine costruttore


}
