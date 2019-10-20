package hackstreet.catchit.gameEntities;

import hackstreet.catchit.grid.Grid;
import hackstreet.catchit.grid.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Basket implements KeyboardHandler {

    private static final String PICTURE_LINK = "/resources/basket.png";
    private static final int BASKET_COLUMN_SIZE = 200;
    private Picture picture;
    private GridPosition position;
    private Grid grid;


    public Basket(Grid grid) {

        position = new GridPosition(BASKET_COLUMN_SIZE, grid.getRows());
        this.grid = grid;
    }

    public void init() {

        picture = new Picture(grid.colToX(position.getCol()), grid.rowToY(position.getRow() - 20), PICTURE_LINK);
        picture.draw();
        basketKeyboard();
    }

    public void hide() {

        picture.delete();
    }


    public int getCol() {

        return position.getCol();
    }

    private void basketKeyboard() {

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

    public void goLeft() {

        if (getCol() > 0) {
            position.setPos(position.getCol() - 10, grid.getRows());
            drawLeft();
        }
    }

    public void goRight() {

        if (getCol() < (grid.getCols() - (picture.getWidth() / grid.getCellSize()))) {
            position.setPos(position.getCol() + 10, grid.getRows());
            drawRight();
        }

    }

    public void drawLeft() {

        picture.translate(-30, 0);

    }

    public void drawRight() {

        picture.translate(30, 0);

    }

    public int getWidthColumns() {
        return 60; // returns width of picture in columns
    }

}
