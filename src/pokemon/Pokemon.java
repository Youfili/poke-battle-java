package pokemon;

import moves.Move;
import moves.base.*;
import moves.base.Action;
import swing.menuframe.battle.battleview.PokeButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 *
 */
public  class Pokemon implements Serializable {

     private String name;
     private String gender;
     private Type type;

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

     private Map<Integer, Move> movesByLevel=new TreeMap<>();
     private List<Move> moves=new ArrayList<>();
     private List<DefaultMoves> defaultMoves= new ArrayList<>(); // questo va inizializzato con le mosse base

    private transient Image image; // Transient to avoid serialization issues
    private String imageBase64; // For storing the serialized image
    private String imagePath;
    private PokeButton buttonAssociato;


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
    public Pokemon(String name, int level, int maxPs, String gender,
                   Type type,int attack, int defense,
                   int speed,int expBase, String imgPath, int evolutionLevel
                    , Pokemon evolution) {
        this.name = name;
        this.level = level;
        this.type=type;
        this.ps = maxPs;
        this.gender = gender;//da implementare casuale
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.isAlive = true;
        this.expBase = expBase;
        this.evolutionLevel = evolutionLevel;
        this.evolution = evolution;
        this.imagePath = imgPath;
        this.health=maxPs;




        //this.maxExp= level*ps; DA IMPLEMENTARE

        //assegna l'immagine


        try {
            BufferedImage bufferedImage = ImageIO.read(new File(imgPath));
            setImage(bufferedImage);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


        //*****AGGIUNGO MOSSE DEFAULT PER PROVA BATTAGLIA ********
        addMove(new Action());
        addMove(new Frustration());
        addMove(new GigaImpact());
        addMove(new BodySlam());

    }


    // Metodi per Immagine e Serializzazione
    // Getter and Setter for image with conversion
    public Image getImage() {
        if (image == null && imageBase64 != null) {
            try {
                byte[] imageBytes = Base64.getDecoder().decode(imageBase64);
                ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                image = ImageIO.read(bais);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        try {
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            this.imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        if (image != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write((BufferedImage) image, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            out.writeInt(imageBytes.length);
            out.write(imageBytes);
        } else {
            out.writeInt(0);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int length = in.readInt();
        if (length > 0) {
            byte[] imageBytes = new byte[length];
            in.readFully(imageBytes);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            image = ImageIO.read(bais);
        }
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
                " Type = " + type + "\n" +
                " Name = " + name + '\n' +
                " Level = " + level + '\n'+
                " Ps = " + ps + '\n'+
                " Gender = " + gender + '\n' +
                " Attack = " + attack + '\n' +
                " Defense = " + defense +'\n' +
                " Speed = " + speed +'\n' +
                " Moves = " + moves +'\n';



    }






    //Getter and Setter


    public Boolean isAlive() {

        return !isDead();
    }

    public void addMoveByLevel(int level, Move move) {
        movesByLevel.put(level, move);
    }

    public Move getMoveByLevel(int level) {
        return movesByLevel.get(level);
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
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

    public Type getType() {
        return type;
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

    public Boolean isDead() {
        return   health <= 0;
    }

    public List<Move> getMoves() {
        return moves;
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

    public void setPokeButton(PokeButton bottoneAssociatoAlPokemon){
        this.buttonAssociato = bottoneAssociatoAlPokemon;
    }

    public PokeButton getPokeButton(){
        return buttonAssociato;
    }

    public String getImagePath(){
        return this.imagePath;
    }

}


