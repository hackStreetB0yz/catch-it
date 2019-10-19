package hackstreet.catchit;

import java.awt.*;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Basket implements KeyboardHandler{

    private Picture picture;
    private GridPosition position;
    private Grid grid;
    private static final String PICTURELINK = "/home/amrit/Documents/repos/catch-it/pictures/basket.png";


    public Basket (Grid grid){

        position = new GridPosition(200,grid.getRows(), grid);
        this.grid = grid;

    }

    public void init(){

        picture = new Picture(grid.colToX(position.getCol()),grid.rowToY(position.getRow()-20),PICTURELINK);
        picture.draw();

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
        }
    }

    public void goRight(){

        if(getCol() < (grid.getCols()-(picture.getWidth()/grid.getCellSize()))) {
            position.setPos(position.getCol() + 10, grid.getRows());
            drawRight();
        }

    }

    public void drawLeft(){

        picture.translate(-30,0);

    }

    public void drawRight(){

        picture.translate(30, 0);

    }

    public int getWidthColums(){
        return 60; // returns width of picture in columns
    }

}
