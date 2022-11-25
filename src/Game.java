import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<GameObject> gameObject;
    private Input input;


    public Game(int width, int height){
        input = new Input();
        display = new Display(700,500, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        gameObject = new ArrayList<>();
        //graphics.setColor(randomColor());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new PlayerObject(new Player(input)));
        System.out.println("3");
        System.out.println("10");
        System.out.println("6");
        System.out.println("6");

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
