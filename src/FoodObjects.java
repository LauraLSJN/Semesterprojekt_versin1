import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.Random;

public class FoodObjects extends GameObject {
    Random random = new Random();
    Font font = new Font("Arial", Font.BOLD, 15);
    String textInImage;
    AttributedString attributedText;

    //Konstruktør -> Sætter position
    public FoodObjects(){
        //Ny instans af Position klasse
        position = new Position(random.nextInt(700),0);
        price = new Price();
        price.setValuePrice(random.nextInt(100));
        textInImage = String.valueOf(getPrice().getValuePrice()); //Henter valuePrice
    }


    @Override
    public void update() {
        //Get metode til at hente y-koordinat
        int oldPos = position.getY();
        //Set metode til at sætte den ny y-koordinat
        position.setY(oldPos+1);

        //Print af FoodObjects position
        //System.out.println("Position FoodObjects");
        //System.out.println("Position X: " + position.getX() + "Position Y: " + position.getY());
    }



    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(getFarve().randomColor);
        graphics.fillRect(0, 0, size.getWidth(), size.getHeight());
        setText(graphics);
        graphics.dispose();
        return image;
    }

    //Price i firkanten
    //https://www.baeldung.com/java-add-text-to-image
    public void setText(Graphics2D graphics){
        attributedText = new AttributedString(textInImage);
        attributedText.addAttribute(TextAttribute.FONT, font); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.WHITE); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), 2, (size.getHeight()/2)+5); //Placeres i billede -> X og y kordinat er i henhold til image

    }

    //Printer arrayList til konsollen -> Anvendes til tjek
    @Override
    public String toString() {
        return "FoodObjects{" +
                "price=" + price +
                '}';
    }
}