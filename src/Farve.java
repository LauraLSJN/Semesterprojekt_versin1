import java.awt.*;
import java.awt.Color;

public class Farve {
    public Color farveFarve;

    public Farve() {
        this.farveFarve = setFarve();
    }

    public Color setFarve() {
        float red   = (float) Math.random();
        float green = (float) Math.random();
        float blue  = (float) Math.random();

        return new Color( red, green, blue );

    }


}
