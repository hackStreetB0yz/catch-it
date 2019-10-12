package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class GameObject {

    private int points;
    private int speed;
    private boolean caught;
    private GridPosition gridPosition;   // column 5, row 0 , grid
    private Grid grid;
    private Rectangle rectangle;

    public GameObject(int points, int speed, Grid grid){
        this.points = points;
        this.speed = speed;
        this.grid = grid;
        gridPosition = randomStartPosition();
    }

    protected void fall(){

        gridPosition.setPos(gridPosition.getCol(), gridPosition.getRow()+1);
        System.out.println(gridPosition.getRow());

    }



    public GridPosition randomStartPosition(){

        int startColumn = (int)Math.random()* grid.getCols();
        return new GridPosition(startColumn,0,grid);   /// column 5 , row 0 , grid

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




}
