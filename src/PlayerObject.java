import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PlayerObject extends GameObject {
    private Controller controller;

    public PlayerObject(Controller controller){
        super();
        this.controller = controller;

    }


    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if(controller.isRequestiongLeft()){
            deltaX--;
        }
        if(controller.isRequestiongRight()){
            deltaY++;
        }
        pos = new Pos(pos.getX()+deltaX,pos.getY());
        System.out.println(pos.getX() + " " + pos.getY());

        //position = new Position(position.getX(), position.getY());
        //position = new Position(350, 480);
        //position = new Position(350+deltaX, 480+deltaY);
        //pos = new Pos(position.getX()+deltaX, position.getY()+deltaY);

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
