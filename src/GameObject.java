import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject(){
        Random random = new Random();
        position = new Position(random.nextInt(300), 0);
        //position = new Position(50,50);
        size = new Size(20,20);
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}