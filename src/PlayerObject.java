import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerObject extends GameObject {
    private Controller controller;
    private int speedX;
    private int oldPosX;
    Image imgShoppingkurv = Toolkit.getDefaultToolkit().getImage("\"C:\\Users\\Carov\\Desktop\\SBPNG.png\"");



    public PlayerObject(Controller controller) {
        super();
        this.controller = controller;
        //position = new Position(350,465); //Starter på denne position
        position = new Position(350,440);

    }

    @Override
    public void update() {
        speedX = 0;
        oldPosX = position.getX(); //Gemmer tidligere x koordinat

            if (controller.isRequestiongLeft()) {
                speedX--;
        }
            if (controller.isRequestiongRight()) {
                speedX++;
        }
        position.setX(oldPosX+ speedX); //Sætter ny x-koordinat
    }


    @Override
    public Image getSprite() {
        //BufferedImage image = new BufferedImage(size.getGameObjectWidth(), size.getGameObjectHeight(), BufferedImage.TYPE_INT_RGB);
        //BufferedImage image = new BufferedImage(60, 60, BufferedImage.TYPE_INT_RGB);
        BufferedImage image = new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);


        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(imgShoppingkurv,0,0,60,60,null);

        //graphics.drawImage(imgShoppingkurv,0,0,size.getGameObjectWidth(),size.getGameObjectHeight(),null);
        //graphics.setColor(Color.darkGray);
       //graphics.fillRect(0, 0, size.getGameObjectWidth(), size.getGameObjectHeight());
        graphics.dispose();
        return image;
    }


}
