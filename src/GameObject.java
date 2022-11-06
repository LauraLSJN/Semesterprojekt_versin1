import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    protected Position position;
    //protected Position position2;
    //protected Pos PlayerObjectPos;
    protected Size size;
    protected Farve randomColor;

    public GameObject(){

        Random random = new Random();
        //position = new Position(200,200);
        position = new Position(random.nextInt(700), 0);
        //FoodObjectsPos = new Position(0, 0);

        //position = new Position(50,50);
        size = new Size(20,20);
        randomColor = new Farve();
        //position2 = new Position(200,200);
;
    }

    public abstract void update();
    public abstract Image getSprite();

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