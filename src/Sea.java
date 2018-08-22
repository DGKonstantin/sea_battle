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
        while (!paintShip(4)){}
    }

    private boolean paintShip(int countDescks){
        Ship ship = createShip(countDescks);
        System.out.println(ship.toString());
        for(Cell c : ship.cells){
            if (ship.taleX > cols - 1 || ship.taleY > rows - 1) return false;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    try{
                        if (sea[c.x + i][c.y + j].isEmpty){
                            return false;
                        }
                    }catch (Exception e){}
                }
            }
        }
        for(Cell c : ship.cells){
            sea[c.x][c.y] = c;
        }
        fillEmptyZones(ship);
        return true;
    }

    private void fillEmptyZones(Ship ship){
        for(Cell c : ship.cells){
            if (ship.isGorizontal){
                if (c.x > 0) sea[c.x - 1][c.y].isEmpty = true;
                if (c.x < cols) sea[c.x + 1][c.y].isEmpty = true;
                if (ship.headY > 0){
                    sea[c.x][c.y - 1].isEmpty = true;
                    if (ship.headX > 0) sea[c.x + 1][c.y].isEmpty = true;
                }
            }else {
                if (c.y > 0) sea[c.x][c.y - 1].isEmpty = true;
                if (c.y < rows) sea[c.x][c.y + 1].isEmpty = true;
            }
        }
    }

    private Ship createShip(int countDescks){
        int headX = -1;
        int headY = -1;
        while (headX < 0 || headY < 0){
            headX = (int) (Math.random() * 10) - countDescks;
            headY = (int) (Math.random() * 10) - countDescks;
        }
        return new Ship(headX, headY, countDescks, Math.random() < 0.5);
    }

    public void print(){
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                if (sea[i][j].isShip) System.out.print("S ");
                else if (sea[i][j].isEmpty)System.out.print("* ");
                else System.out.print("a ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
