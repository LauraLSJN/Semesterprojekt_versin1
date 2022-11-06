import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<GameObject> gameObject;


    public Game(int width, int height){
        display = new Display(width,height);
        gameObject = new ArrayList<>();
        //graphics.setColor(randomColor());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new PlayerObject());

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
