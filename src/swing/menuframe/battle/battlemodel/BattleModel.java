package swing.menuframe.battle.battlemodel;

import swing.menuframe.battle.battlecontroller.BattleController;
import moves.Move;
import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.MoveButton;
import swing.menuframe.battle.battleview.PokeButton;

import javax.swing.*;
/* Model della Battaglia (Logica) */
public class BattleModel {

    private Player player1;
    private Player player2;

    // inizializzo
    private BattleView viewBattaglia;
    private boolean turnoGiocatore1 = true;
    private Pokemon pokemonInAttacco;
    private Pokemon pokemonInDifesa;


    // Costruttore
    public BattleModel(Player player1, Player player2, BattleView viewBattaglia){
        // Collego il controller al BattleModel
        this.player1 = player1;
        this.player2 = player2;
        this.viewBattaglia = viewBattaglia;

        // NOTA: il "playerInTurno" è il playerInAttacco chiaramente. --> il player in Attacco è il player1 per iniziare, poi si switchano
        iniziaPartita();            // avvio l'inizio della partita

    } // Fine Costruttore

    private void iniziaPartita() {
        nuovaBattaglia();
    }

    private void nuovaBattaglia() {
        if (player1.getVittorieTemporanee() >= 3 || player2.getVittorieTemporanee() >= 3) {
            terminaPartita();
        }
        // ALTRIMENTI
        ripristinaVitaPokemon(player1);
        ripristinaVitaPokemon(player2);
        // Impsto i turni e i Pokemon Iniziali
        turnoGiocatore1 = true;
        pokemonInAttacco = player1.getTeam().get(0);
        pokemonInDifesa = player2.getTeam().get(0);
//        viewBattaglia.revalidate();
//        viewBattaglia.repaint();
        cicloBattaglia();
    }

    private void cicloBattaglia() {
        if (!squadraEsausta(player1) && !squadraEsausta(player2)) {
            if (turnoGiocatore1) {
                // Player 1 esegue il turno
                eseguiTurno(player1, player2);
            } else {
                // Player 2 esegue il turno
                eseguiTurno(player2, player1);
            }
        }else {
            // Una volta che il ciclo è terminato (una squadra è esausta), incremento le vittorie temporanee
            if (squadraEsausta(player1)) {
                player2.incrementaVittorieTemporanee();
                // Aggiorno lo Scorer in alto
                viewBattaglia.aggiornaScorerPunteggio1(player2);
            } else {
                player1.incrementaVittorieTemporanee();
                // aggiorno lo scorer in alto
                viewBattaglia.aggiornaScorerPunteggio2(player2);
            }
//        // dopo aver incrementato le vittorie temporanee, inizio una nuova Battaglia
        nuovaBattaglia();
        }
    }

    private void eseguiTurno(Player playerInAttacco, Player playerInDifesa) {

        // SCELTA DEI BOTTONI DA PREMERE LATO UTENTE
        // Logica per eseguire la mossa o cambiare Pokémon
        // Ad esempio:
        // eseguiMossa(selectedMove, pokemonAttaccante, pokemonDifensore);
        // oppure
        // cambioPokemon(nuovoPokemon);
        // Scambio le Turnazioni nella View
        viewBattaglia.scambiaTurnazioniView();
    }

    /* Metodi che influiscono sulla logica della battaglia     */
    public void eseguiMossa(MoveButton selectedMove, Pokemon pokemonInCampoAttaccante, Pokemon pokemonInCampoDifensore){
        this.pokemonInAttacco = pokemonInCampoAttaccante;
        this.pokemonInDifesa = pokemonInCampoDifensore;


        Move mossaScelta = selectedMove.getMove();
        int vitaPostAttacco = pokemonInDifesa.getHealth() - mossaScelta.getDamage();
        if(vitaPostAttacco > 0) {
            pokemonInDifesa.setHealth(vitaPostAttacco);
            // Debug in terminale
            System.out.println("Vita Pokemon difensore: " + pokemonInDifesa.getName() +" è : " + pokemonInDifesa.getHealth());

        }else {
            // Altrimenti il pokemon è Esausto!
            pokemonInDifesa.setHealth(0);       // imposto la vita a 0 del pokemon
            pokemonInDifesa.setAlive(false);    // imposto che il pokemon non è più vivo
            aggiornaPokemonEsausto(pokemonInDifesa);    // uso il metodo pokemonEsausto
        }
        // Dopo aver eseguito l'attacco, cambia il turno
        turnoGiocatore1 = !turnoGiocatore1;             // inverto il valore del turno
        // scambio le turnazioni a livello visivo
        viewBattaglia.scambiaTurnazioniView();
        // ripeto il cicloBattaglia();
        cicloBattaglia();
    }


    public void aggiornaPokemonEsausto(Pokemon pokeEsausto){
        // Implementare la logica di cambiamento del pokemon esausto
        // Dopo aver implementato a livello logico la "morte" del pokemon notifico al controller il cambiamento della view
        viewBattaglia.aggiornaPokemonEsausto(pokeEsausto);
        System.out.println("Sono nel BattleModel in pokemonEsausto");
        // Devo inserire la logica che mi permetta di aggiornare un pokemon

    }

    public void cambioPokemon(Pokemon pokemonInCampoScelto){
        System.out.println("cambioPokemon nel Model");
        this.pokemonInAttacco = pokemonInCampoScelto;
        // continuo il ciclo battaglia
        cicloBattaglia();
    }

    private boolean squadraEsausta(Player player) {
        for (Pokemon pokemon : player.getTeam()) {
            if (pokemon.isAlive()) {
                return false;
            }
        }
        return true;
    }

    private void ripristinaVitaPokemon(Player player) {
        for (Pokemon pokemon : player.getTeam()) {
            pokemon.setHealth(100);
            pokemon.setAlive(true);
        }
    }

    private void terminaPartita() {
        // Logica per salvare i dati e terminare la partita
        System.out.println("Partita terminata!");
        // Vado a modificare le stats dei giocatori (aumentato vittorie/sconfitte totali)
        if(player1.getVittorieTemporanee() == 3){
            player1.addWinMatch();
            player2.addLostMatch();
        }else if(player2.getVittorieTemporanee() == 3){
            player1.addWinMatch();
            player2.addLostMatch();
        }
        // a questo punto resetto le vittorie Temporanee
        player1.setVittorieTemporanee(0);
        player2.setVittorieTemporanee(0);
        // Salvo i dati dei due giocatori (e li salvo nel "Database" che contiene tutti i player)
        salvaDati(player1, player2);
        // Tornare al menu principale
    }

    private void salvaDati(Player player1, Player player2) {
        // Logica per salvare i dati dei giocatori
    }


    /*   Getters & Setters  */
    public Pokemon getPokemonInAttacco() {
        return pokemonInAttacco;
    }
    public void setPokemonInAttacco(Pokemon pokemonInAttacco) {
        this.pokemonInAttacco = pokemonInAttacco;
    }
    public boolean isTurnoGiocatore1() {
        return turnoGiocatore1;
    }

}       // FINE CLASSE
