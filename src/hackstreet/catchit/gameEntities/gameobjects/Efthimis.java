package hackstreet.catchit.gameEntities.gameobjects;

import hackstreet.catchit.grid.Grid;

public class Efthimis extends GameObject {

    private static final int POINTS = -100;
    private static final int SPEED = 10; // the higher the slower..
    private static final int WIDTH_COLUMNS = 20; // pixels / cell size;
    private static final String PICTURE_LINK = "/resources/efthimis-small.png";

    public Efthimis(Grid grid){

        super(POINTS,SPEED,grid, PICTURE_LINK, WIDTH_COLUMNS);
    }
}
