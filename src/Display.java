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

        //graphics.setColor(Color.BLUE);
        graphics.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());

        game.getGameObject().forEach(gameObject -> graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPosition().getX(),
                gameObject.getPosition().getY(),
                //gameObject.getPos().getX(),
                //gameObject.getPos().getY(),
                null

        ));

        game.getGameObject().forEach(gameObject ->graphics.drawImage(
                gameObject.getSprite(),
                gameObject.getPos().getX(),
                gameObject.getPos().getY(),null
        ));

        graphics.dispose();
        bufferStartegy.show();

    }


}
