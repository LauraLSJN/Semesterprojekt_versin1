import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerObject extends GameObject {
    private Controller controller;
    //Size size;


    public PlayerObject(Controller controller) {
        super();
        this.controller = controller;
        position = new Position(350,465); //Starter på denne position
        //size = new Size(20,20);
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
        BufferedImage image = new BufferedImage(size.getGameObjectWidth(), size.getGameObjectHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, size.getGameObjectWidth(), size.getGameObjectHeight());
        graphics.dispose();
        return image;
    }


}
