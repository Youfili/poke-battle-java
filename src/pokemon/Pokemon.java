package pokemon;

import moves.Move;
import moves.base.DefaultMoves;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public  class Pokemon {

     private String name;
     private String gender;
     private String type;

     private int level;
     private int ps;
     private int expBase;
     private int currentExp;
     private int maxExp;

     private int attack;
     private int defense;
     private int speed;
     private int health; //livello attuale di salute
     private int evolutionLevel;

     private Boolean isAlive;
     private Pokemon evolution;

     private List<Move> moves=new ArrayList<>();
     private List<DefaultMoves> defaultMoves=new ArrayList<>(); // questo va inizializzato con le mosse base

     private Image image;
     //aggiungere GIF per la battaglia


    //Constructor
    public Pokemon(String name, int level, int ps, String gender, int attack, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.ps = ps;
        this.gender = gender;//da implementare casuale
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.isAlive = true;


    }
    //Constructor with image
    public Pokemon(String name, int level, int ps, String gender,
                   Type type,int attack, int defense,
                   int speed,int expBase, String imgPath, int evolutionLevel
                    , Pokemon evolution) {
        this.name = name;
        this.level = level;
        this.ps = ps;
        this.gender = gender;//da implementare casuale
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.isAlive = true;
        this.expBase = expBase;
        this.evolutionLevel = evolutionLevel;
        this.evolution = evolution;

        this.health=ps;

        //this.maxExp= level*ps; DA IMPLEMENTARE

        //assegna l'immagine
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.setImage(img);

    }



    public void setDefaultMoves(){
        /*itera su un arrayList di mosse default e ne assegna
          casualmente 2 alla lista mosse del pokemon
        */
    }

    public void addMove(Move move){
        if (moves.size()<4){
            moves.add(move);
        }
        else{
            //Rimuovi mossa selezionata
        }
    }

    public void removeMove(Move move){
        moves.remove(move);

    }

    public void updateLevel(){
        setLevel(level+1);
        //Aggiungere modifiche ai valori hp ecc
    }



    @Override
    public String toString() {
        return
                "Name= " + name + '\n' +
                "Level= " + level + '\n'+
                "Ps= " + ps + '\n'+
                "Gender= " + gender + '\n' +
                "Attack= " + attack + '\n' +
                "Defense= " + defense +'\n' +
                "Speed= " + speed +'\n' +
                "Moves= " + moves +'\n';
    }






    //Getter and Setter

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public List<Move> getMoves() {
        return moves;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExpBase() {
        return expBase;
    }

    public void setExpBase(int expBase) {
        this.expBase = expBase;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(int currentExp) {
        this.currentExp = currentExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<DefaultMoves> getDefaultMoves() {
        return defaultMoves;
    }

    public void setDefaultMoves(List<DefaultMoves> defaultMoves) {
        this.defaultMoves = defaultMoves;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEvolutionLevel() {
        return evolutionLevel;
    }

    public void setEvolutionLevel(int evolutionLevel) {
        this.evolutionLevel = evolutionLevel;
    }

    public Pokemon getEvolution() {
        return evolution;
    }

    public void setEvolution(Pokemon evplution) {
        this.evolution = evplution;
    }
}


