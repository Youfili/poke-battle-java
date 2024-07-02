package database;

import players.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database implements Serializable {

    private static List<Player> playerSalvati = new ArrayList<>(); // Lista dei player salvati su file
    private static File pathFileDatabase = new File("src/database/databasePlayers.txt");

    public Database() {
        // Creazione del file se non esiste
        if (!pathFileDatabase.exists()) {
            try {
                pathFileDatabase.getParentFile().mkdirs(); // Crea le directory se non esistono
                pathFileDatabase.createNewFile(); // Crea il file
                // Inizializza il file con un array vuoto di Player
                salvaSuFile(pathFileDatabase);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void salvaSuFile(File fileDaSalvare) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileDaSalvare);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // Converto l'arrayList in un array Normale --> per evitare problemi di conversione
        Player[] arrayPlayerSalvati = playerSalvati.toArray(new Player[playerSalvati.size()]);

        // ora che ho l'array posso andarlo a salvare
        oos.writeObject(arrayPlayerSalvati);

        // Chiudo i File
        oos.close();
        fos.close();
    }

    public static void caricaDaFile(File fileDaCaricare) throws IOException {
        if (!fileDaCaricare.exists()) {
            throw new FileNotFoundException("Il file " + fileDaCaricare.getName() + " non esiste.");
        }

        // Controlla se il file è vuoto
        if (fileDaCaricare.length() == 0) {
            playerSalvati = new ArrayList<>(); // Inizializza con un arrayList vuoto se il file è vuoto
            return;
        }

        FileInputStream fis = new FileInputStream(fileDaCaricare);
        ObjectInputStream ois = new ObjectInputStream(fis);

        // La classe potrebbe non essere trovata, faccio try e catch
        try {
            // carico i dati in un array di Player
            Player[] giocatoriSalvati = (Player[]) ois.readObject();

            // Svuoto l'arrayList cosi da modificarlo
            playerSalvati.clear();
            // l'array "giocatoriSalvati" viene convertito in lista e poi assegnato all'arrayList dei giocatori salvati
            playerSalvati.addAll(Arrays.asList(giocatoriSalvati));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // chiudo i file
        ois.close();
        fis.close();
    }

//    public static void addListPlayer(Player playerDaAggiungere) {
//        playerSalvati.add(playerDaAggiungere);
//    }

    public static List<Player> getPlayerSalvati() {
        try {
            caricaDaFile(getPathFileDatabase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return playerSalvati;
    }

    public static void setPlayerSalvati(List<Player> listaPlayerSalvati) {
        playerSalvati = listaPlayerSalvati;
    }

    public static File getPathFileDatabase() {
        return pathFileDatabase;
    }
}





