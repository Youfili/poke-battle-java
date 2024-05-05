package pokemon;

import moves.base.Action;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bulbasaur extends Pokemon{
    public Bulbasaur() {
        super("Bulbasaur",5,30,null,30,28,15);
        addMove(new Action());
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("/Users/leonardo/IdeaProjects/JPokeBattle_Beta/src/Img/bulbasaur.png"));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        this.setImage(img);

    }


}
