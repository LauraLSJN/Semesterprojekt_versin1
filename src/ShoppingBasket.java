import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;

public class ShoppingBasket {
    Position position;
    int maxValue;
    String maxValueString;
    AttributedString attributedText;
    int rectx = 10;
    int recty = 10;
    int rectWidth = 100;
    int rectHeight = 100;
    int fontSize = 15;
    Font font = new Font("Monospaced", Font.BOLD, fontSize);
    int collectedFood;
    int oldCollectedFood;
    int nowCollectedFood;

    public ShoppingBasket(){
        position = new Position(0,0);
        this.maxValue = 100;
        maxValueString = String.valueOf(maxValue);
        this.collectedFood = 0;
        this.oldCollectedFood = 0;
    }

    public int getCollectedFood() {
        return collectedFood;
    }

    public void setCollectedFood(int collectedFood) {
        this.collectedFood = collectedFood;
        System.out.println("SET METODE: " + collectedFood);
    }

    /*public int getMaxValue() {
        return maxValue;
    }*/

    /*public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }*/

    public void update(){

       //int test =  addCollectedFood(collectedFood);
        //System.out.println("Test: " + test);
       // System.out.println(collectedFood);


    }

    public int addCollectedFood(int foodValue){
        System.out.println("old: " + oldCollectedFood + "foodvalue: " + foodValue);
        System.out.println("old1 = " + oldCollectedFood);

        //nowCollectedFood += foodValue;
        System.out.println("OldCollectedFood" + oldCollectedFood + " + " + "foodValue " + foodValue);
        nowCollectedFood = oldCollectedFood += foodValue; //FInd ud af hvorfor += virker og ikke hvis man deler det op
        System.out.println("old2 = " + oldCollectedFood);
        //nowCollectedFood = oldCollectedFood + foodValue;
        System.out.println("NowCOllectedFood = " +nowCollectedFood);
      return nowCollectedFood;

// return collectedFood += foodValue;
    }

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(rectx, recty, rectWidth, rectHeight);
        setText(graphics, maxValueString, rectx+fontSize,recty+fontSize);
        setText(graphics,String.valueOf(nowCollectedFood),rectx+fontSize,recty+fontSize+15);
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
