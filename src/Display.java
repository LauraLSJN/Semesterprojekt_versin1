import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JFrame {

    private Canvas canvas;
    Image img = Toolkit.getDefaultToolkit().getImage("/Users/laura/Desktop/shoppingMarket.jpg");


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
    }

    public void render(Game game){
        BufferStrategy bufferStartegy = canvas.getBufferStrategy();
        Graphics graphics = bufferStartegy.getDrawGraphics();

        graphics.drawImage(img, 0, 0,700,500,null);

        //graphics.
        //graphics.drawImage()
        //canvas.setBackground(Color.GREEN);


        //graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
        //graphics.drawString("HEJ",300,300);
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

    /*public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setFont(new Font());
        g2D.drawString("DU ER EN VINDER", 300,300);

    }*/


}
