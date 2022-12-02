import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Display display;
    private List<GameObject> gameObject; //ArrayList af Objekter = GameObject
    private Input input; //Input fra brugeren
    private int width = 700;
    private int height = 500;

    public Game(){
        input = new Input();
        display = new Display(width,height, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        gameObject = new ArrayList<>();

        //Tilføjer objekter til gameObject ArrayListen
        gameObject.add(new PlayerObject(new Player(input)));
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());

        //Anvendes til kontrol
        System.out.println("GameObject Størrelse: " + gameObject.size());
        System.out.println(getGameObject());


    }

    //Metode til detection af hvorvidt firkanterne på displayet rammer hinanden
    public void detection( ) {
        //boolean hit = false;
//Der er noget der hedder bound, dette kan vi måske bruge
            for (int x = 1; x < gameObject.size(); x++) {
                if ((gameObject.get(x).getPosition().getX() >= gameObject.get(0).getPosition().getX()-15)
                &&  (gameObject.get(x).getPosition().getX() <= gameObject.get(0).getPosition().getX()+35)
                        && (gameObject.get(x).getPosition().getY()+20 >= gameObject.get(0).getPosition().getY())
                        && (gameObject.get(x).getPosition().getY()+20 <= gameObject.get(0).getPosition().getY()+30)
                        && (gameObject.get(x).getPosition().getX() +20 >= gameObject.get(0).getPosition().getX()-15)
                        && (gameObject.get(x).getPosition().getX() +20 <= gameObject.get(0).getPosition().getX()+ 35)
                ){
                    System.out.println(gameObject.get(x).getPosition().getX());
                    //System.out.println(gameObject.get(x).toString());
                    //System.out.println("PRICE: " + gameObject.get(x).getPrice().toString());
                    System.out.println(gameObject.toString());
                    System.out.println(x);
                    gameObject.remove(x); //Fjerner objektet -> Der bliver ramt
                    System.out.println(getGameObject()); //Print til konsol -> Se om objektet er fjernet fra arraylist


                }
            }
    }


    public void update(){
        gameObject.forEach(gameObject -> gameObject.update());
        detection();

    }



    public void render(){
        display.render(this);
    }

    public List<GameObject> getGameObject() {
        return gameObject;
    }
}
