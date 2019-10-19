package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head2 extends GameObject {

    private static final int POINTS = 80;
    private static final int SPEED = 8; // the higher the slower..
    // private static final String PICTURELINK = "/Users/codecadet/Documents/exercises/catch-it/pictures/flower2.jpg";
<<<<<<< HEAD
    private static final String PICTURELINK = "/home/amrit/Documents/repos/catch-it/pictures/steve.png";
=======
    private static final String PICTURELINK = "/Users/stevenduijvesteijn/Documents/bootcamp/hackstreet/catch-it/pictures/efthimis.png";
>>>>>>> a90ca3e905a95504b1643be07cd2bbd13f6bbd89
    private static final int WIDTHCOLUMNS = 30;

    public Head2(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}
