import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Display display;
    private List<GameObject> gameObject;
    private Input input;
    protected Position position;
    protected Pos pos;


    public Game(int width, int height){
        input = new Input();
        display = new Display(700,500, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        gameObject = new ArrayList<>();
        //graphics.setColor(randomColor());
        //gameObject.add(new FoodObjects());
        //gameObject.add(new FoodObjects());
        //position = new Position(200,200);

        gameObject.add(new FoodObjects());
        gameObject.add(new PlayerObject(new Player(input)));
        //gameObject.add(new PlayerObject(new Player(input)));
        //gameObject.add(new PlayerObject(new Player(input)));
        //detectionPlayer();

        System.out.println("GameObject Størrelse: " + gameObject.size());

    }



    public void detectionPlayer(){
        FoodObjects foodObjects = new FoodObjects();
        PlayerObject playerObject = new PlayerObject();


            //System.out.println("Den er ramt");
            System.out.println("xPlayer: " + playerObject.getxPlayer());
            System.out.println("yFood: " + foodObjects.getyFood() );

    }


    public void update(){
        gameObject.forEach(gameObject -> gameObject.update());

    }



    public void render(){
        display.render(this);

    }

    public List<GameObject> getGameObject() {
        return gameObject;
    }
}
