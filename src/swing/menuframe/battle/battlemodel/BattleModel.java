package swing.menuframe.battle.battlemodel;

import database.Database;
import swing.menuframe.battle.battlecontroller.BattleController;
import moves.Move;
import players.Player;
import pokemon.Pokemon;
import swing.menuframe.battle.battleview.BattleView;
import swing.menuframe.battle.battleview.MoveButton;
import swing.menuframe.battle.battleview.PokeButton;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/* Model della Battaglia (Logica) */
public class BattleModel {

    private Player player1;
    private Player player2;

    // inizializzo
    private Database databaseDatiPlayer = new Database();
    private BattleView viewBattaglia;
    private boolean turnoGiocatore1 = true;
    private Pokemon pokemonInAttacco;
    private Pokemon pokemonInDifesa;
    private int battaglieGiocate = 0;


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

        if (battaglieGiocate == 1) {
            terminaPartita();
        }

        // ALTRIMENTI
        ripristinaVitaPokemon(player1);
        ripristinaVitaPokemon(player2);
        viewBattaglia.inizializzaView(player1, player2, viewBattaglia.getScorePanel());

        // Impsto i turni e i Pokemon Iniziali
        turnoGiocatore1 = true;
        pokemonInAttacco = player1.getTeam().get(0);
        pokemonInDifesa = player2.getTeam().get(0);

        cicloBattaglia();
    }


    private void cicloBattaglia() {

        if (squadraEsausta(player1) || squadraEsausta(player2)) {
            // Quando una delle due squadre è esausta, incremento le vittorie temporanee e stoppo il cicloBattaglia
            if (squadraEsausta(player1)) {
                player2.incrementaVittorieTemporanee();
                // Aggiorno lo Scorer in alto
                viewBattaglia.aggiornaScorerPunteggio1(player2);
                viewBattaglia.repaint();
                JOptionPane.showMessageDialog(new JButton("Nuova Partita"),player2.getName() + " Ha vinto, ora si trova a " + player2.getVittorieTemporanee() + " Vittorie!");

            } else {
                player1.incrementaVittorieTemporanee();
                // aggiorno lo scorer in alto
                viewBattaglia.aggiornaScorerPunteggio2(player1);
                viewBattaglia.repaint();
                JOptionPane.showMessageDialog(new JButton("Nuova Partita"),player1.getName() + " Ha vinto, ora si trova a " + player1.getVittorieTemporanee() + " Vittorie!");

            }
            battaglieGiocate ++;
            // Inizio una nuova battaglia
            nuovaBattaglia();

        }else {

            if (!pokemonInAttacco.isAlive()) {
                // se il pokemon appena switchato in attacco è esausto, allora
                aggiornaPokemonEsausto(pokemonInAttacco);
            }
        }
    }


    /* Metodi che influiscono sulla logica della battaglia     */
    public void eseguiMossa(MoveButton selectedMove, Pokemon pokemonInCampoAttaccante, Pokemon pokemonInCampoDifensore){

        // Faccio eseguire la Mossa
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
        }
        // Dopo aver eseguito l'attacco, cambia il turno
        turnoGiocatore1 = !turnoGiocatore1;             // inverto il valore del turno

        // Scambio le turnazioni a livello logico del Pokemon
        scambiaTurnazioniModel(pokemonInAttacco, pokemonInDifesa);

        // scambio le turnazioni a livello visivo
        viewBattaglia.scambiaTurnazioniView();
        // ripeto il cicloBattaglia();
        cicloBattaglia();
    }


    private void scambiaTurnazioniModel(Pokemon vecchioPokemonInCampoAttaccante, Pokemon vecchioPokemonInCampoDifensore) {
        // Scambio i ruoli dei pokemon in campo
        setPokemonInAttacco(vecchioPokemonInCampoDifensore);
        setPokemonInDifesa(vecchioPokemonInCampoAttaccante);
        viewBattaglia.scambiaTurnazioni(this.pokemonInDifesa, this.pokemonInAttacco);


        System.out.println("Posizioni nel prossimo Turno: ");
        System.out.println("Pokemon in attacco nel MODEL : " + pokemonInAttacco.getName());
        System.out.println("Pokemon in difesa nel MODEL : " + pokemonInDifesa.getName());
    }

    public void aggiornaPokemonEsausto(Pokemon pokeEsausto){
        // Implementare la logica di cambiamento del pokemon esausto
        // Dopo aver implementato a livello logico la "morte" del pokemon notifico al controller il cambiamento della view
        viewBattaglia.aggiornaPokemonEsausto(pokeEsausto);
        System.out.println("Sono nel BattleModel in aggiornaPokemonEsausto");
        // Devo inserire la logica che mi permetta di aggiornare un pokemon

    }

    public void cambioPokemon(Pokemon pokemonInCampoScelto){
        System.out.println("cambioPokemon nel Model");
        this.pokemonInAttacco = pokemonInCampoScelto;
        // Debug per vedere se il riferimento del pokemon è aggiornato
        viewBattaglia.cambioPokemonGrafica();

        System.out.println("Pokemon in attacco nel modello: " + this.pokemonInAttacco.getName());
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
            // Print di Debug
            System.out.println(pokemon);
        }

    }

    private void terminaPartita() {
        // Ripristino la vita dei pokemon
        ripristinaVitaPokemon(player1);
        ripristinaVitaPokemon(player2);

        // Logica per salvare i dati e terminare la partita
        System.out.println("Partita terminata!");
        // Vado a modificare le stats dei giocatori (aumentato vittorie/sconfitte totali)
        if(player1.getVittorieTemporanee() == 3){
            player1.addWinMatch();                  // aggiungo la vittoria al player vincitore
            player2.addLostMatch();                 // aggiungo la vittoria al player sconfitto
        }else if(player2.getVittorieTemporanee() == 3){
            player1.addWinMatch();                  // aggiungo la vittoria al player vincitore
            player2.addLostMatch();                  // aggiungo la vittoria al player sconfitto
        }
        // a questo punto resetto le vittorie Temporanee
        player1.setVittorieTemporanee(0);
        player2.setVittorieTemporanee(0);
        // Salvo i dati dei due giocatori (e li salvo nel "Database" che contiene tutti i player)
        salvaDati(player1);
        salvaDati(player2);

        // Sovrascrivo il file con il nuovo aggiornamento dati
        try {
            databaseDatiPlayer.salvaSuFile(databaseDatiPlayer.getPathFileDatabase());
        }catch(IOException e){
            System.out.println("Il File non esiste");
        }

        // DEBUG
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        try {
            databaseDatiPlayer.caricaDaFile(databaseDatiPlayer.getPathFileDatabase());
            System.out.println(databaseDatiPlayer.getPlayerSalvati());
            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
        }catch(IOException e){
            System.out.println("Il File non esiste");
        }


        // Tornare al menu principale
        schermataVittoria();
    }

    private void salvaDati(Player player) {
        // Mi ricavo la lista di tutti i player salvati
        int playerId = player.getId();
        List<Player> listaPlayer = databaseDatiPlayer.getPlayerSalvati();

        if(playerId == -1){
            // se id == -1 il player non è nella lista, lo aggiungo
            player.setId(listaPlayer.size());
            listaPlayer.add(player);
        }else if(playerId >=0 && playerId < listaPlayer.size()){
            // Altrimenti modifico il player già nella lista
            listaPlayer.set(playerId, player);
        }
    }


    private void schermataVittoria() {

    }


    /*   Getters & Setters  */
    public Pokemon getPokemonInAttacco() {
        return pokemonInAttacco;
    }
    public void setPokemonInAttacco(Pokemon pokemonInAttacco) {
        this.pokemonInAttacco = pokemonInAttacco;
    }
    public void setPokemonInDifesa(Pokemon pokemonInDifesa) {
        this.pokemonInDifesa = pokemonInDifesa;
    }
    public boolean isTurnoGiocatore1() {
        return turnoGiocatore1;
    }



}       // FINE CLASSE
