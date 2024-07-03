package pokemon;

import moves.Move;
import moves.normal.*;
import moves.normal.Action;
import swing.menuframe.battle.battleview.PokeButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
        * La classe `Pokemon` rappresenta un personaggio Pokemon in un gioco. Include proprietà come nome, livello, tipo, salute e vari attributi relativi alla meccanica di battaglia.
        * Gestisce anche la gestione delle immagini e la serializzazione per salvare lo stato di un oggetto Pokemon.
 */
public class Pokemon implements Serializable {

     private String name;
     private String gender;
     private Type type;

     private int level;
     private int ps;
     private int expBase;
     private int currentExp;
     private int expNecessaria;

     private int attack;
     private int defense;
     private int health; //livello attuale di salute

     private Boolean isAlive;

     private Map<Integer, Move> movesByLevel=new TreeMap<>();
     private List<Move> moves=new ArrayList<>();
     private List<DefaultMoves> defaultMoves= new ArrayList<>(); // questo va inizializzato con le mosse base

    private transient Image image; // Transient to avoid serialization issues
    private String imageBase64; // For storing the serialized image
    private String imagePath;
    private PokeButton buttonAssociato;
    private boolean imparaMosse;


    /**
     * Costruisce un nuovo oggetto Pokemon con i parametri specificati.
     *
     * @param name      il nome del Pokemon
     * @param level     il livello del Pokemon
     * @param maxPs     i punti salute massimi del Pokemon
     * @param gender    il genere del Pokemon
     * @param type      il tipo del Pokemon
     * @param attack    il valore di attacco del Pokemon
     * @param defense   il valore di difesa del Pokemon
     * @param expBase   l'esperienza base del Pokemon
     * @param imgPath   il percorso dell'immagine del Pokemon
     */

    //Constructor with image
    public Pokemon(String name, int level, int maxPs, String gender,
                   Type type,int attack, int defense, int expBase, String imgPath) {
        this.name = name;
        this.level = level;
        this.type=type;
        this.ps = maxPs;
        this.gender = gender;//da implementare casuale
        this.attack = attack;
        this.defense = defense;
        this.isAlive = true;
        this.expBase = expBase;
        this.currentExp = expBase;                  // il valore dell'esperienza attuale del pokemon
        this.imagePath = imgPath;
        this.health=maxPs;
        this.imparaMosse = true;

        calcolaExpNecessaria(this.level);           // calcolo exp in base a livello in cui inizializzo il pokemon


        try {
            BufferedImage bufferedImage = ImageIO.read(new File(imgPath));
            setImage(bufferedImage);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }


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
    }

    //METODO PER RIMPIAZZARE UNA MOSSA
    public void replaceMove(Move move, Move newMove) {
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i).getName().equals(move.getName())) {
                moves.set(i, newMove);
                break; // Break dopo aver trovato la mossa da sostituire
            }
        }
        // Stampa di debug per verificare l'aggiornamento delle mosse
        System.out.println("Mossee aggiornate: " + moves);
    }


    public void increaseExp(Pokemon avversario)
    {
        int exp= (int) ((avversario.getLevel() * 1.5 * avversario.expBase)/100);
        this.currentExp=currentExp+exp;

        if(currentExp >= expNecessaria){
            currentExp -= expNecessaria;        // tolgo lo scarto e lo setto come exp corrente
            updateLevel();

        }

    }

    public void updateLevel(){
        setLevel(level+1);
        //Aggiungere modifiche ai valori hp ecc

        calcolaExpNecessaria(this.level);
//        this.ps += ((ps*10)/100);
        this.attack = attack + (attack*10/100);
        this.defense = defense + (defense*10/100);;

        this.imparaMosse = true;        // ogni volta che aumenta il livello lo rendo "possibilitato" ad apprendere nuovo mosse
                                        // ovviamente non impara mosse a tutti i livelli


    }

    public void calcolaExpNecessaria(int level){
        this.expNecessaria = 100;
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
                " Moves = " + moves +'\n';



    }






    //Getter and Setter


    public Boolean isAlive() {

        return !isDead();
    }

    public void addMoveByLevel(int level, Move move) {
        movesByLevel.put(level, move);
    }

    public Move getMoveByLevel(int level) {return movesByLevel.get(level);
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

    public void setDefense(int defense) {this.defense = defense;}

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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getExpNecessaria() {
        return expNecessaria;
    }

    public void setExpNecessaria(int expNecessaria) {
        this.expNecessaria = expNecessaria;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public Map<Integer, Move> getMovesByLevel() {
        return movesByLevel;
    }

    public void setMovesByLevel(Map<Integer, Move> movesByLevel) {
        this.movesByLevel = movesByLevel;
    }

    public List<DefaultMoves> getDefaultMoves() {
        return defaultMoves;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public PokeButton getButtonAssociato() {
        return buttonAssociato;
    }

    public void setButtonAssociato(PokeButton buttonAssociato) {
        this.buttonAssociato = buttonAssociato;
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


    public void setPokeButton(PokeButton bottoneAssociatoAlPokemon){
        this.buttonAssociato = bottoneAssociatoAlPokemon;
    }

    public PokeButton getPokeButton(){
        return buttonAssociato;
    }

    public String getImagePath(){
        return this.imagePath;
    }

    public boolean isImparaMosse() {
        return imparaMosse;
    }

    public void setImparaMosse(boolean imparaMosse) {
        this.imparaMosse = imparaMosse;
    }
}


