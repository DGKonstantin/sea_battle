public class Cell {

    int x;
    int y;

    boolean isChecked;
    boolean isShip;
    boolean isEmpty;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isChecked = false;
    }
}
