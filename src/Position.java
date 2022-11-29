import java.util.Random;

public class Position {

    private int x;
    private int y;
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
}
