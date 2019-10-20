package hackstreet.catchit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(30);
        game.init();
        game.start();

    }
}
