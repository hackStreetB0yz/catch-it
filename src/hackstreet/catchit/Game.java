package hackstreet.catchit;

public class Game {

    private Grid grid;
    private Basket basket;
    private GameObject[] gameObjects;
    private Points points;


    public Game(int numberOfGameObjects) {

        grid = new Grid(400, 200);
        this.basket = new Basket(grid);
        points = new Points(grid);
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
        points.init();


    }



    public void start() throws InterruptedException {

        Thread.sleep(2000);

        for(GameObject gameObject: gameObjects){
            gameObject.init();
            this.fall(gameObject);
            checkCatch(gameObject);

        }

    }


    private void fall(GameObject object) throws InterruptedException{

        for (int x = 0; x < grid.getRows()-10; x++) {

            object.fall();
            Thread.sleep(20);

        }
    }

    private void checkCatch(GameObject object){

        //System.out.println("flower col:" + object.getCol());
        //System.out.println("basket col:" + basket.getCol());
        if (basket.getCol() - object.getCol() > -30 && basket.getCol() - object.getCol() < 10) {
            //difference can not be 10 or bigger.
            // 10 = number of rows calculated by dividing width(pixels) of picture by cellsize (30/3).
            points.updatePoints(object.getPoints());
        }

    }

}
