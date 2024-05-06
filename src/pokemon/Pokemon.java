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
public abstract class Pokemon {

     private String name;
     private String gender;
     private String type;

     private int level;
     private int ps;
     private int exp;
     private int attack;
     private int defense;
     private int speed;

     private Boolean isAlive;

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
    public Pokemon(String name, int level, int ps, String gender, int attack, int defense, int speed,String imgPath) {
        this.name = name;
        this.level = level;
        this.ps = ps;
        this.gender = gender;//da implementare casuale
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.isAlive = true;

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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
