import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PlayerObject extends GameObject {


    @Override
    public void update() {
        PlayerObjectPos = new Position(PlayerObjectPos.getX(), PlayerObjectPos.getY());

        //graphics.setColor(randomColor());

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }






}
