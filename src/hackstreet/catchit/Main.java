package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        Game game = new Game(60);
        game.init();
        game.start();

    }
}
