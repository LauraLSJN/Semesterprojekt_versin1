import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FoodObjects extends GameObject {


    @Override
    public void update() {
        position = new Position(position.getX(), position.getY()+1);

        //graphics.setColor(randomColor());

    }

    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLUE);
        //graphics.setColor();
        //graphics.setColor(randomColor());
        graphics.fillRect(0,0, size.getWidth(), size.getHeight());
        graphics.dispose();
        //return null;
        return image;
    }

   /* @Override
    public void paintComponent(Graphics g) {
        Random rnd = new Random();
        paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        //g2d.setBackground(Color.BLACK);
        g2d.clearRect(0, 0, size.getWidth(),size.getHeight());

        for (int i=0; i<3000; i++) {
            int red = rnd.nextInt(256);
            int green = rnd.nextInt(256);
            int blue = rnd.nextInt(256);
            g2d.setColor(new Color(red, green, blue));

            int rndX = rnd.nextInt(getSize().width);
            int rndY = rnd.nextInt(getSize().height);

            g2d.drawLine(rndX, rndY, rndX, rndY);
        }
    }*/

    public Color randomColor()
    {
       // float red   = (float) Math.random();
        //float green = (float) Math.random();
        //float blue  = (float) Math.random();

        //return new Color( red, green, blue );

        Random rand = new Random();

        Color color = new Color(rand.nextInt(0xFFFFFF));

 return color;
    }



}