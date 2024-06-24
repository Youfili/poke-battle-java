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
    private Pokemon pokemonInAttacco;
    private Pokemon pokemonInDifesa;

    // inizializzo
    private BattleController controllerBattaglia;
    private BattleView viewBattaglia;
    private boolean turnoGiocatore1;


    // Costruttore
    public BattleModel(Player player1, Player player2, BattleView viewBattaglia){
        // Collego il controller al BattleModel
        controllerBattaglia = new BattleController(this, viewBattaglia);
        this.player1 = player1;
        this.player2 = player2;
        this.viewBattaglia = viewBattaglia;

        // NOTA: il "playerInTurno" è il playerInAttacco chiaramente. --> il player in Attacco è il player1 per iniziare, poi si switchano
        iniziaPartita();            // avvio l'inizio della partita


    } // Fine Costruttore


    /* Inserire in questo campo la Logica di Turnazione dei giocatori, in cui il giocatore in Attacco è il player1, mentre il giocatore in difesa è il player2
        All'interno delle turnazioni si vanno a richiamare metodi già creati ed altri da creare in base a come svoglerò la logica di attacco.

         Calcolare il FINE_BATTAGLIA --> ossia quando tutti i pokemon di un Team sono "esausti" --> isAlive() == false , e in quel caso aggiornare il punteggio
         della barra di calcolo punteggio.
         A Ogni fine Battaglia, si fa un controllo se uno dei due è arrivato a 3, in quel caso si ripristina la vita dei Pokemon cosi da Risanare tutta la squadra,
         si aggiornarno le Vittorie/Sconfitte e le partite giocate dei giocatori. E dopo averli salvati si ritorna al Menu principale!

     */

    /*
    Nel costruttore della BattleModel posso mettere un metodo iniziaPartita() -->
    che richiama un metodo  nuovaBattaglia(player1, player2)  in cui si inizia la battaglia dopo aver ripristinato la vita dei
    pokemon di entrambi i giocatori e controllato il numero di battaglie vinte da ogni giocatore
    ( se >= 3, la partita finisce , richiamando il metodo salvaDati(player1, player2)  )
    Se ancora non si è arrivati al punto di 3 vittorie da parte di un giocatore -->
    Inizia un ciclo while che prosegue fin quando tutti i pokemon dell'avversario non sono Esausti in cui si alternarno le turnazioni di Azioni svolte
    quando si raggiunge questa situazione (vittoria di una battaglia), a quel punto si richiama il metodo nuovaBattaglia()

     */

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
        turnoGiocatore1 = true;
        pokemonInAttacco = player1.getTeam().get(0);
        pokemonInDifesa = player2.getTeam().get(0);
        // Capire come aggiornare la view da campo
//        viewBattaglia.aggiornaView(pokemonInAttacco, pokemonInDifesa);
        viewBattaglia.revalidate();
        viewBattaglia.repaint();
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
            // turnoGiocatore1 = !turnoGiocatore1; --> gestito dopo l'attacco nel metodo eseguiMossa()
        }else {
            // Una volta che il ciclo è terminato (una squadra è esausta), incremento le vittorie temporanee
            if (squadraEsausta(player1)) {
                player2.incrementaVittorieTemporanee();
                // Aggiorno lo Scorer in alto
                controllerBattaglia.aggiornaScorerPunteggio1(player2);
            } else {
                player1.incrementaVittorieTemporanee();
                // aggiorno lo scorer in alto
                controllerBattaglia.aggiornaScorerPunteggio2(player2);
            }
//        // dopo aver incrementato le vittorie temporanee, inizio una nuova Battaglia
        nuovaBattaglia();
        }

    }


    private void eseguiTurno(Player attaccante, Player difensore) {
        Pokemon pokemonAttaccante = turnoGiocatore1 ? pokemonInAttacco : pokemonInDifesa;
        Pokemon pokemonDifensore = turnoGiocatore1 ? pokemonInDifesa : pokemonInAttacco;

        // Logica per eseguire la mossa o cambiare Pokémon
        // Ad esempio:
        // eseguiMossa(selectedMove, pokemonAttaccante, pokemonDifensore);
        // oppure
        // cambioPokemon(nuovoPokemon);

        viewBattaglia.resettaPannello1();
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



    /* Metodi che influiscono sulla logica della battaglia     */
    public void eseguiMossa(MoveButton selectedMove, Pokemon pokemonInCampoAttaccante, Pokemon pokemonInCampoDifensore){
        // Implementare la logica di questo metodo che permetta di eseguire la mossa
        // In questa logica vado a diminuire a livello logico la vita del pokemon
        // quindi mi basta andare a settare la BarraHp in base alla vita del pokemon stesso

        Move mossaScelta = selectedMove.getMove();
        int vitaPostAttacco = pokemonInCampoDifensore.getHealth() - mossaScelta.getDamage();
        if(vitaPostAttacco > 0) {
            pokemonInCampoDifensore.setHealth(vitaPostAttacco);
        }else {
            // Altrimenti il pokemon è Esausto!
            pokemonInCampoDifensore.setHealth(0);       // imposto la vita a 0 del pokemon
            pokemonInCampoDifensore.setAlive(false);    // imposto che il pokemon non è più vivo
            aggiornaPokemonEsausto(pokemonInCampoDifensore);    // uso il metodo pokemonEsausto
        }

        // Dopo aver eseguito l'attacco, cambia il turno
        turnoGiocatore1 = !turnoGiocatore1;

        // Aggiorna la view per il nuovo turno
        Pokemon nuovoPokemonAttacco = turnoGiocatore1 ? pokemonInAttacco : pokemonInDifesa;
        Pokemon nuovoPokemonDifesa = turnoGiocatore1 ? pokemonInDifesa : pokemonInAttacco;
        // Aggiorno il pokemon in Attacco e aggiorno il pokemon in difesa
        aggiornaTurnazioniPokemon(nuovoPokemonAttacco, nuovoPokemonDifesa);
        viewBattaglia.aggiornaView(nuovoPokemonAttacco, nuovoPokemonDifesa);

    }

    private void aggiornaTurnazioniPokemon(Pokemon nuovoPokemonAttacco, Pokemon nuovoPokemonDifesa) {
        this.pokemonInAttacco = nuovoPokemonAttacco;
        this.pokemonInDifesa = nuovoPokemonDifesa;
    }


    public void aggiornaPokemonEsausto(Pokemon pokeEsausto){
        // Implementare la logica di cambiamento del pokemon esausto
        // Dopo aver implementato a livello logico la "morte" del pokemon notifico al controller il cambiamento della view
        controllerBattaglia.aggiornaPokemonEsausto(pokeEsausto);
        System.out.println("Sono nel BattleModel in pokemonEsausto");

    }

    public void cambioPokemon(Pokemon pokemon1InCampo){
        System.out.println("cambioPokemon nel Model");
        this.pokemonInAttacco = pokemon1InCampo;
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
}
