
import java.awt.Color;

//Klasse til at genrer random farve
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
