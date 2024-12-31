public class Cell {
    private final int x;
    private final int y;
    private Ship ship;

    public Cell(int x,int y) {
        this.x = x;
        this.y = y;
        this.ship = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell cell)) return false;
        return x == cell.x && y == cell.y;
    }
}
