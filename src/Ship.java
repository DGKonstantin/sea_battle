public class Ship {

    int headX;
    char headY;

    int countDecks;
    boolean isVertical;
    Cell[] cells;

    public Ship(int headX, int headY, int countDecks, boolean isVertical) {
        this.countDecks = countDecks;
        this.isVertical = isVertical;
        cells = new Cell[countDecks];
        if (isVertical){
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headX, headY + 1);
                cells[i].isShip = true;
            }
        }else {
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headX + 1, headY);
                cells[i].isShip = true;
            }
        }
    }
}
