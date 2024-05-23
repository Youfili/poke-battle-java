package Swing.menuFrame.battle;

import moves.Move;
import pokemon.Pokemon;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;

public class PokeBattleInfoPanel extends JPanel {
    private Pokemon pokemon;
    private JProgressBar experienceBar;
    private JProgressBar hpBar;
    private JLabel pokeInfo;

    public PokeBattleInfoPanel(Pokemon pokemon) {
        super(new GridLayout(3,1));
        this.pokemon = pokemon;
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        setBackground(Color.WHITE);


        pokeInfo = new JLabel();
        pokeInfo.setText(pokemon.getName()+"                  LV. "+pokemon.getLevel());
        add(pokeInfo,BorderLayout.NORTH);


        //UIManager.put("ProgressBar.foreground", Color.GREEN);

        hpBar = new JProgressBar(0,100);
        hpBar.setString("hp");
        hpBar.setStringPainted(true);
        hpBar.setValue(this.pokemon.getHealth());
        add(hpBar,BorderLayout.CENTER);



        experienceBar = new JProgressBar(0,100);
        experienceBar.setString("exp");
        experienceBar.setStringPainted(true);
        experienceBar.setValue(this.pokemon.getExpBase());
        //experienceBar.setBounds(360,470,170,20);
        add(experienceBar,BorderLayout.LINE_END);


        setVisible(true);
    }

    public JLabel getPokeInfo() {
        return pokeInfo;
    }

    public void setPokeInfo(JLabel pokeInfo) {
        this.pokeInfo = pokeInfo;
    }

    public void setHpBar(JProgressBar hpBar) {
        this.hpBar = hpBar;
    }

    public void setExperienceBar(JProgressBar experienceBar) {
        this.experienceBar = experienceBar;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public JProgressBar getHpBar() {
        return hpBar;
    }

    public JProgressBar getExperienceBar() {
        return experienceBar;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        pokeInfo.setText(pokemon.getName()+"                  LV. "+pokemon.getLevel());
        hpBar.setValue(this.pokemon.getHealth());
        experienceBar.setValue(this.pokemon.getExpBase());

    }
}
