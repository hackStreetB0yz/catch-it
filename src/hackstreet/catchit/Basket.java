package hackstreet.catchit;

import java.awt.*;

public class Basket {

    private int points;
    private Rectangle rectangle;
    private GridPosition position;

    public Basket (Grid grid){

        this.points = 0;
        position = new GridPosition(10,20, grid);

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

    public GridPosition getPosition(){

        return position;

    }

}
