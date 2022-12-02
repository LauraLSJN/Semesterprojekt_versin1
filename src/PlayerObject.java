import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerObject extends GameObject {
    private Controller controller;


    public PlayerObject(Controller controller) {
        super();
        this.controller = controller;
        position = new Position(350,400); //Starter på denne position
    }

    @Override
    public void update() {
        int incrementX = 0;
        int oldPosX = position.getX(); //Gemmer tidligere x koordinat

            if (controller.isRequestiongLeft()) {
                incrementX--;
        }
            if (controller.isRequestiongRight()) {
                incrementX++;
        }
        position.setX(oldPosX+incrementX); //Sætter ny x-koordinat
    }


    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(), size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }


}
