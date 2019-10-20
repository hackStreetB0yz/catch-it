package hackstreet.catchit;

import java.awt.*;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid{

    public static final int PADDING = 10;
    private int cellSize = 3;
    private int cols;
    private int rows;

    private Rectangle field;

    public Grid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;

    }

    public void init(){

        Rectangle rectangle = new Rectangle(PADDING,PADDING, cols*cellSize, rows*cellSize);
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
        return cellSize;
    }

    public int rowToY(int row){
        return (row*cellSize)+PADDING;
    }

    public int colToX(int col){
        return (col*cellSize)+PADDING;
    }
}
