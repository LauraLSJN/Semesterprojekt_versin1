public class Launch {

    public static void main(String[] args){
        //https://www.youtube.com/channel/UCow6EoWSXVRu5bgzLM-fBpw/videos
        //Display display = new Display(300,300);
        new Thread(new GameLoop(new Game())).start();

    }
}
