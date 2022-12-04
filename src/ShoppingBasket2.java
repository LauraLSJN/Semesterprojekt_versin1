import java.awt.*;

public class ShoppingBasket2 {
    Position position;

    public ShoppingBasket2(){
        this.position = new Position(300,300);
        System.out.println("Test");

    }

    public void paintBasket(Graphics2D g){
        g.setColor(Color.white);
        g.drawRect(position.getX(), position.getY(), 50,50);
    }


}
