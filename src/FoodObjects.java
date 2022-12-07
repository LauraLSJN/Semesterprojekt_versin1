import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.Random;

public class FoodObjects extends GameObject { //globale variabler som vi bruger
    Random random = new Random();
    Font font = new Font("Monospaced", Font.BOLD, 15);
    String textInImage;
    AttributedString attributedText;
    int speed = 1; //Evt. getter og setter

    //Konstruktør -> Sætter position
    public FoodObjects(){ //herunder bliver værdierne som vi gerne vil have blive sat
        position = new Position(random.nextInt(size.getDisplayWidth()- size.getGameObjectWidth()),0 ); //-gameObject size, så de ikke placeres udenfor display
        price.setValuePrice(random.nextInt(price.getMinPrice(),price.getMaxPrice()));
        textInImage = String.valueOf(getPrice().getValuePrice()); //Henter valuePrice
    }


    @Override
    public void update() {
        //Get metode til at hente y-koordinat
        int oldPos = position.getY();
        //Set metode til at sætte den ny y-koordinat
        position.setY(oldPos+speed);

        //Print af FoodObjects position
        //System.out.println("Position FoodObjects");
        //System.out.println("Position X: " + position.getX() + "Position Y: " + position.getY());
    }



    @Override
    public Image getSprite() {
        BufferedImage image = new BufferedImage(size.getGameObjectWidth(),size.getGameObjectHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        if(getPrice().getValuePrice() >= 0){
            graphics.setColor(Color.green);
        } else{
            graphics.setColor(Color.red);
        }

        graphics.fillRect(0, 0, size.getGameObjectWidth(), size.getGameObjectHeight());
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
        graphics.drawString(attributedText.getIterator(), 2, (size.getGameObjectHeight()/2)+5); //Placeres i billede -> X og y kordinat er i henhold til image

    }

    //Printer arrayList til konsollen -> Anvendes til tjek
    @Override
    public String toString() {
        return "FoodObjects{" +
                "price=" + price +
                '}';
    }
}