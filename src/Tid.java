import com.sun.tools.javac.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.util.Timer;

import static java.lang.Thread.sleep;


public class Tid {

    Position position;
    Timer timer;
    int minSecond;
    int second;
    int minute;
    String ddSecond;
    String ddMinute;
    String ddMinSec;
    DecimalFormat ddFormat = new DecimalFormat("00");
    int fontSize = 15;
    int xText = 15;
    int width = 100;
    int height = 50;

    //TEKST
    Font font = new Font("Monospaced", Font.BOLD, fontSize);
    String textInImage;
    AttributedString attributedText;



    public Tid(){
        position = new Position(700-100,0);
        this.textInImage = "03:00:00";
        this.minSecond= 0;
        this.second =0;
        this.minute =3;
        countdownTimer();
        //timer.start();

    }


    public void update(){



        //try {

            minSecond--;

            if(minSecond == -1){
                minSecond = 59;
                second--;
            }
            if (second == -1){
                second = 59;
                minute--;
            }
            ddSecond = ddFormat.format(second);
            ddMinute = ddFormat.format(minute);
            ddMinSec = dcFormat.format(minSecond);

            this.textInImage = (ddMinute + ":" + ddSecond + ":" + ddMinSec );

        /**
         * Mangler metode til når timer rammer 00:00:00, spillet skal stoppes.
         */

    }

    public void countdownTimer(){


        second--;
                ddSecond = ddFormat.format(second);
                ddMinute = ddFormat.format(minute);
                textInImage = (ddMinute + ":" + ddSecond);

                if(second==-1) {
                    second = 59;
                    minute--;
                    ddSecond = ddFormat.format(second);
                    ddMinute = ddFormat.format(minute);
                    textInImage = (ddMinute + ":" + ddSecond);





    }


        /*timer = new Timer();
        second--;
        ddSecond = ddFormat.format(second);
        ddMinute = ddFormat.format(minute);
        this.textInImage = (ddMinute + ":" + ddSecond);*/


    }

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100,50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, width, height);
        setText(graphics);
        graphics.dispose();
        return image;
    }

    public void setText(Graphics2D graphics){
        attributedText = new AttributedString(textInImage);
        attributedText.addAttribute(TextAttribute.FONT, font); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.WHITE); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), 15, 10); //Placeres i billede -> X og y kordinat er i henhold til image

    }


}
