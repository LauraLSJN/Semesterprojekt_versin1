import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;

public class Text {
    Position position;


    AttributedString attributedText;
    int rectx = 500; //starter ved højre hjørne -> x er 500
    int recty = 10; //starter ved y:10
    int rectWidth = 100;
    int rectHeight = 100;
    int fontSize = 15;
    Font font = new Font("Monospaced", Font.BOLD, fontSize);
    String textInImage;

    public Text(){
        //position = new Position(0,0);
        this.textInImage = "HEJ";
    }

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.GREEN);
        graphics.fillRect(rectx, recty, rectWidth, rectHeight);
        setText(graphics, textInImage, rectx+fontSize,recty+fontSize);
        graphics.dispose();
        return image;
    }

    //Price i firkanten
    //https://www.baeldung.com/java-add-text-to-image
    public void setText(Graphics2D graphics, String text, int x, int y){
        attributedText = new AttributedString(text);
        attributedText.addAttribute(TextAttribute.FONT, font); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.BLACK); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), x, y);

        //graphics.drawString(attributedText.getIterator(), rectx+fontSize, recty+fontSize); //Placeres i billede -> X og y kordinat er i henhold til image

    }



}
