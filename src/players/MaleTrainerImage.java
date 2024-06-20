package players;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MaleTrainerImage {
    ImageIcon immagineMaleTrainer;

    public MaleTrainerImage(){
        // Assegno l'immagine
        Image img = null;
        try {
            img = ImageIO.read(new File("src/Img/maleTrainer.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image dimg = img.getScaledInstance(60, 60,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        this.immagineMaleTrainer = imageIcon;
    }

    public ImageIcon getImmagineMaleTrainer(){
        return immagineMaleTrainer;
    }
}
