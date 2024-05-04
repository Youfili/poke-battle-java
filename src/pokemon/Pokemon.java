package pokemon;

import moves.Move;
import moves.base.DefaultMoves;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Pokemon {

     private String name;
     private int level;
     private int ps;
     private String gender;
     private int attack;
     private int defense;
     private int speed;
     private List<Move> moves=new ArrayList<>();

     private List<DefaultMoves> defaultMoves=new ArrayList<>(); // questo va inizializzato con le mosse base

     private ImageIcon imageIcon;

    public Pokemon(String name, int level, int ps, String gender, int attack, int defense, int speed) {
        this.name = name;
        this.level = level;
        this.ps = ps;
        this.gender = gender;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    private Boolean isAlive;



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
}
