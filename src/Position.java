import java.util.Random;

public class Position {

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
        //Tjek for om det nye y er indenfor max
    }

    private int x;
    private int y;
    //maxX og minY
    Random random = new Random();

    public Position(int x,int y){
        //Random random = new Random();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    //Denne klasse kan styre at objekter ikke må komme ud for billedet

}
