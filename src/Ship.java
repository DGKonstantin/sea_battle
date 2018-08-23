public class Ship {

    int headX;
    int headY;

    public int taleX;
    public int taleY;

    int countDecks;
    boolean isVertical;
    Cell[] cells;

    public Ship(int headX, int headY, int countDecks, boolean isVertical) {
        this.headX = headX;
        this.headY = headY;
        this.countDecks = countDecks;
        this.isVertical = isVertical;
        makeTale();
        this.cells = makeCells();
    }

    private void makeTale(){
        if (this.isVertical){
            this.taleX = headX;
            this.taleY = headY + countDecks - 1;
        }else {
            this.taleX = headX + countDecks - 1;
            this.taleY = headY;
        }
    }

    private Cell[] makeCells(){
        Cell[] cells = new Cell[countDecks];
        if (isVertical){
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headX, headY + i);
                cells[i].isShip = true;
            }
        }else {
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headX + i, headY);
                cells[i].isShip = true;
            }
        }
        return cells;
    }

    @Override
    public String toString() {
        return String.format("X = %d, Y = %d, amount = %d, isVertical = %b", headX, headY, countDecks, isVertical);
    }
}
