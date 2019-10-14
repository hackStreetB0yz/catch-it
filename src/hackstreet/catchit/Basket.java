package hackstreet.catchit;

import java.awt.*;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Basket {

    private int points;
    private Rectangle rectangle;
    private GridPosition position;
    private Grid grid;

    public Basket (Grid grid){

        this.points = 0;
        position = new GridPosition(grid.getCols()/2,grid.getRows(), grid);
        this.grid = grid;

    }

    public void setPoints(int points){

        this.points += points;

    }

    public void move(){         // receives a direction and will call move(right) or move(left)

        //TODO

    }

    public void setPosition(int col, int row){

        position.setPos(col, row);
        System.out.println(this.position);

    }

    public void init(){

        rectangle = new Rectangle(grid.colToX(position.getCol()-1), grid.rowToY(position.getRow()-1),90,30 );
        rectangle.draw();
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
    }

    public GridPosition getPosition(){

        return position;

    }

    public int getCol(){

        return position.getCol();

    }

}
