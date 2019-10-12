package hackstreet.catchit;

import java.awt.*;

public class Grid {

    public static final int PADDING = 10;
    private int cellSize = 20;
    private int cols;
    private int rows;

    private Rectangle field;

    public Grid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;

    }

    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
}
