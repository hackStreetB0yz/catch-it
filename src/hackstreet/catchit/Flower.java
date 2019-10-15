package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Flower extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 5;
    private static final String PICTURELINK = "/Users/codecadet/Documents/exercises/catch-it/pictures/flower2.jpg";
    public Flower(Grid grid){

        super(POINTS, SPEED, grid, PICTURELINK);

    }


}
