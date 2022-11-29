import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class PlayerObject extends GameObject {
    private Controller controller;
    private int xPlayer;
    private int yPlayer;
    //FoodObjects foodObjects;

    public PlayerObject(){
        super();
    }

    public PlayerObject(Controller controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void update() {
        int deltaX = 0;
        int deltaY = 0;

        if (xPlayer >= 0) { //skærmstørrelsen går fra 0-700, sat i Game
            if (controller.isRequestiongLeft()) {
                deltaX--;
            }
        }

        if (xPlayer+20 <= 700) { //Skærmstørrelsens bredde, sat i Game, +20 ved xPlayer, pga firkantens x,y startspunkt
            if (controller.isRequestiongRight()) {
                deltaX++;
            }

        }

        position = new Position(pos.getX(), pos.getY());
        pos = new Pos(pos.getX() + deltaX, pos.getY() + deltaY);
        //System.out.println("PlayerObject - PositionX: " + position.getX() + " Y: "+ position.getY());
        //System.out.println("PlayerObject - PosX: " + pos.getX() +" Y: "+ pos.getY());
        xPlayer = pos.getX();
        yPlayer = pos.getY();
        //System.out.println("xPlayer = " + xPlayer + " yPlayer: " + yPlayer);

        //Til at se i konsol, om xPlayer rammer siderne
        if (xPlayer <= 0) {
            System.out.println("Du er for langt ud 0");
        } else if (xPlayer >= 700) {
            System.out.println("Du er for langt ude 700");
        }


        /*FoodObjects foodObjects = new FoodObjects();
        System.out.println("xFood: " + xFood );

        if (xFood == xPlayer){
            System.out.println("hej");
        }
*/
        /*if(xPlayer ==){
            System.out.println("Du har ramt");
            System.out.println("xPlayer: " + xPlayer);
            System.out.println("Yfood: " + foodObjects.getyFood());
        }*/

        //System.out.println(pos.getX() + " " + pos.getY());

        //position = new Position(position.getX(), position.getY());
        //position = new Position(350, 480);
        //position = new Position(350+deltaX, 480+deltaY);
        //pos = new Pos(position.getX()+deltaX, position.getY()+deltaY);

    }

    public int getxPlayer() {
        //this.xPlayer = pos.getX();
        return xPlayer;
    }

    public int getyPlayer() {
        //this.yPlayer = pos.getY();
        return yPlayer;
    }


    @Override
    public java.lang.String toString() {
        return "PlayerObject{" +
                "xPlayer=" + xPlayer +
                ", yPlayer=" + yPlayer +
                '}';
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
