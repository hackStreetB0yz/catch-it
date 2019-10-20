package hackstreet.catchit.grid;

public class GridPosition {

    private int col;
    private int row;

    public GridPosition(int col, int row) {

        this.col = col;
        this.row = row;
    }

    public void setPos(int col, int row) {

        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
