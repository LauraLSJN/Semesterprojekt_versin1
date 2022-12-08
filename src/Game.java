import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.font.TextAttribute;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game { //Game klassen - sætter de ting ind som vi skal bruge i vores spil. Det vigtigste her er de to lister
    private Display display;
    private List<GameObject> gameObject; //ArrayList af Objekter = GameObject
    private List<ShoppingBasket> shoppingBaskets;
    private List<Tid> tid;
    private Input input; //Input fra brugeren
    Random random = new Random();
    Size size;
    private boolean stopDrop;

    AttributedString attributedText;
    Font font = new Font("Monospaced", Font.BOLD, 15);
    Level level;

    boolean won;
    boolean lost;

//boolean test = false;

    public Game() {
        this.won = false;
        this.lost = false;

        //this.test = false;
        this.stopDrop = false;
        level = new Level();

        input = new Input();
        size = new Size();
        display = new Display(size.getDisplayWidth(), size.getDisplayHeight(), input);//aendret fra w h Skærmstørrelse 700x500 x: 700, y:500

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
        if(this.stopDrop != true && randomTal <= 25) {
                addFoodObjects();
        }
    }

    public void removeFoodObjects(){
            for (int i = 1; i < gameObject.size(); i++) {
                gameObject.remove(i); //Fjerne dem der ikke er ramt fra ArrayListe
                level.setNextLevel(1);
                // removeAllFoodObjects();
                tid.get(0).stopTid();
            }
        }

        public void checkStop(){
            if (shoppingBaskets.get(0).nowCollectedFood == shoppingBaskets.get(0).maxValue) {
                //addFoodObjects(); //Tilføjer nyt objekt til arrayliste hvis shoppingBasket ikke er lig maks
                this.stopDrop = true;
                removeFoodObjects();
                setTest(true);
            }

            if(tid.get(0).getMinSecond() == 0 && tid.get(0).getSecond() == 0 && tid.get(0).getMinute() == 0){
                this.stopDrop = true;
                removeFoodObjects();
                setLost(true);
                //setTest(true);
            }

        }



        /*
        //vi kunne lave metode her i stedet for else.
    public void removeAllFoodObjects(){
        for (int i = 1; i < gameObject.size(); i++) {
            gameObject.remove(i); //Fjerne dem der ikke er ramt fra ArrayListe
        }
    }*/

    //Metode til detection af hvorvidt firkanterne på displayet rammer hinanden
    public void detection() {
        for (int x = 1; x < gameObject.size(); x++) {
            if ((gameObject.get(x).getPosition().getX() >= (gameObject.get(0).getPosition().getX() - 30)) // food x >= player x - 30
                    && (gameObject.get(x).getPosition().getX() <= (gameObject.get(0).getPosition().getX() + size.getPlayerObjectWidth() + 20)) //food x <= player x+ size + 20
                    && ((gameObject.get(x).getPosition().getY() + size.getFoodObjectHeight()) >= gameObject.get(0).getPosition().getY()+5) // food y + size >= player y +5
                    && ((gameObject.get(x).getPosition().getY() + size.getFoodObjectHeight()) <= (gameObject.get(0).getPosition().getY() + size.getPlayerObjectHeight() + 20)) //food y <= player y + size + 20
                    && ((gameObject.get(x).getPosition().getX() + size.getFoodObjectWidth()) >= (gameObject.get(0).getPosition().getX() - 35)) //food x + size >= player x -35
                    && ((gameObject.get(x).getPosition().getX() + size.getFoodObjectWidth()) <= (gameObject.get(0).getPosition().getX() + size.getFoodObjectWidth() + 60)) //food x + size <= player x + size + 60
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
               // this.test = true;

            }

        }
    }

    public void detectionOutOfDisplay() {
        for (int i = 1; i < gameObject.size(); i++) {
            if (gameObject.get(i).getPosition().getY() >= gameObject.get(0).getPosition().getY()+ size.getPlayerObjectHeight()) { //food y >= player y + player height
                gameObject.remove(i);
            }

        }
    }

    public void update() {
        gameObject.forEach(gameObject -> gameObject.update());
        detectionOutOfDisplay();
        detection();
        checkStop();
        dropFoodObjects();
        //tid.get(0).update();


        tid.forEach(tid -> tid.update()); //Find retur værdi


        level.detectLevel();
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

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(300, 300, 100, 100);
        setText(graphics, "TEST", 0, 0);
        graphics.dispose();
        return image;
    }

    //Price i firkanten
    //https://www.baeldung.com/java-add-text-to-image
    public void setText(Graphics2D graphics, String text, int x, int y) {
        attributedText = new AttributedString(text);
        attributedText.addAttribute(TextAttribute.FONT, font); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.RED); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), x, y); //Placeres i billede -> X og y kordinat er i henhold til image
    }

   /* public boolean isTest() {
        return test;
    }*/

   /* public void setTest(boolean test) {
        this.test = test;
    }*/


    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }


//Liste/Dictionary -> i Game klasse -> Det første i listen (indeks 0) -> Første settings, som skal gælde for første level
    //Indeks 1 -> Næste level med de værdier som skal sættes
    //Game klasse -> Variabel currentLevel -> Når man taber, level op, og når man vinder level op
    //


}
