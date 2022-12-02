import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {
    Random random = new Random();

    //Konstruktør -> Sætter position
    public FoodObjects(){
        //Ny instans af Position klasse
        position = new Position(random.nextInt(700),0);
    }


    @Override
    public void update() {
        //Get metode til at hente y-koordinat
        int oldPos = position.getY();
        //Set metode til at sætte den ny y-koordinat
        position.setY(oldPos+1);

        //Print af FoodObjects position
        //System.out.println("Position FoodObjects");
        //System.out.println("Position X: " + position.getX() + "Position Y: " + position.getY());
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