package hackstreet.catchit.gameEntities.gameobjects;

import hackstreet.catchit.grid.Grid;
import hackstreet.catchit.grid.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;

public abstract class GameObject {

    private int points;
    private int speed;
    private GridPosition gridPosition;
    private Grid grid;
    private String pictureLink;
    private int widthColumns;

    public GameObject(int points, int speed, Grid grid, String pictureLink, int widthColumns) {
        this.points = points;
        this.speed = speed;
        this.grid = grid;
        this.pictureLink = pictureLink;
        this.widthColumns = widthColumns;
    }


    private GridPosition randomStartPosition() {

        int startColumn = (int) (Math.random() * (grid.getCols() - widthColumns)); // changed it
        // 60(width in pixels heads) / 3 (cell size); "objects need 20 columns space"
        return new GridPosition(startColumn, 0);
    }

    public void init() throws InterruptedException {

        gridPosition = randomStartPosition();
        Picture picture = new Picture(grid.colToX(gridPosition.getCol()), 10, pictureLink);
        picture.draw();

        for (int x = 0; x < grid.getRows() - 10; x++) {

            gridPosition.setPos(gridPosition.getCol(), gridPosition.getRow() + 1);

            if (gridPosition.getRow() < grid.getRows() - 20) {

                try {

                    picture.translate(0, grid.getCellSize());
                } catch (ConcurrentModificationException c) {

                    //TEMPORARY FIX
                    picture.delete();
                    picture.draw();
                }
            }

            if (gridPosition.getRow() == (grid.getRows() - (picture.getHeight() / grid.getCellSize()))) {
                picture.delete();
                break;
            }

            Thread.sleep(speed);
        }

    }

    public int getPoints() {

        return points;
    }


    public int getCol() {

        return gridPosition.getCol();
    }

    public int getWidthColumns() {

        return widthColumns;
    }
}

