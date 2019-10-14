package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private int points;
    private int speed;
    private boolean caught;
    private GridPosition gridPosition;
    private Grid grid;
    private String pictureLink;
    private Picture picture;

    public GameObject(int points, int speed, Grid grid, String pictureLink){
        this.points = points;
        this.speed = speed;
        this.grid = grid;
        this.pictureLink = pictureLink;
        gridPosition = randomStartPosition();
    }

    protected void fall(){

        gridPosition.setPos(gridPosition.getCol(), gridPosition.getRow()+1);
        picture.translate(0,grid.getCellSize());
        System.out.println(gridPosition.getRow());

    }



    public GridPosition randomStartPosition(){

        int startColumn = (int) (Math.random()* grid.getCols()); // changed it
        System.out.println(grid.getCols());
        System.out.println(startColumn);
        return new GridPosition(startColumn,0,grid);

    }

    protected void init(){

        picture = new Picture(grid.colToX(gridPosition.getCol()), 10,pictureLink);
        picture.draw();

    }

    protected boolean isCaught(){

        return caught;

    }

    protected void setCaught(){

        this.caught = true;

    }

    protected int getPoints(){

        return points;

    }

    public int getCol(){

        return gridPosition.getCol();

    }




}
