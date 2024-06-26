package players;

import pokemon.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Estendo la classe Serializable cosi poter salvare su file il Player
public class Player implements Serializable {

    private String name;
    private String gender;

    private int winMatch;
    private int lostMatch;

    private ImageIcon image;
    private Pokemon pokemonAttivo;

    private List<Pokemon> team = new ArrayList<>();
    private int vittorieTemporanee;

    private int id;


    //Constructor
    public Player(String name, int winMatch, int lossMatch, String gender) {
        this.name = name;
        this.winMatch = winMatch;
        this.lostMatch = lossMatch;
        this.gender = gender;
        this.id = -1;
        for(int i=0;i<6;i++){
            team.add(null);
        }

    }

    public Player(){

    }

    //Stampa i nomi dei pokemon nella squadra
    public String pokemonStringList() {
        String s="[";
        for(Pokemon p : team) {
            if(p!=null) {
                s+=p.getName()+",";
            }
            else{
                s+=" / ,";
            }
        }
        return s.substring(0, s.length()-1)+"]";
    }

    //Stampa le info del Player
    @Override
    public String toString() {
        return
                " Name = " + name + '\n' +
                " Gender = " + gender + '\n' +
                " Won Match = " + winMatch + '\n' +
                " Lost Match = " + lostMatch + '\n'+

            (teamIsEmpty()?"L'allenatore non ha pokemon":" Team: " + pokemonStringList() )+'\n';
    }

    //TO STRING SENZA POKEMON
    public String playerInfo(){

        return
                "name= " + name + '\n' +
                        "gender= " + gender + '\n' +
                        "winMatch= " + winMatch + '\n' +
                        "lossMatch= " + lostMatch ;
    }

    //matodo per aggiungere pokemon alla squadra durante la creazione
    public void addPokemon(Pokemon pokemon) {
        for(int i=0;i<team.size();i++){

            if(team.get(i)==null){
                team.set(i,pokemon);
                break;
            }
        }

    }

    public void replacePokemon(Pokemon pokemon,Pokemon newPokemon){
        for(int i=0;i<team.size();i++){
            if(team.get(i)==pokemon){
                team.set(i,newPokemon);

            }
        }
    }

    public void removePokemon(Pokemon pokemon) {
        for(int i=0;i<team.size();i++){
            if(team.get(i)==pokemon){
                team.set(i,null);
            }
        }
    }

    //stampa le informazioni di un pokemon della squadra
    public String getPokemonInfo(int i){
        return (team.get(i)==null?"Non hai selezionato nessun Pokemon":team.get(i).toString());
    }

    public boolean teamIsEmpty(){
        for(Pokemon p : team){
            if(p!=null){
                return false;
            }
        }
        return true;
    }










    /*
    Getter and Setter
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinMatch() {
        return winMatch;
    }

    public void setWinMatch(int winMatch) {
        this.winMatch = winMatch;
    }

    public int getLossMatch() {
        return lostMatch;
    }

    public void setLossMatch(int lossMatch) {
        this.lostMatch = lossMatch;
    }

    public String getGender() {
        return gender;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    // Questi metodi sono incongru
    public Pokemon getPokemonAttivo() {
        return pokemonAttivo;
    }

    public void setPokemonAttivo(Pokemon pokemonAttivo) {
        this.pokemonAttivo = pokemonAttivo;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
    public ImageIcon getImage() {
        return image;
    }
    public void setImage(ImageIcon image) {
        this.image = image;

    }


    public void incrementaVittorieTemporanee(){
        this.vittorieTemporanee ++;
    }

    public int getVittorieTemporanee() {
        return vittorieTemporanee;
    }

    public void setVittorieTemporanee(int vittoreTemporanee) {
        this.vittorieTemporanee = vittoreTemporanee;
    }

    public void addWinMatch(){
        this.winMatch ++;
    }
    public void addLostMatch(){
        this.lostMatch ++;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}



