import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {
    //private Position position;
    Random random = new Random();
    //Position objekt -> Kigge på dette objekt og ændrer på position

    //Konstruktør -> Initialisere alle variabler -> Opret new psoition objekt

    public FoodObjects(){
        position = new Position(random.nextInt(700),0);
    }


    @Override
    public void update() {
        int oldPos = position.getY();
        position.setY(oldPos+1);

        //pos = new Pos(position.getX(), position.getY());
        //position = new Position(position.getX(), position.getY()+1);
        //System.out.println("FoodObject - PositionX: " + position.getX() + " Y: "+ position.getY());
        //System.out.println("FoodObject - PosX: " + pos.getX() +" Y: "+ pos.getY());
        //xFood = position.getX();
        //yFood = position.getY();
        //System.out.println("xFood = " + xFood + " yFood: " + yFood);

        /*if (yFood == 500){
            System.out.println("yFood: ramt bunden -> " + yFood);
            System.out.println("xFood: " + xFood);
        }*/
    }



    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(getFarve().randomColor);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }








}