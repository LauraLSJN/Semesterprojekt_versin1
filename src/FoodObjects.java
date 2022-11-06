import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {


    @Override
    public void update() {
        FoodObjectsPos = new Position(FoodObjectsPos.getX(), FoodObjectsPos.getY()+1);

        //graphics.setColor(randomColor());

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(getFarve().randomColor);
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }






}