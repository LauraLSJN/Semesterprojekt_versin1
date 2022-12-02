import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

public class ShoppingBasket {
    Position position;
    int maxValue;

    public ShoppingBasket(){
        position = new Position(0,0);
        this.maxValue = 500;

    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void update(){

    }

    public int addFood(int foodValue){
        int newShoppingBasket = maxValue-foodValue;
        return newShoppingBasket;
    }

    public Image getSprite() {

        /*BufferedImage image = null;
        try {
            image = ImageIO.read(new File("shoppingBasket.png"));
        } catch (IOException e) {
        }*/

        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(10, 10, 100, 100);
        graphics.dispose();
        return image;
    }



}
