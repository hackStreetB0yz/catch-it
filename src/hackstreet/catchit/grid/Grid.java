package hackstreet.catchit.grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private static final int PADDING = 10;
    private static final int CELL_SIZE = 3;
    private int cols;
    private int rows;

    public Grid(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        Rectangle rectangle = new Rectangle(PADDING, PADDING, cols * CELL_SIZE, rows * CELL_SIZE);
        rectangle.draw();
        rectangle.setColor(Color.DARK_GRAY);
        rectangle.fill();
    }


    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int rowToY(int row) {
        return (row * CELL_SIZE) + PADDING;
    }

    public int colToX(int col) {
        return (col * CELL_SIZE) + PADDING;
    }
}
