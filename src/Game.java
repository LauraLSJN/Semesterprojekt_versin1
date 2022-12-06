import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game { //Game klassen - sætter de ting ind som vi skal bruge i vores spil. Det vigtigste her er de to lister
    private Display display;
    private List<GameObject> gameObject; //ArrayList af Objekter = GameObject
    private List<ShoppingBasket> shoppingBaskets;
    private List<Tid> tid;
    private Input input; //Input fra brugeren
    private int width = 700;
    private int height = 500;
    Random random = new Random();
    Size size;

    public Game() {
        input = new Input();
        display = new Display(width, height, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        //size = new Size(20,20);
        size = new Size();

        //Tid
        tid = new ArrayList<>();
        tid.add(new Tid());

        //Shoppingkurven
        shoppingBaskets = new ArrayList<>();
        shoppingBaskets.add(new ShoppingBasket());
        System.out.println("Test");

        //Food og Player
        gameObject = new ArrayList<>();
        gameObject.add(new PlayerObject(new Player(input))); //playerobject skal være index 0 for at detection virker
        addFoodObjects();

        //Anvendes til kontrol
        System.out.println("GameObject Størrelse: " + gameObject.size());
        System.out.println(getGameObject());


    }

    //Tilføjer foodObjects til gameObject arraylisten
    public void addFoodObjects() {
        gameObject.add(new FoodObjects());
        //gameObject.add(new FoodObjects());
        //gameObject.add(new FoodObjects());
    }

    //Dropper foodoOjects
    public void dropFoodObjects() {
        int randomTal = random.nextInt(2000);
        if (randomTal <= 25) {
            if (shoppingBaskets.get(0).nowCollectedFood != shoppingBaskets.get(0).maxValue) {
                addFoodObjects(); //Tilføjer nyt objekt til arrayliste hvis shoppingBasket ikke er lig maks
            } else {
                for (int i = 1; i < gameObject.size(); i++) {
                    gameObject.remove(i); //Fjerne dem der ikke er ramt fra ArrayListe

                }
            }

        }
    }

    //Metode til detection af hvorvidt firkanterne på displayet rammer hinanden
    public void detection() {
        for (int x = 1; x < gameObject.size(); x++) {
            if ((gameObject.get(x).getPosition().getX() >= (gameObject.get(0).getPosition().getX() - 30))
                    && (gameObject.get(x).getPosition().getX() <= (gameObject.get(0).getPosition().getX() + size.getGameObjectWidth() + 20))
                    && ((gameObject.get(x).getPosition().getY() + size.getGameObjectHeight()) >= gameObject.get(0).getPosition().getY())
                    && ((gameObject.get(x).getPosition().getY() + size.getGameObjectHeight()) <= (gameObject.get(0).getPosition().getY() + size.getGameObjectHeight() + 20))
                    && ((gameObject.get(x).getPosition().getX() + size.getGameObjectWidth()) >= (gameObject.get(0).getPosition().getX() - 35))
                    && ((gameObject.get(x).getPosition().getX() + size.getGameObjectWidth()) <= (gameObject.get(0).getPosition().getX() + size.getGameObjectWidth() + 30))
            ) {

                //SET
                shoppingBaskets.get(0).setCollectedFood(gameObject.get(x).getPrice().getValuePrice());
                //ADD
                shoppingBaskets.get(0).addCollectedFood(gameObject.get(x).getPrice().getValuePrice());

                System.out.println(gameObject.get(x).getPosition().getX());
                System.out.println(gameObject.toString());
                System.out.println(x);

                gameObject.remove(x); //Fjerner objektet -> Der bliver ramt
                System.out.println(getGameObject()); //Print til konsol -> Se om objektet er fjernet fra arraylist

            }
        }
    }

    public void detectionOutOfDisplay() {
        for (int i = 1; i < gameObject.size(); i++) {
            if (gameObject.get(i).getPosition().getY() >= gameObject.get(0).getPosition().getY() + 20) {
                gameObject.remove(i);
                //System.out.println(gameObject.toString()); //Anvendes til kontrol
            }

        }
    }

    public void update() {
        gameObject.forEach(gameObject -> gameObject.update());
        detectionOutOfDisplay();
        detection();
        dropFoodObjects();
        tid.forEach(tid -> tid.update());
    }

    public void render() {
        display.render(this);
    }

    public List<GameObject> getGameObject() {
        return gameObject;
    }

    public List<ShoppingBasket> getShoppingBaskets() {
        return shoppingBaskets;
    }

    public List<Tid> getTid() {
        return tid;
    }


}
