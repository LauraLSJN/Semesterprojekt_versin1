import java.awt.*;
import java.awt.Color;

public class Farve {
    public Color randomColor;

    public Farve() {
        this.randomColor = setRandomColor();
    }

    public Color setRandomColor() {
        float red   = (float) Math.random();
        float green = (float) Math.random();
        float blue  = (float) Math.random();

        return new Color( red, green, blue );

    }


}
