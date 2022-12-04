import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    private Canvas canvas;

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

        graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
        game.getShoppingBasket2();


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
