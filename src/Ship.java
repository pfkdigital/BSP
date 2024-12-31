import java.util.Set;

public class Ship {
    private int hits;
    private final Set<Cell> cells;

    public Ship(Set<Cell> cellCoordinates) {
        this.hits = 0;
        this.cells = cellCoordinates;
    }

    public boolean registerHit(int x, int y) {
        if (cells.contains(new Cell(x,y))) {
            hits ++;
            return true;
        }
        return false;
    }

    public boolean isSunk() {
        return hits >= cells.size();
    }

    @Override
    public String toString() {
        return "Ship{" +
                "hits=" + hits +
                ", cells=" + cells +
                '}';
    }
}