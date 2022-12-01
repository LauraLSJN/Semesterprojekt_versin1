import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    protected Position position;
    protected Pos pos;
    //protected Position position2;
    //protected Pos PlayerObjectPos;
    protected Size size;
    protected Farve randomColor;

    public GameObject(){
        size = new Size(20,20);
        randomColor = new Farve();
;
    }

    public abstract Image getSprite();
    public abstract void update();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }

    public Farve getFarve(){
        return randomColor;
    }
}