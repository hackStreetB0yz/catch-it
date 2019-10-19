package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Flower extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 5; // the higher the slower..
   // private static final String PICTURELINK = "/Users/codecadet/Documents/exercises/catch-it/pictures/flower2.jpg";
    private static final String PICTURELINK = "/Users/stevenduijvesteijn/Documents/bootcamp/hackstreet/catch-it/pictures/flower2.jpg";
    private static final int WIDTHCOLUMNS = 10;

    public Flower(Grid grid){

        super(POINTS, SPEED, grid, PICTURELINK,WIDTHCOLUMNS);

    }



}
