package hackstreet.catchit;

public class Game {

    private Grid grid;
    private Basket basket;
    private GameObject[] gameObjects;
    private int points;


    public Game(int numberOfGameObjects) {

        grid = new Grid(400, 200);
        this.basket = new Basket(grid);
        gameObjects = createGameObjects(numberOfGameObjects);

    }

    private GameObject[] createGameObjects(int numberOfGameObjects) {

        gameObjects = new GameObject[numberOfGameObjects];

        for (int i = 0; i < gameObjects.length; i++){

            gameObjects[i] = new Flower(grid);

        }

        return gameObjects;

    }

    public void init() {

        grid.init();
        basket.init();


    }



    public void start() throws InterruptedException {

        Thread.sleep(2000);

        for(GameObject gameObject: gameObjects){
            gameObject.init();
            this.fall(gameObject);
            checkCatch(gameObject);
            System.out.println(points);

        }

    }


    private void fall(GameObject object) throws InterruptedException{

        for (int x = 0; x < grid.getRows()-10; x++) {

            object.fall();
            Thread.sleep(20);

        }
    }

    private void checkCatch(GameObject object){

        if(Math.abs(basket.getCol()-object.getCol()) <= 30){    //calculate again
            points += object.getPoints();
        }

    }

}
