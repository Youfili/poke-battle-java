package swing.menuPanel;

import players.Player;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PartyPokemonPanel extends JPanel {
      private JButton pokemon1 ;
      private JButton pokemon2 ;
      private JButton pokemon3 ;
      private JButton pokemon4 ;
      private JButton pokemon5 ;
      private JButton pokemon6 ;

      private Pokemon selectedPartyPokemon;

    public PartyPokemonPanel(Player player) {
        setLayout(new GridLayout(1,6));// Pannello del team con una riga e 6 colonne (ogni colonna è un bottone del pokemon selezionato)
        setBorder(new TitledBorder("PARTY POKEMON"));
        //teamPanel.add(tm);
       setBounds(200,500,380,100);
       setVisible(true);

         pokemon1 = new JButton("1");
         pokemon2 = new JButton("2");
         pokemon3 = new JButton("3");
         pokemon4 = new JButton("4");
         pokemon5 = new JButton("5");
         pokemon6 = new JButton("6");


        //IMPOSTIAMO IMMAGINE DI DEFAULT PILSANTI TEAM ---> POKEBALL
        BufferedImage imgPoke =null ;
        try {
            imgPoke = ImageIO.read(new File("src/Img/pokeball.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Image imPoke = imgPoke.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);

        ImageIcon imgPokeball = new ImageIcon(imPoke);

        // Setto le immagini di default del pannello delle pokeball
        if(player.getTeam().get(0)==null)
            pokemon1.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(0);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon1.setIcon(selectPartyPokeImage);
        }
        if(player.getTeam().get(1)==null)
            pokemon2.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(1);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon2.setIcon(selectPartyPokeImage);
        }
        if(player.getTeam().get(2)==null)
            pokemon3.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(2);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon3.setIcon(selectPartyPokeImage);
        }

        if(player.getTeam().get(3)==null)
            pokemon4.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(3);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon4.setIcon(selectPartyPokeImage);
        }

        if(player.getTeam().get(4)==null)
            pokemon5.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(4);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon5.setIcon(selectPartyPokeImage);
        }

        if(player.getTeam().get(5)==null)
            pokemon6.setIcon(imgPokeball);
        else{
            selectedPartyPokemon=player.getTeam().get(5);
            Image immPokemon = selectedPartyPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon selectPartyPokeImage = new ImageIcon(immPokemon);
            pokemon6.setIcon(selectPartyPokeImage);
        }
        add(pokemon1);
        add(pokemon2);
        add(pokemon3);
        add(pokemon4);
        add(pokemon5);
        add(pokemon6);
    }

    public JButton getPokemon1() {
        return pokemon1;
    }
    public JButton getPokemon2() {
        return pokemon2;
    }
    public JButton getPokemon3() {
        return pokemon3;
    }
    public JButton getPokemon4() {
        return pokemon4;
    }
    public JButton getPokemon5() {
        return pokemon5;
    }
    public JButton getPokemon6() {
        return pokemon6;
    }
}
