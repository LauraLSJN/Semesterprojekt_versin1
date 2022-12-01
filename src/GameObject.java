import java.awt.*;


public abstract class GameObject {
    public Position position;
    protected Size size;
    protected Farve randomColor;

    public GameObject(){
        size = new Size(20,20);
        randomColor = new Farve();


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