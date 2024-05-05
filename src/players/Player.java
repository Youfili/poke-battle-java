package players;

import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private String gender;

    private int winMatch;
    private int lossMatch;

    private List<Pokemon> team=new ArrayList<>(6);


    //Constructor
    public Player(String name, int winMatch, int lossMatch, String gender) {
        this.name = name;
        this.winMatch = winMatch;
        this.lossMatch = lossMatch;
        this.gender = gender;
        for(int i=0;i<6;i++){
            team.add(null);
        }

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
                "name= " + name + '\n' +
                "gender= " + gender + '\n' +
                "winMatch= " + winMatch + '\n' +
                "lossMatch= " + lossMatch + '\n'+

            (team.isEmpty()?"L'allenatore non ha pokemon":"team: " + pokemonStringList() )+'\n';
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

    //stampa le informazioni di un pokemon della squadra
    public String getPokemonInfo(int i){
        return (team.get(i)==null?"Non hai selezionato nessun Pokemon":team.get(i).toString());
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
        return lossMatch;
    }

    public void setLossMatch(int lossMatch) {
        this.lossMatch = lossMatch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Pokemon> getTeam() {
        return team;
    }

    public void setTeam(List<Pokemon> team) {
        this.team = team;
    }
}



