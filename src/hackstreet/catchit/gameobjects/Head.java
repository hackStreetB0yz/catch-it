package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head extends GameObject {

    private static final int POINTS = -100;
    private static final int SPEED = 10; // the higher the slower..
    private static final String PICTURELINK = "/resources/efthimis-small.png";
    private static final int WIDTHCOLUMNS = 20; // pixels / cellsize;

    public Head(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}
