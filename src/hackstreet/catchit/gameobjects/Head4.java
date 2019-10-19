package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head4 extends GameObject {

    private static final int POINTS = 80;
    private static final int SPEED = 5; // the higher the slower..
    private static final String PICTURELINK = "/resources/vlady.png";
    private static final int WIDTHCOLUMNS = 32;

    public Head4(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}