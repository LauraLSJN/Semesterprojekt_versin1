import java.util.Random;

public class Position {
    private int x;
    private int y;
    //maxX og minY

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x>= 0 && x<=680){ // vinduet bredde starter fra 0 og op til 700, vi har sagt 680 fordi player firkanten er 20 pixels.
        this.x = x;
        }else{
            System.out.println("Ude for rammen");
        }
    }

    public void setY(int y) {
        this.y = y;
        //Tjek for om det nye y er indenfor max
    }

    //Denne klasse kan styre at objekter ikke må komme ud for billedet

}
