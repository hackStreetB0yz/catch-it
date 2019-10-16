package hackstreet.catchit;

import java.awt.*;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Basket implements KeyboardHandler{

    private int points;
    private Rectangle rectangle;
    private GridPosition position;
    private Grid grid;

    public Basket (Grid grid){

        this.points = 0;
        position = new GridPosition(200,grid.getRows(), grid);
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

        rectangle = new Rectangle(grid.colToX(position.getCol()), grid.rowToY(position.getRow()-10),90,30 );
        rectangle.draw();
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        Keyboard();
    }

    public GridPosition getPosition(){

        return position;

    }

    public int getCol(){

        return position.getCol();

    }

    public void Keyboard() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent leftArrowPress = new KeyboardEvent();
        leftArrowPress.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent rightArrowPress = new KeyboardEvent();
        rightArrowPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(leftArrowPress);
        keyboard.addEventListener(rightArrowPress);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                goLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                goRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void goLeft(){

        if(getCol() > 0) {
            position.setPos(position.getCol() - 10, grid.getRows());
            drawLeft();
            //System.out.println(getCol());
        }
    }

    public void goRight(){

        if(getCol() < (grid.getCols()-(rectangle.getWidth()/grid.getCellSize()))) {
            position.setPos(position.getCol() + 10, grid.getRows());
            drawRight();
            //System.out.println(getCol());
        }

    }

    public void drawLeft(){

        rectangle.translate(-30,0);

    }

    public void drawRight(){

        rectangle.translate(30, 0);

    }

}
