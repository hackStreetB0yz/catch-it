package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head3 extends GameObject {

    private static final int POINTS = 80;
    private static final int SPEED = 5; // the higher the slower..
    // private static final String PICTURELINK = "/Users/codecadet/Documents/exercises/catch-it/pictures/flower2.jpg";
    private static final String PICTURELINK = "/Users/stevenduijvesteijn/Documents/bootcamp/hackstreet/catch-it/pictures/amrit.png";
    private static final int WIDTHCOLUMNS = 32;

    public Head3(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}