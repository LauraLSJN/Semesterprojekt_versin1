import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Display display;
    private List<GameObject> gameObject;
    private Input input;
    //private Position position;
   // protected FoodObjects foodObjects;
   // protected PlayerObject playerObject;
    //protected GameObject gameObjects;




    public Game(){
        input = new Input();
        display = new Display(700,500, input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500
        gameObject = new ArrayList<>();
        //graphics.setColor(randomColor());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());
        gameObject.add(new FoodObjects());

        System.out.println("GameObject Størrelse: " + gameObject.size());

    }


    public void detection( ) {
        int playerx = 0;
        int playery;
        int foodx;
        int foody;
        //int dist = gameObject.get(0).getPosition().getX()

        //Food y skal være på 480, ligesom at player altid står på 480
        // Food x og player x skal være det samme

        /*if(collision() == true){
            System.out.println("Sandt");
        }*/
            for (int x = 1; x < gameObject.size(); x++) {
                if ((gameObject.get(x).getPosition().getX() >= gameObject.get(0).getPosition().getX()-15)
                &&  (gameObject.get(x).getPosition().getX() <= gameObject.get(0).getPosition().getX()+35)
                        && (gameObject.get(x).getPosition().getY()+20 >= gameObject.get(0).getPosition().getY())
                        && (gameObject.get(x).getPosition().getY()+20 <= gameObject.get(0).getPosition().getY()+30)
                        && (gameObject.get(x).getPosition().getX() +20 >= gameObject.get(0).getPosition().getX()-15)
                        && (gameObject.get(x).getPosition().getX() +20 <= gameObject.get(0).getPosition().getX()+ 35)
                ){
                    System.out.println(gameObject.get(x).getPosition().getX());
                    System.out.println(gameObject.get(x).toString());
                    System.out.println(x);
                }

            /*    if((gameObject.get(0).getPosition().getX() == gameObject.get(1).getPosition().getX()
                        || gameObject.get(0).getPosition().getX()+20 == gameObject.get(1).getPosition().getX()+20)
                        && (gameObject.get(0).getPosition().getY() == gameObject.get(1).getPosition().getY()
                        || gameObject.get(0).getPosition().getY()+20 == gameObject.get(1).getPosition().getY()+20)){
                    System.out.println("Du har ramt ");
                }*/

               /* if (gameObject.get(0).getPosition().getY() == gameObject.get(1).getPosition().getY()
                        || gameObject.get(0).getPosition().getY()+20 == gameObject.get(1).getPosition().getY()+20){
                   System.out.println("Du har ramt - Y");
                }*/
                /*if ( gameObject.get(1).getPosition().getY() > 480 &&  gameObject.get(1).getPosition().getY() <500) {
                    System.out.println("Du har ramt på y aksen");
                }*/


                /*if (gameObject.get(0).getPosition().getX() == gameObject.get(x).getPosition().getX()
                        && getGameObject().get(x).getPosition().getY() == gameObject.get(0).getPosition().getY()){
                    System.out.println("hej");
                }*/
                //  System.out.println(gameObject.get(x).getPosition().getX());
                //    System.out.println(gameObject.get(x).getPosition().getY());

          /*  if (gameObject.get(x).equals(0)) {
                    System.out.println(gameObject.get(x).getPosition().getX());
                    System.out.println(gameObject.get(x).getPosition().getY());

                    playerx = gameObject.get(0).getPosition().getX();
                    playery= gameObject.get(0).getPosition().getY();

            }
            if (!gameObject.get(x).equals(0)){
                foodx = gameObject.get(x).getPosition().getX();
                foody= gameObject.get(x).getPosition().getY();

                if(foody == 0 && (foodx == playerx)){
                    System.out.println("test");
                }
            }*/


            }


            //foodObjects.
            //  System.out.println(gameObject.);
            // gameObject.forEach(gameObject1 -> System.out.println(position.getX() + " " + position.getY()));

            // System.out.println(this.playerObject);
            // System.out.println(playerObject.position.getX()+ " " + playerObject.position.getY());
            //  System.out.println(foodObjects.position.getX()+ " " + foodObjects.position.getY());

        /*while(getGameObject().size() <= 3){
            FoodObjects foodObjects = new FoodObjects();
            System.out.println(foodObjects.getxFood());
            System.out.println(foodObjects.getyFood());

            //PlayerObject playerObject = new PlayerObject();
            //System.out.println(playerObject.getxPlayer());
            //System.out.println(playerObject.getyPlayer());
        }*/


            // FoodObjects foodObjects = new FoodObjects();
            //  PlayerObject playerObject = new PlayerObject();


            //System.out.println("Den er ramt");
            //  System.out.println("xPlayer x: " + playerObject.getxPlayer());
            // System.out.println("yPlayer y:" + playerObject.getyPlayer());


            //  System.out.println("xFood x: " + foodObjects.getxFood());
            //   System.out.println("yFood y: " + foodObjects.getyFood() );



    }


    public void update(){
        gameObject.forEach(gameObject -> gameObject.update(
        ));
      detection();
      //collision();


    }



    public void render(){
        display.render(this);

    }

    public List<GameObject> getGameObject() {
        return gameObject;
    }
}
