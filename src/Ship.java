public class Ship {

    int headX;
    int headY;

    int taleX;
    int taleY;

    int countDecks;
    boolean isGorizontal;
    Cell[] cells;

    public Ship(int headX, int headY, int countDecks, boolean isGorizontal) {
        this.headX = headX;
        this.headY = headY;
        this.countDecks = countDecks;
        this.isGorizontal = isGorizontal;
        makeTale();
        makeCells();
    }

    private void makeTale(){
        if (this.isGorizontal){
            this.taleX = headX + countDecks;
            this.taleY = headY;
        }else {
            this.taleX = headX;
            this.taleY = headY + countDecks;
        }
    }

    private void makeCells(){
        this.cells = new Cell[countDecks];
        if (isGorizontal){
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headY, headX + i);
                cells[i].isShip = true;
            }
        }else {
            for (int i = 0; i < countDecks; i++) {
                cells[i] = new Cell(headY + i, headX);
                cells[i].isShip = true;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("X = %d, Y = %d, amount = %d, isGorizontal = %b", headX, headY, countDecks, isGorizontal);
    }
}
