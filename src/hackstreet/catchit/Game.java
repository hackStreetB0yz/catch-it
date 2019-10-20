package hackstreet.catchit;

import hackstreet.catchit.gameobjects.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;

public class Game implements KeyboardHandler {
    private Grid grid;
    private Basket basket;
    private GameObject[] gameObjects;
    private Thread[] threads;
    private Points points;
    private Picture gameBanner = new Picture(10,10,"/resources/background2.jpg");
    private Picture finishBanner = new Picture(10,10,"/resources/finish-banner-transparent.png");
    private Picture startBanner = new Picture(10, 10, "/resources/startscreen.jpg");
    private boolean enterPressed = false;


    public Game(int numberOfGameObjects) {

        grid = new Grid(400, 200);
        this.basket = new Basket(grid);
        points = new Points(grid);
        gameObjects = createGameObjects(numberOfGameObjects);
        threads = createThreads(numberOfGameObjects);

    }

    private GameObject[] createGameObjects(int numberOfGameObjects) {

        gameObjects = new GameObject[numberOfGameObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            int random = (int) (Math.random() * 10) + 1;
            if (random < 3) {
                gameObjects[i] = new Head(grid);
            } else if (random > 8) {
                gameObjects[i] = new Head2(grid);
            } else if (random > 6) {
                gameObjects[i] = new Head3(grid);
            } else {
                gameObjects[i] = new Head4(grid);
            }

        }
        return gameObjects;
    }

    private Thread[] createThreads(int numberOfObjects){
        threads = new Thread[numberOfObjects];
        for(int i = 0; i < numberOfObjects; i++){
            int finalI = i;
            threads[i] = new Thread(new Runnable(){public void run(){

                try {
                    gameObjects[finalI].init();
                    checkCatch(gameObjects[finalI]);
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }});
        }

        return threads;
    }


    public void initStart() throws InterruptedException {

        grid.init();
        startBanner();
        keyboard();
        while (!enterPressed) {
            Thread.sleep(10);
            if (enterPressed){
                init();
                break;
            }
        }
    }

    public void init() throws InterruptedException {

        gameBanner();
        basket.init();
        points.init();
        start();


    }


    public void start() throws InterruptedException {

        Thread.sleep(2000);

        int sleepTime = 700;
        for(Thread thread: threads) {
            thread.start();
            Thread.sleep(sleepTime);
        }
        Thread.sleep(1000); //wait until the last heads goes out
        basket.hide();
        finalBanner();
    }


    private void checkCatch(GameObject object) {

        if (basket.getCol() - object.getCol() > -basket.getWidthColums() && basket.getCol() - object.getCol() < object.getWidthColumns()) {

            points.updatePoints(object.getPoints());
        }

    }

    public void finalBanner(){
        finishBanner.draw();
    }

    public void startBanner(){
        startBanner.draw();

    }

    public void gameBanner() {
        gameBanner.draw();
    }

    public void keyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent enterPress = new KeyboardEvent();
        enterPress.setKey(KeyboardEvent.KEY_ENTER);
        enterPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(enterPress);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER) {

            System.out.println("Enter");

            try {
                enterPressed = true;

            } catch (Exception e) {
                System.out.println("exception:" + e);
            }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}






