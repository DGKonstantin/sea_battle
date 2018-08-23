
import java.util.LinkedList;
import java.util.List;

public class Sea {

    Ship[] ships;
    Cell[][] sea;
    final int rows = 10;
    final int cols = 10;

    public Sea(){
        sea = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sea[j][i] = new Cell(i, j);
            }
        }
        createShips();
    }

    private void createShips(){
        int count = 0;

        while (!paintShip(4)){count++;};
        while (!paintShip(3)){count++;};
        while (!paintShip(3)){count++;};
        while (!paintShip(2)){count++;};
        while (!paintShip(2)){count++;};
        while (!paintShip(2)){count++;};
        while (!paintShip(1)){count++;};
        while (!paintShip(1)){count++;};
        while (!paintShip(1)){count++;};
        while (!paintShip(1)){count++;};
        print();
        System.out.println(count);
/*

        */
    }

    private boolean paintShip(int countDescks){
        Ship ship = createShip(countDescks);
        System.out.println(ship.toString());
        for(Cell c : ship.cells){
            if (ship.taleX > cols - 1 || ship.taleY > rows - 1) return false;
            if (sea[c.x][c.y].isEmpty) return false;
        }
        for(Cell c : ship.cells){
            sea[c.x][c.y] = c;
        }
        fillEmptyZones(ship);
        System.out.println(ship.toString());
        return true;
    }

    private void fillEmptyZones(Ship ship){
        if (ship.isVertical){
            if (ship.headY > 0){
                sea[ship.headX][ship.headY - 1].isEmpty = true;
                if (ship.headX > 0) sea[ship.headX - 1][ship.headY - 1].isEmpty = true;
                if (ship.headX < rows - 1) sea[ship.headX + 1][ship.headY - 1].isEmpty = true;
            }
            if (ship.taleY < rows - 1){
                sea[ship.taleX][ship.taleY + 1].isEmpty = true;
                if (ship.taleX > 0) sea[ship.taleX - 1][ship.taleY + 1].isEmpty = true;
                if (ship.taleX < rows - 1) sea[ship.taleX + 1][ship.taleY + 1].isEmpty = true;
            }
            for (Cell c : ship.cells){
                if (c.x > 0) sea[c.x - 1][c.y].isEmpty = true;
                if (c.x < cols - 1) sea[c.x + 1][c.y].isEmpty = true;
            }
        }else {
            if (ship.headX > 0){
                sea[ship.headX - 1][ship.headY].isEmpty = true;
                if (ship.headY > 0) sea[ship.headX - 1][ship.headY - 1].isEmpty = true;
                if (ship.headY < rows - 1) sea[ship.headX - 1][ship.headY + 1].isEmpty = true;
            }
            if (ship.taleX < rows - 1){
                sea[ship.taleX + 1][ship.taleY].isEmpty = true;
                if (ship.taleY > 0) sea[ship.taleX + 1][ship.taleY - 1].isEmpty = true;
                if (ship.taleY < rows - 1) sea[ship.taleX + 1][ship.taleY + 1].isEmpty = true;
            }
            for (Cell c : ship.cells){
                if (c.y > 0) sea[c.x][c.y - 1].isEmpty = true;
                if (c.y < rows - 1) sea[c.x][c.y + 1].isEmpty = true;
            }
        }
    }

    private Ship createShip(int countDescks){
        int headX = -1;
        int headY = -1;
        boolean isVertical = Math.random() < 0.5;
        while (headX < 0 || headY < 0){
            Cell cell = getFreeCells().get((int) (Math.random() * getFreeCells().size()));
            if (!isVertical) {
                headX = cell.x - countDescks;
                headY = cell.y;
            }
            else {
                headX = cell.x;
                headY = cell.y - countDescks;
            }
        }
        return new Ship(headX, headY, countDescks, isVertical);
    }

    private List<Cell> getFreeCells(){
        List<Cell> list = new LinkedList<Cell>();
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                if (!sea[j][i].isEmpty && !sea[j][i].isShip) list.add(sea[j][i]);
            }
        }
        return list;
    }

    public void print(){
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                if (sea[j][i].isShip) System.out.print("S ");
                else if (sea[j][i].isEmpty)System.out.print("* ");
                else System.out.print("a ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
