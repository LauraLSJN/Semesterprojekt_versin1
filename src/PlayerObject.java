import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PlayerObject extends GameObject {
    private Controller controller;


    public PlayerObject(Controller controller) {
        super();
        this.controller = controller;
        position = new Position(350,400);
    }

    @Override
    public void update() {
        int deltaX = 0;

            if (controller.isRequestiongLeft()) {
                deltaX--;
        }
            if (controller.isRequestiongRight()) {
                deltaX++;
        }

        int oldPosX = position.getX();
        position.setX(oldPosX+deltaX);

        //position = new Position(pos.getX(), pos.getY());
        //pos = new Pos(pos.getX() + deltaX, pos.getY() + deltaY);
        //System.out.println("PlayerObject - PositionX: " + position.getX() + " Y: "+ position.getY());
        //System.out.println("PlayerObject - PosX: " + pos.getX() +" Y: "+ pos.getY());
        //xPlayer = pos.getX();
        //yPlayer = pos.getY();
        //System.out.println("xPlayer = " + xPlayer + " yPlayer: " + yPlayer);
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

    /*@Override
    public Image getSpritePlayer() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics.dispose();
        return image;
    }*/


}
