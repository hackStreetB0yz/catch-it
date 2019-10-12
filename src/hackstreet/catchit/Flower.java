package hackstreet.catchit;

public class Flower extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 5;

    public Flower(Grid grid){

        super(POINTS, SPEED, grid);

    }


}
