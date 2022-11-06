import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    protected Position FoodObjectsPos;
    protected Position PlayerObjectPos;
    protected Size size;
    protected Farve randomColor;

    public GameObject(){
        Random random = new Random();
        FoodObjectsPos = new Position(300, 0);

        //FoodObjectsPos = new Position(random.nextInt(300), 0);
        //position = new Position(50,50);
        size = new Size(20,20);
        randomColor = new Farve();
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return FoodObjectsPos;
    }

    public Size getSize() {
        return size;
    }

    public Farve getFarve(){
        return randomColor;
    }
}