import java.util.Random;

public class Position {
    private int x;
    private int y;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private Size size;
    //maxX og minY

    public Position(int x,int y){
        this.x = x;
        this.y = y;
        this.maxX = 700; //Width på display
        this.maxY = 500; //Height på display
        this.minX = 0;
        this.minY = 0;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x>= minX && x<=maxX-20){ // Minus 20, da firkanten er 20 Pixels, så den ikke kan komme over kanten, måske hentes fra size
        this.x = x;
        }else{
            System.out.println("Ude for rammen"); //Kontrol til terminal
        }
    }

    public void setY(int y) {
        this.y = y;

    }

}
