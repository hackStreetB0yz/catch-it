package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head2 extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 10; // the higher the slower..
    private static final String PICTURELINK = "/resources/amrit-small.png";


    private static final int WIDTHCOLUMNS = 20;

    public Head2(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}
