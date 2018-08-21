public class Cell {

    int x;
    int y;

    boolean isChecked;
    boolean isShip;
    boolean isBusy;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isChecked = false;
        isBusy = false;
        isShip = false;
    }


}
