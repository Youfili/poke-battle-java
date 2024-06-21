package database;

import players.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {

    // Lo metto statico cosi viene inteso come variabile della classe e non di istanza
    private static List<Player> playerSalvati = new ArrayList<>();         // List dei player salvati su file

    public Database (){

    }


    public void salvaSuFile(File fileDaSalvare) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileDaSalvare);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Converto l'arrayList in un array Normale --> per evitare problemi di conversione
        Player[] arrayPlayerSalvati = playerSalvati.toArray(new Player[playerSalvati.size()] );

        // ora che ho l'array posso andarlo a salvare
        oos.writeObject(arrayPlayerSalvati);

        // Chiudo i File
        oos.close();
        fos.close();
    }


    public void caricaDaFile(File fileDaCaricare) throws IOException{
        FileInputStream fis = new FileInputStream(fileDaCaricare);
        ObjectInputStream ois = new ObjectInputStream(fis);

        // La classe potrebbe non essere trovata, faccio try e catch
        try {
            // carico i dati in un array di Player
            Player[] giocatoriSalvati = (Player[]) ois.readObject();

            // Svuoto l'arrayList cosi da modificarlo
            playerSalvati.clear();
            // posso inserire tutti gli elementi di una Collect in questo arrayList
            // l'array "giocatoriSalvati" viene convertito in lista e poi assegnato all'arrayList dei giocatori salvati
            playerSalvati.addAll(Arrays.asList(giocatoriSalvati));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // chiudo i file
        ois.close();
        fis.close();
    }

    // Aggiungere giocatore alla lista dei playerSalvati
    public static void addListPlayer(Player playerDaAggiungere){
        playerSalvati.add(playerDaAggiungere);
    }

    // per ottenere la lista quando dovrò operare su di essa (il campo è privato, quindi devo inserire questo)
    public static List<Player> getPlayerSalvati() {
        return playerSalvati;
    }

    // Per modifica la lista quando deve essere aggiornata
    public static void setPlayerSalvati(List<Player> playerSalvati) {
        Database.playerSalvati = playerSalvati;
    }
}
