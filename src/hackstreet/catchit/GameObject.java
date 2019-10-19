package hackstreet.catchit;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private int points;
    private int speed;
    private GridPosition gridPosition;
    private Grid grid;
    private String pictureLink;
    private Picture picture;
    private int widthColumns;

    public GameObject(int points, int speed, Grid grid, String pictureLink, int widthColumns) {
        this.points = points;
        this.speed = speed;
        this.grid = grid;
        this.pictureLink = pictureLink;
        this.widthColumns = widthColumns;
    }

    protected void fall() {

        gridPosition.setPos(gridPosition.getCol(), gridPosition.getRow() + 1);
        if (gridPosition.getRow() < grid.getRows()) {
            picture.translate(0, grid.getCellSize());
            // System.out.println(gridPosition.getRow());
        }
        if (gridPosition.getRow() == (grid.getRows() - (picture.getHeight() / grid.getCellSize()))) {
            picture.delete();
        }

    }


    public GridPosition randomStartPosition() {

        int startColumn = (int) (Math.random() * (grid.getCols() - widthColumns)); // changed it
        // 60(width in pixels heads) / 3 (cellsize); "objects need 20 columns space"
        return new GridPosition(startColumn, 0, grid);

    }

    protected void init() {

        gridPosition = randomStartPosition();
        picture = new Picture(grid.colToX(gridPosition.getCol()), 10, pictureLink);
        picture.draw();

    }

    protected int getPoints() {

        return points;

    }

    public int getSpeed() {
        return speed;
    }

    public int getCol() {

        return gridPosition.getCol();

    }

    public int getWidthColumns() {
        return widthColumns;
    }
}

