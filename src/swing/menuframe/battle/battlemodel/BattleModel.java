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
    private BattleView viewBattaglia;
    private Pokemon pokemonInAttacco;
    private Pokemon pokemonInDIfesa;

    // inizializzo
    private BattleController controllerBattaglia;


    // Costruttore
    public BattleModel(Player player1, Player player2, BattleView viewBattaglia){
        // Collego il controller al BattleModel
        controllerBattaglia = new BattleController(this, viewBattaglia);
        this.player1 = player1;
        this.player2 = player2;
        // Setto inizialmente questo
        this.pokemonInAttacco = player1.getTeam().get(0);   // inizializzo come pokemon in attacco il primo pokemon del team del giocatore in attacco (player1)
        this.pokemonInDIfesa = player2.getTeam().get(0);   // inizializzo come pokemon in attacco il primo pokemon del team del giocatore in difesa (player2)

        // NOTA: il "playerInTurno" è il playerInAttacco chiaramente. --> il player in Attacco è il player1 per iniziare, poi si switchano



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






    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///              METODI              ///

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
}
