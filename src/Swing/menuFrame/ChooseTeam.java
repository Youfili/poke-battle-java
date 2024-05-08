package Swing.menuFrame;

import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/*
IMPLEMENTARE VARIE CLASSI PANNELLI OGNUNA CON RELATIVE INFORMAZIONI E PULSANTI
METTERLE POI IN COLLEGAMENTO IN QUESTO FRAME
 */
public class ChooseTeam extends JFrame {

    //private List<Pokemon> pokemon=new ArrayList<Pokemon>();
    private Player player;
    private JPanel pokeInfoPanel;
    private JTextArea pokeInfoTextArea;
    private Pokedex pokedex;
    private JButton evolution;
    private JLabel playerIcon;
    private JTextArea playerInfo;
    private JButton addTeam;

    private Pokemon selectedPokemon;

    public ChooseTeam(Player player) {

        this.player=player;
        setSize(600,650);//400 width and 500 height
        setLayout(null);//using no layout managers
        setLocationRelativeTo(null);//centro dello schermo
        setResizable(false);


        //lista pokemon .. magari prendere da una classe Pokedex

        pokedex= new Pokedex();

        //pannelli da aggiungere al frame : L'idea sarebbe creare tre pannelli
        // (scelta pokemon |
        // info pokemon selezionato |
        // info allenatore con visualizzazione  della squadra che si aggiorna man mano che selzioniamo o meno pokemon
        //pokeInfoPanel=new JPanel();
        playerInfo=new JTextArea();
        playerIcon=new JLabel();
        pokeInfoTextArea=new JTextArea();


        //PLAYER INFO
        playerInfo=new JTextArea(player.playerInfo());
        playerInfo.setBounds(90,520,100,65);//x axis, y axis, width, height
        playerInfo.setFont(new Font("Arial", Font.BOLD,13));
        add(playerInfo);//adding button in JFrame

        //PLAYER ICON
        playerIcon.setBounds(30,500,50,100);
        playerIcon.setIcon(player.getImage());
        add(playerIcon);



        //POKEMON INFO AREA

        JScrollPane sp = new JScrollPane(pokeInfoTextArea);
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(new TitledBorder("POKEMON INFO"));
        wrapper.add(sp, BorderLayout.CENTER);
        wrapper.setBounds(325,20,300,400);
        wrapper.setBackground(Color.WHITE);
        wrapper.setVisible(true);
        add(wrapper);

        JLabel pokeIcon = new JLabel();
        wrapper.add(pokeIcon, BorderLayout.PAGE_START);






        //TEAM PANEL
        JTextArea partyPokeTxt = new JTextArea(player.pokemonStringList());
        JScrollPane tm = new JScrollPane(partyPokeTxt);
        JPanel teamPanel = new JPanel(new BorderLayout());
        teamPanel.setBorder(new TitledBorder("PARTY POKEMON"));
        teamPanel.add(tm);
        teamPanel.setBounds(200,500,380,100);
        teamPanel.setVisible(true);

        add(teamPanel);





        addTeam=new JButton("add");
        //addTeam.setBounds(330,100, 50, 50);
        addTeam.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                *//**//*player.replacePokemon(inGame,evolution);
                 *//*playerInfo.setText(player.toString());
                playerInfo.repaint();*/
                player.addPokemon(selectedPokemon);
                partyPokeTxt.setText("");
                partyPokeTxt.append(player.pokemonStringList());
                partyPokeTxt.repaint();
                teamPanel.repaint();




                //System.out.println(player.pokemonStringList());
            }});

        wrapper.add(addTeam,BorderLayout.PAGE_END);







        JPanel pokedexPanel = new JPanel();
        pokedexPanel.setLayout(null);
        pokedexPanel.setBorder(new TitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createBevelBorder(3)),"POKEDEX",0,0,Font.getFont("Arail"),Color.BLACK));
        pokedexPanel.setBounds(5,5,300,450);
        BufferedImage img =null ;
        try {
            img = ImageIO.read(new File("src/Img/wallpaper.jpeg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

        Image im = img.getScaledInstance(getWidth(), getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imgicn = new ImageIcon(im);

        JLabel back= new JLabel("",imgicn,JLabel.CENTER);
        back.setBounds(10,15,280,425);






        //CREAZIONE PULSANTI POKEMON PER OGNI POKEMON NEL POKEDEX
        int x=10;
        int y=30;
        for (Pokemon poke : pokedex.getPokedex()) {

            Image dimg = poke.getImage().getScaledInstance(60, 60,
                    Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            JButton pokeButton = new JButton(poke.getName());//creating instance of JButton --> Return pokemon name
            pokeButton.setBounds(x,y, 50, 50);//x axis, y axis, width, height
            pokeButton.setIcon(imageIcon);
            pokeButton.setOpaque(false);
            pokeButton.setBorderPainted(false);

            pokeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {



                    //JOptionPane.showMessageDialog((Component) null, poke.toString(), null, JOptionPane.INFORMATION_MESSAGE, imageIcon);

                    if(pokeButton.isSelected()){
                        player.addPokemon(poke);

                    }else{
                        player.removePokemon(poke);
                    }

                    //MOSTRO LE INFO DEL POKEMON SELEZIONATO
                    selectedPokemon=poke;
                    pokeInfoTextArea.setText("");
                    pokeInfoTextArea.append(poke.toString());
                    pokeInfoTextArea.repaint();
                    pokeIcon.setIcon(imageIcon);
                    pokeIcon.repaint();
                    wrapper.repaint();
                    /*playerButton.setText(player.toString());
                    playerButton.repaint();
                    repaint();*/
                }
            });
            y+=50;


            pokedexPanel.add(pokeButton);


        }
        pokedexPanel.add(back);
        pokedexPanel.setVisible(true);
        add(pokedexPanel);


        //PULSANTE DI TEST PER EVOLUZIONI
       /* evolution=new JButton("Evolution");
        evolution.setBounds(50,400, 50, 50);
        evolution.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                player.replacePokemon(inGame,evolution);
                playerInfo.setText(player.toString());
                playerInfo.repaint();


            }
        });

        add(evolution);
*/






        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // in questo modo, quando premo x chiuderò anche la pagina

        setVisible(true);


    }

}
