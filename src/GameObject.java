import java.awt.*;


public abstract class GameObject {
    public Position position;
    protected Size size;
    protected Farve randomColor;
    protected Price price;

    public GameObject(){
        //size = new Size(20,20);
       // size.setGameObjectWidth(20);
       // size.setGameObjectHeight(20);
        size = new Size();


        //size = new Size(20,20);
        //size.setGameObjectHeight(20);
        //size.setGameObjectWidth(20);
        //size = new Size(20,20); //Størrelse på firkanter
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

    public Price getPrice(){return price;}

    public Farve getFarve(){
        return randomColor;
    }
}