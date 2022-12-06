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
    Font font = new Font("Monospaced", Font.BOLD, 10);
    String textInImage;
    AttributedString attributedText;
    Main main;

    int sec = 0;
    int min = 3;
    String ddSec;
    String ddMin;



    public Tid(){
        position = new Position(700-100,0);

        this.textInImage = "03:00:00";

        this.minSecond= 0;
        this.second =0;
        this.minute =3;
     //   countdownTimer();
        //timer.start();

    }
/*

    public void actionPerformed(ActionEvent e){
        sec--;
        ddSecond = ddFormat.format(sec);
        ddMinute = ddFormat.format(min);
        this.textInImage = (ddMin + ":" + ddSec);

        if(sec==-1) {
            sec = 59;
            min--;
            ddSecond = ddFormat.format(sec);
            ddMinute = ddFormat.format(min);
            this.textInImage = (ddMin + ":" + ddSec);
        }
       /* if(minute==0 && second==0) {
            timer.stop();
        }*/
/*
    }
    */

    public void update(){


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
            ddMinSec = ddFormat.format(minSecond);

            this.textInImage = (ddMinute + ":" + ddSecond + ":" + ddMinSec );



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
        graphics.fillRect(0, 0, 100, 50);
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
