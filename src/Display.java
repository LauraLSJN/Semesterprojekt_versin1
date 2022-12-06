import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JFrame {

    private Canvas canvas;
    Image img = Toolkit.getDefaultToolkit().getImage("/Users/laura/Desktop/shoppingMarket.jpg"); //Erstat stigen, men din egen sti
    //Anna sti:
    //Chris sti:
    //Caro sti:


    public Display(int width, int height, Input input){
        setTitle("MyFoodSolver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStartegy = canvas.getBufferStrategy();
        Graphics graphics = bufferStartegy.getDrawGraphics();

        graphics.drawImage(img, 0, 0,700,500,null); //"Tegner" baggrunden som billedet
        //graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight()); //Kan anvendes hvis billede ikke virker


        //Henter gameObjects (FoodObjcts & PlayerObjects) og tegner det
        //Anvender Lambda Expression
        game.getGameObject().forEach(gameObject -> graphics.drawImage( //gameobject vi har foodobjekter og player i
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null

        ));
        //Tegner shoppingBasket
        game.getShoppingBaskets().forEach(shoppingBasket -> graphics.drawImage(
                shoppingBasket.getSprite(),
                shoppingBasket.position.getX(),
                shoppingBasket.position.getY(), null
        ));

        //Tegner tiden
        game.getTid().forEach(tid -> graphics.drawImage(
                tid.getSprite(),
                tid.position.getX(),
                tid.position.getY(),null
        ));


        graphics.dispose();
        bufferStartegy.show();

    }



}
