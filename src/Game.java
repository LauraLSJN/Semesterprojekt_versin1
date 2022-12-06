import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game { //Game klassen - sætter de ting ind som vi skal bruge i vores spil. Det vigtigste her er de to lister
    private Display display;
    private List<GameObject> gameObject; //ArrayList af Objekter = GameObject
    private List<ShoppingBasket> shoppingBaskets;
    private Input input; //Input fra brugeren
    private int width = 700;
    private int height = 500;
    private boolean gameRunning = true;
    Random random = new Random();



    //private ShoppingBasket2 shoppingBasket2;
    //private ShoppingBasket shoppingBasket;

    public Game(){
        input = new Input();
        display = new Display(width,height, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        //shoppingBasket2 = new ShoppingBasket2();
        //Shoppingkurven
        shoppingBaskets = new ArrayList<>();
        shoppingBaskets.add(new ShoppingBasket());
        System.out.println("Test");

        //Food og Player
        gameObject = new ArrayList<>();
        gameObject.add(new PlayerObject(new Player(input))); //playerobject skal være index 0 for at detection virker
        addFoodObjects();


        /*
        //Tilføjer objekter til gameObject ArrayListen
        gameObject.add(new PlayerObject(new Player(input))); //playerobject skal være index 0 for at detection virker
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
*/
        //Anvendes til kontrol
        System.out.println("GameObject Størrelse: " + gameObject.size());
        System.out.println(getGameObject());



    }

    public void addFoodObjects(){
        //Tilføjer objekter til gameObject ArrayListen

            gameObject.add(new FoodObjects());
            //gameObject.add(new FoodObjects());
            //gameObject.add(new FoodObjects());
            //gameObject.add(new FoodObjects());
            //gameObject.add(new FoodObjects());



    }

    public void dropFoodObjects(){
        int randomTal = random.nextInt(2000); //Optimalt 5000
        if (randomTal <= 25){
            if(shoppingBaskets.get(0).nowCollectedFood != shoppingBaskets.get(0).maxValue){
                addFoodObjects();
            }

        }

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

                   // System.out.println("PRICE; " + gameObject.get(x).getPrice().getValuePrice());
                    shoppingBaskets.get(0).setCollectedFood(gameObject.get(x).getPrice().getValuePrice());

                    shoppingBaskets.get(0).addCollectedFood(gameObject.get(x).getPrice().getValuePrice());

                   // if(shoppingBaskets.get(0).nowCollectedFood != shoppingBaskets.get(0).maxValue){
                     //   addFoodObjects();
                    //}

                    System.out.println(gameObject.get(x).getPosition().getX());
                    //System.out.println(gameObject.get(x).toString());
                    //System.out.println("PRICE: " + gameObject.get(x).getPrice().toString());
                    System.out.println(gameObject.toString());
                    System.out.println(x);
                    //int price = gameObject.get(x).getPrice().getValuePrice();

                    //shoppingBaskets.add(price);
                    gameObject.remove(x); //Fjerner objektet -> Der bliver ramt
                    System.out.println(getGameObject()); //Print til konsol -> Se om objektet er fjernet fra arraylist

                }
            }
    }

    public void detectionOutOfDisplay(){
        for (int i = 1; i < gameObject.size(); i++) {
            if(gameObject.get(i).getPosition().getY() >= gameObject.get(0).getPosition().getY()){
                gameObject.remove(i);
                System.out.println(gameObject.toString());
                System.out.println("i er fjernet");
            }

        }
    }


    public void update(){ //bruger lamda expression igen
        gameObject.forEach(gameObject -> gameObject.update());
        detectionOutOfDisplay();
        detection();
        dropFoodObjects();
        shoppingBaskets.forEach(shoppingBasket -> shoppingBasket.update());
    }




    public void render(){
        display.render(this);
    }

    public List<GameObject> getGameObject() {
        return gameObject;
    }

    public List<ShoppingBasket> getShoppingBaskets() {
        return shoppingBaskets;
    }

    /*public ShoppingBasket2 getShoppingBasket2() {
        return shoppingBasket2;
    }*/

}
