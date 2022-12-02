import java.awt.*;
import java.awt.image.BufferedImage;

public class ShoppingBasket {
    Position position;
    int maxValue;


    public ShoppingBasket(){
        position = new Position(0,0);

    }

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(10, 10, 100, 100);
        graphics.dispose();
        return image;
    }


}
