package hackstreet.catchit.gameEntities;

import hackstreet.catchit.gameEntities.gameobjects.GameObject;
import hackstreet.catchit.Main;
import hackstreet.catchit.gameEntities.gameobjects.*;
import hackstreet.catchit.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private Grid grid;
    private Basket basket;
    private GameObject[] gameObjects;
    private Thread[] threads;
    private Points points;
    private Picture gameBanner = new Picture(10, 10, "/resources/game-background.jpg");
    private Picture finishBanner = new Picture(10, 10, "/resources/finish-banner.png");
    private Picture startBanner = new Picture(10, 10, "/resources/start-banner.png");
    private boolean enterPressed = false;
    private boolean resetGame = false;


    public Game(int numberOfGameObjects) {

        grid = new Grid(400, 200);
        basket = new Basket(grid);
        points = new Points();
        gameObjects = createGameObjects(numberOfGameObjects);
        threads = createThreads(numberOfGameObjects);

    }

    private GameObject[] createGameObjects(int numberOfGameObjects) {

        gameObjects = new GameObject[numberOfGameObjects];

        for (int i = 0; i < gameObjects.length; i++) {

            int random = (int) (Math.random() * 10) + 1;

            if (random < 3) {

                gameObjects[i] = new Efthimis(grid);
            } else if (random > 8) {

                gameObjects[i] = new Amrit(grid);
            } else if (random > 6) {

                gameObjects[i] = new Steven(grid);
            } else {

                gameObjects[i] = new Vlady(grid);
            }

        }
        return gameObjects;
    }

    private Thread[] createThreads(int numberOfObjects) {
        threads = new Thread[numberOfObjects];
        for (int i = 0; i < numberOfObjects; i++) {
            int finalI = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {

                    try {
                        gameObjects[finalI].init();
                        checkCatch(gameObjects[finalI]);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            });
        }

        return threads;
    }


    public void initStartScreen() throws InterruptedException {

        grid.init();
        startBanner();
        startRestartKeyboard();
        while (!enterPressed) {
            Thread.sleep(10);
            if (enterPressed) {
                init();
                break;
            }
        }
    }

    private void init() throws InterruptedException {

        gameBanner();
        basket.init();
        points.init();
        start();
    }


    private void start() throws InterruptedException {

        Thread.sleep(2000);

        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(900);
        }
        Thread.sleep(1000); //wait until the last heads goes out
        basket.hide();
        finalBanner();
        startRestartKeyboard();
        while (!resetGame) {
            Thread.sleep(10);
            if (resetGame) {
                String[] strings = {""};
                Main.main(strings);
                break;
            }
        }
    }


    private void checkCatch(GameObject object) {

        if (basket.getCol() - object.getCol() > -basket.getWidthColumns() && basket.getCol() - object.getCol() < object.getWidthColumns()) {

            points.updatePoints(object.getPoints());
        }

    }

    private void finalBanner() {
        finishBanner.draw();
    }

    private void startBanner() {
        startBanner.draw();

    }

    private void gameBanner() {
        gameBanner.draw();
    }

    private void startRestartKeyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent enterPress = new KeyboardEvent();
        enterPress.setKey(KeyboardEvent.KEY_ENTER);
        enterPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent resetPress = new KeyboardEvent();
        resetPress.setKey(KeyboardEvent.KEY_R);
        resetPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(enterPress);
        keyboard.addEventListener(resetPress);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_ENTER) {
            enterPressed = true;
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            resetGame = true;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}






