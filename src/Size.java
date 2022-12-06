public class Size {


    private int gameObjectWidth;
    private int gameObjectHeight;


    public Size (){
        this.gameObjectHeight = 30;
        this.gameObjectWidth= 30;
    }

    /*public Size(int height, int width) { //int width, int height
        this.gameObjectWidth = width;
        this.gameObjectHeight = height;

    }*/

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

}