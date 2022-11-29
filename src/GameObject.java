import java.awt.*;
import java.util.Random;

public abstract class GameObject {
    protected Position position;
    protected Pos pos;
    //protected Position position2;
    //protected Pos PlayerObjectPos;
    protected Size size;
    protected Farve randomColor;
    Random random = new Random();
    //protected int xFood;
    //protected int yFood;
    protected int xPlayer;
    protected int yPlayer;


    public GameObject(){
        position = new Position(random.nextInt(700), 0);
        pos = new Pos(350, 480);
        //position = new Position(random.nextInt(700), 0);
        //position = new Position(300,300);

        size = new Size(20,20);
        randomColor = new Farve();
;
    }
    //public abstract Image getSpriteFood();
    public abstract Image getSprite();
    public abstract void update();

    public Position getPosition() {
        return position;
    }
    public Pos getPos(){return pos;}


    public Size getSize() {
        return size;
    }

    public Farve getFarve(){
        return randomColor;
    }
}