package pokemon;

import moves.base.Action;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bulbasaur extends Pokemon{
    public Bulbasaur() {
        super("Bulbasaur",5,30,null,30,28,15,"src/Img/bulbasaur.png");
        addMove(new Action());


    }


}
