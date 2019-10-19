package hackstreet.catchit.gameobjects;

import hackstreet.catchit.GameObject;
import hackstreet.catchit.Grid;

public class Head3 extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 10; // the higher the slower..

    private static final String PICTURELINK = "/resources/steve-small.png";


    private static final int WIDTHCOLUMNS = 20;

    public Head3(Grid grid){

        super(POINTS,SPEED,grid, PICTURELINK,WIDTHCOLUMNS);

    }
}