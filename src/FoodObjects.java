import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {
    private int xFood;
    private int yFood;


    @Override
    public void update() {
        pos = new Pos(position.getX(), position.getY());
        position = new Position(position.getX(), position.getY()+1);
        //System.out.println("FoodObject - PositionX: " + position.getX() + " Y: "+ position.getY());
        //System.out.println("FoodObject - PosX: " + pos.getX() +" Y: "+ pos.getY());
        xFood = position.getX();
        yFood = position.getY();
        //System.out.println("xFood = " + xFood + " yFood: " + yFood);
    }

    public int test(){
        if (yFood==500){
        return xFood;
        }
        return yFood;
    }

    public int getxFood() {
        this.xFood = position.getX();
        return xFood;
    }

    public int getyFood() {
       // this.yFood = position.getY();
        return yFood;
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