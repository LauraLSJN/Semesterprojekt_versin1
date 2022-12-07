public class Size {


    private int gameObjectWidth;
    private int gameObjectHeight;
    private int displayWidth;
    private int displayHeight;


    public Size (){
        this.gameObjectHeight = 30;
        this.gameObjectWidth= 30;
        this.displayWidth = 700;
        this.displayHeight = 500;
    }


    public int getGameObjectWidth() {
        return gameObjectWidth;
    }

    public void setGameObjectWidth(int gameObjectWidth) {
        this.gameObjectWidth = gameObjectWidth;
    }

    public int getGameObjectHeight() {
        return gameObjectHeight;
    }

    public void setGameObjectHeight(int gameObjectHeight) {
        this.gameObjectHeight = gameObjectHeight;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

}