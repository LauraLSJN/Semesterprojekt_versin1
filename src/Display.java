import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JFrame {

    private Canvas canvas;
    private BufferedImage img = null;

    public Display(int width, int height, Input input){
        setTitle("MyFoodSolver");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        //canvas.setBackground(Color.GREEN);
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);

        setLocationRelativeTo(null);
        setVisible(true);
        /*try
        {
            img = ImageIO.read( new File("MyPicture.jpg" ));
        }
        catch ( IOException exc )
        {
            //TODO: Handle exception.
        }*/
    }

    public void render(Game game){
        BufferStrategy bufferStartegy = canvas.getBufferStrategy();
        Graphics graphics = bufferStartegy.getDrawGraphics();
        //graphics.drawImage( img, 400, 400, this );
        //graphics.
        //graphics.drawImage()
        //canvas.setBackground(Color.GREEN);

    graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
        //game.getShoppingBasket2();


        //Henter gameObjects (FoodObjcts & PlayerObjects) og tegner det
        //Anvender Lambda Expression
        game.getGameObject().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                null

        ));
        //Usikker på om det er den rigtige måde -Laura
        game.getShoppingBaskets().forEach(shoppingBasket -> graphics.drawImage(
                shoppingBasket.getSprite(),
                shoppingBasket.position.getX(),
                shoppingBasket.position.getY(), null
        ));



        graphics.dispose();
        bufferStartegy.show();


    }


}
