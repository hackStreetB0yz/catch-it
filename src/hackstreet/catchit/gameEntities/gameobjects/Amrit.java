package hackstreet.catchit.gameEntities.gameobjects;

import hackstreet.catchit.grid.Grid;

public class Amrit extends GameObject {

    private static final int POINTS = 50;
    private static final int SPEED = 10; // the higher the slower..
    private static final int WIDTH_COLUMNS = 20;
    private static final String PICTURE_LINK = "/resources/amrit-small.png";

    public Amrit(Grid grid){

        super(POINTS,SPEED,grid, PICTURE_LINK, WIDTH_COLUMNS);
    }
}
