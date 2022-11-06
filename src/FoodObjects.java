import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {


    @Override
    public void update() {
        position = new Position(position.getX(), position.getY()+1);

        //graphics.setColor(randomColor());

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(getFarve().farveFarve);
        //graphics.setColor();
        //graphics.setColor();
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics.dispose();
        //return null;
        return image;
    }
    





}