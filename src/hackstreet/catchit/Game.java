package hackstreet.catchit;

public class Game {

    private Grid grid;

    private Basket basket;

    private GameObject[] gameObjects;

    private int numberOfGameObjects;

    public Game(int numberOfGameObjects) {

        grid = new Grid(20, 20);
        this.basket = new Basket(grid);
        this.numberOfGameObjects = numberOfGameObjects;
        gameObjects = createGameObjects(numberOfGameObjects);

    }

    private GameObject[] createGameObjects(int numberOfGameObjects) {

        gameObjects = new GameObject[numberOfGameObjects];

        for (int i = 0; i < gameObjects.length; i++){

            gameObjects[i] = new Flower(grid);

        }

        return gameObjects;

    }

    public void start() throws InterruptedException {

        for(GameObject gameObject: gameObjects){

            this.fall(gameObject);

        }

    }


    private void fall(GameObject object) throws InterruptedException{

        for (int x = 0; x < grid.getRows(); x++) {

            object.fall();
            Thread.sleep(200);

        }
    }

}
