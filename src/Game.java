import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Display display;
    private List<GameObject> gameObject;


    public Game(int width, int height){
        display = new Display(700,500);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        gameObject = new ArrayList<>();
        //graphics.setColor(randomColor());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new PlayerObject());
        System.out.println("3");
        System.out.println("10");

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
