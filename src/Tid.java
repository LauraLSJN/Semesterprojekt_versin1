import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;


import java.util.Timer;
import java.util.TimerTask;

public class Tid {
    Position position;
    int maxValue;
    String maxValueString;
    AttributedString attributedText;
    int rectx = 10;
    int recty = 200;
    int rectWidth = 100;
    int rectHeight = 100;
    int fontSize = 15;

    JFrame window;
    JLabel counterLabel;
    Font font1 = new Font("Arial", Font.PLAIN, 70);
    Timer timer;
    int second, minute;
    String ddSecond, ddMinute;
    DecimalFormat dFormat = new DecimalFormat("00");
    private Object Tid;


    public static void main(String[] args) {

        new Tid();
    }

    public Tid() {


        // Countdown Timer
        counterLabel.setText("01:00");
        second =0;
        minute =3;
        countdownTimer();
        timer.start();
    }


    public void countdownTimer() {

        timer = new Timer(1000, new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                second--;
                ddSecond = dFormat.format(second);
                ddMinute = dFormat.format(minute);
                counterLabel.setText(ddMinute + ":" + ddSecond);

                if(second==-1) {
                    second = 59;
                    minute--;
                    ddSecond = dFormat.format(second);
                    ddMinute = dFormat.format(minute);
                    counterLabel.setText(ddMinute + ":" + ddSecond);
                }
                if(minute==0 && second==0) {
                    timer.stop();
                }
            }
        });
    }
    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(rectx, recty, rectWidth, rectHeight);
        setText(graphics, maxValueString, rectx+fontSize,recty+fontSize);
        setText(graphics,String.valueOf(timer),rectx+fontSize,recty+fontSize+15);
        graphics.dispose();
        return image;
    }

    public void setText(Graphics2D graphics, String text, int x, int y){
        attributedText = new AttributedString(text);
        attributedText.addAttribute(TextAttribute.FONT, font1); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.WHITE); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), x, y);

        //graphics.drawString(attributedText.getIterator(), rectx+fontSize, recty+fontSize); //Placeres i billede -> X og y kordinat er i henhold til image

    }
    public Tid getTid() {
        return (Tid) Tid;
    }
}









