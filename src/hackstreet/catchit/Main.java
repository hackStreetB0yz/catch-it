package hackstreet.catchit;

import hackstreet.catchit.gameEntities.Game;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Game game = new Game(30);
        game.initStartScreen();
    }
}
