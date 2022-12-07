import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.font.TextAttribute;

public class Game { //Game klassen - sætter de ting ind som vi skal bruge i vores spil. Det vigtigste her er de to lister
    private Display display;
    private List<GameObject> gameObject; //ArrayList af Objekter = GameObject
    private List<ShoppingBasket> shoppingBaskets;
    private List<Tid> tid;
    private Input input; //Input fra brugeren
    Random random = new Random();
    Size size;
    AttributedString attributedText;
    Font font = new Font("Monospaced", Font.BOLD, 15);


    boolean test = false;

    public Game() {
        this.test = false;

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
       if (test){
           test = false;
       }

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
               setTest(true);
               // this.test = true;

            }

        }
    }

    public void detectionOutOfDisplay() {
        for (int i = 1; i < gameObject.size(); i++) {
            if (gameObject.get(i).getPosition().getY() >= gameObject.get(0).getPosition().getY()+ size.getPlayerObjectHeight()) { //food y >= player y + player height
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

    public Image getSprite() {
        BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(100, 100, 100, 100);
        setText(graphics, "TEST", 100, 100);
        graphics.dispose();
        return image;
    }

    //Price i firkanten
    //https://www.baeldung.com/java-add-text-to-image
    public void setText(Graphics2D graphics, String text, int x, int y) {
        attributedText = new AttributedString(text);
        attributedText.addAttribute(TextAttribute.FONT, font); //Font
        attributedText.addAttribute(TextAttribute.FOREGROUND, Color.BLACK); //Sættes til foreground + farve = hvid
        graphics.drawString(attributedText.getIterator(), x, y); //Placeres i billede -> X og y kordinat er i henhold til image
    }

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }


}
