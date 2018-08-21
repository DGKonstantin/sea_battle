public class Sea {

    Ship[] ships;
    Cell[][] sea;
    final int rows = 10;
    final int cols = 10;

    public Sea(){
        sea = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sea[i][j] = new Cell(i, j);
            }
        }
        createShips();
    }

    private void createShips(){
        int countShips = 10;
        while (countShips != 0){
            print();
            if (countShips == 10){
                paintShip(4);
            countShips--;
            }else if (countShips == 9){
                while (countShips != 7){
                    paintShip(3);
                }
            }else if(countShips == 7){
                while (countShips != 4){
                    paintShip(2);
                }
            }else paintShip(1);
        }
    }

    private void paintShip(int countDescks){
        Ship ship = createShip(countDescks);
        for(Cell c : ship.cells){
            if (c.x > 9 || c.y > 9){
                paintShip(countDescks);
                break;
            }
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    try{
                        if (sea[c.x + i][c.y + j].isBusy){
                            paintShip(countDescks);
                            break;
                        }
                    }catch (Exception e){}
                }
            }
        }
        for(Cell c : ship.cells){
            //System.out.println(c.x + " " + c.y);
            sea[c.x][c.y] = c;
        }
        for(Cell c : ship.cells){
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    try{
                        sea[c.x + i][c.y + j].isBusy = true;
                    }catch (Exception e){}
                }
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
                else if (sea[i][j].isBusy)System.out.print("* ");
                else System.out.print("a ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
