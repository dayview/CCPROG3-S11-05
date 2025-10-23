package konbini.models;

/**
 * ShelfLocation class representing physical location of products in the store
 * Manages shelf organization with row and column positioning
 * @author Leon Pavino
 * @version 1.1
 */
public class ShelfLocation {
    private String shelfID;
    private int row;
    private int col;

    /**
     * Constructor for ShelfLocation
     * @param shelfID Unique shelf identifier
     * @param row Row number on shelf
     * @param col Column number on shelf
     */
    public ShelfLocation(String shelfID, int row, int col) {
        this.shelfID = shelfID;
        this.row = row;
        this.col = col;
    }

    public String getShelfID() {
        return shelfID;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setShelfID(String shelfID) {
        this.shelfID = shelfID;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return String.format("Shelf %s [R%d-C%d]", shelfID, row, col);
    }
}
