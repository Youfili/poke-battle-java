package Swing.menuFrame;

import players.Player;
import pokemon.Pokedex;
import pokemon.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JPanel playerInfoPanel;

    private Pokemon selectedPokemon;
    private  Pokemon selectedPartyPokemon;

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
        playerInfoPanel=new JPanel(new BorderLayout());




        //PLAYER INFO
        playerInfo=new JTextArea(player.playerInfo());
        playerInfo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        //playerInfo.setBounds(90,520,100,65);//x axis, y axis, width, height
        playerInfo.setFont(new Font("Arial", Font.BOLD,13));
        //add(playerInfo);//adding button in JFrame

        //PLAYER ICON
       // playerIcon.setBounds(30,500,50,100);
        playerIcon.setIcon(player.getImage());
        //add(playerIcon);

        //PLAYER PANEL
        playerInfoPanel.setBounds(5,500,190,100);
        playerInfoPanel.setBorder(new TitledBorder("PLAYER INFO"));
        playerInfoPanel.add(playerInfo,BorderLayout.CENTER);
        playerInfoPanel.add(playerIcon,BorderLayout.WEST);
        playerInfoPanel.setVisible(true);
        add(playerInfoPanel);



        //POKEMON INFO AREA---------------------------

        JScrollPane sp = new JScrollPane(pokeInfoTextArea);
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBorder(new TitledBorder("POKEMON INFO"));
        wrapper.add(sp, BorderLayout.CENTER);
        wrapper.setBounds(325,20,250,400);
        wrapper.setBackground(Color.WHITE);
        wrapper.setVisible(true);
        add(wrapper);

        JLabel pokeIcon = new JLabel();
        wrapper.add(pokeIcon, BorderLayout.PAGE_START);

        //TEST PROGRESSBAR-------------------------
        JProgressBar progressBar = new JProgressBar(0,100);
        progressBar.setBounds(325,450,250,20);
        progressBar.setValue(50);
        progressBar.setString("exp");
        progressBar.setStringPainted(true);
        add(progressBar);

        JButton progressButton = new JButton("Progress");
        progressButton.setBounds(325,480,40,20);
        progressButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                progressBar.setValue(progressBar.getValue()+20);
            }
        });

        add(progressButton);
        //------------------------





        //TEAM PANEL-----------------------------------------------
        /*JTextArea partyPokeTxt = new JTextArea(player.pokemonStringList());
        JScrollPane tm = new JScrollPane(partyPokeTxt);*/
        JPanel teamPanel = new JPanel(new GridLayout(1,6));
        //teamPanel.setLayout(null);
        teamPanel.setBorder(new TitledBorder("PARTY POKEMON"));
        //teamPanel.add(tm);
        teamPanel.setBounds(200,500,380,100);
        teamPanel.setVisible(true);

        JButton pokemon1 = new JButton();
        JButton pokemon2 = new JButton();
        JButton pokemon3 = new JButton();
        JButton pokemon4 = new JButton();
        JButton pokemon5 = new JButton();
        JButton pokemon6 = new JButton();

        //IMPOSTIAMO IMMAGINE DI DEFAULT PILSANTI TEAM ---> POKEBALL
        BufferedImage imgPoke =null ;
        try {
            imgPoke = ImageIO.read(new File("src/Img/pokeball.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //ImageIcon img =new ImageIcon( "/Users/leonardo/Desktop/wallpaper.jpg");

        Image imPoke = imgPoke.getScaledInstance(20, 20,
                Image.SCALE_SMOOTH);

        ImageIcon imgPokeball = new ImageIcon(imPoke);

        pokemon1.setIcon(imgPokeball);
        pokemon2.setIcon(imgPokeball);
        pokemon3.setIcon(imgPokeball);
        pokemon4.setIcon(imgPokeball);
        pokemon5.setIcon(imgPokeball);
        pokemon6.setIcon(imgPokeball);

        pokemon1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon1.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(0);
                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                   int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ player.getTeam().get(0).getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                   if(input==0){
                       player.removePokemon(selectedPartyPokemon);
                       pokemon1.setIcon(imgPokeball);
                       teamPanel.repaint();
                   }

                }
            }
        });
        pokemon2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon2.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(1);
                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.removePokemon(selectedPartyPokemon);
                        pokemon2.setIcon(imgPokeball);
                        teamPanel.repaint();

                }
            }
        }});
        pokemon3.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon3.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(2);

                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.removePokemon(selectedPartyPokemon);
                        pokemon3.setIcon(imgPokeball);
                        teamPanel.repaint();

                    }
                }
            }});

        pokemon4.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon4.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(3);

                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.removePokemon(selectedPartyPokemon);
                        pokemon4.setIcon(imgPokeball);
                        teamPanel.repaint();

                    }
                }
            }});
        pokemon5.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon5.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(4);

                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.removePokemon(selectedPartyPokemon);
                        pokemon5.setIcon(imgPokeball);
                        teamPanel.repaint();

                    }
                }
            }});
        pokemon6.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(pokemon6.getIcon()!=imgPokeball){
                    selectedPartyPokemon=player.getTeam().get(5);

                    Image dimg = selectedPartyPokemon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                    ImageIcon selectPartyPokeImage = new ImageIcon(dimg);
                    int input= JOptionPane.showConfirmDialog(new JButton("elimina"),"Vuoi rimuovere "+ selectedPartyPokemon.getName()+ " dalla squadra?","remove?",2,1,selectPartyPokeImage);
                    if(input==0){
                        player.removePokemon(selectedPartyPokemon);
                        pokemon6.setIcon(imgPokeball);
                        teamPanel.repaint();

                    }
                }
            }});





        teamPanel.add(pokemon1);
        teamPanel.add(pokemon2);
        teamPanel.add(pokemon3);
        teamPanel.add(pokemon4);
        teamPanel.add(pokemon5);
        teamPanel.add(pokemon6);

        add(teamPanel);


        //-----------------------------------------------

        //--PULSANTE AGGINGI POKEMON SELEZIONATO ALLA SQUADRA &  CAMBIA IMMAGINE RELATIVA AL PULSANTE DEL POKEMON NEL TEAM

        addTeam=new JButton("add");
        //addTeam.setBounds(330,100, 50, 50);
        addTeam.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*Pokemon inGame=player.getTeam().get(0);
                Pokemon evolution = player.getTeam().get(0).getEvolution();

                *//**//*player.replacePokemon(inGame,evolution);
                 *//*playerInfo.setText(player.toString());
                playerInfo.repaint();*/
                List<Pokemon> newTeam=player.getTeam();
                int index =-1;

                for(int i=0;i<newTeam.size();i++) {

                    if (newTeam.get(i) == null) {
                        newTeam.set(i, selectedPokemon);
                        player.setTeam(newTeam);
                         index = i;
                        break;
                    }
                }
                Image dimg = selectedPokemon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon selectPokeImage = new ImageIcon(dimg);

                if(index==0){

                    pokemon1.setIcon(selectPokeImage);
                }
                else if(index==1){
                    pokemon2.setIcon(selectPokeImage);
                }
                else if(index==2){
                    pokemon3.setIcon(selectPokeImage);
                }
                else if(index==3){
                    pokemon4.setIcon(selectPokeImage);
                }
                else if(index==4){
                    pokemon5.setIcon(selectPokeImage);

                }
                else if(index==5){
                    pokemon6.setIcon(selectPokeImage);
                }

                //player.addPokemon(selectedPokemon);

                //scrivi i party pokemon nell textarea
                /*partyPokeTxt.setText("");
                partyPokeTxt.append(player.pokemonStringList());
                partyPokeTxt.repaint();*/


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
        int x=20;
        int y=30;
        for (Pokemon poke : pokedex.getPokedex()) {

            Image dimg = poke.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);

            JButton pokeButton = new JButton(poke.getName());//creating instance of JButton --> Return pokemon name
            pokeButton.setBounds(x,y, 50, 50);//x axis, y axis, width, height
            pokeButton.setIcon(imageIcon);
            pokeButton.setOpaque(false);
            pokeButton.setBorderPainted(false);

            pokeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {



                    //JOptionPane.showMessageDialog((Component) null, poke.toString(), null, JOptionPane.INFORMATION_MESSAGE, imageIcon);



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
            y+=60;


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
