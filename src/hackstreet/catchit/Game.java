package hackstreet.catchit;

import hackstreet.catchit.gameobjects.*;

public class Game {
    private Grid grid;
    private Basket basket;
    private GameObject[] gameObjects;
    private Thread[] threads;
    private Points points;


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
                    Thread.sleep(gameObjects[finalI].getSpeed());
                }catch (Exception e){
                    System.out.println(e);
                }
            }});
        }

        return threads;
    }

    public void init() {

        grid.init();
        basket.init();
        points.init();


    }


    public void start() throws InterruptedException {

        Thread.sleep(2000);

        int sleepTime = 2000;
        for(Thread thread: threads) {
            thread.start();
            Thread.sleep(sleepTime);
            //sleepTime += 100;
        }
    }


    private void fall(GameObject object) throws InterruptedException {

        for (int x = 0; x < grid.getRows() - 10; x++) {


            Thread.sleep(object.getSpeed());

        }
    }


    private void checkCatch(GameObject object) {

        if (basket.getCol() - object.getCol() > -basket.getWidthColums() && basket.getCol() - object.getCol() < object.getWidthColumns()) {

            points.updatePoints(object.getPoints());
        }

    }

}
