import enums.ShotResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {
  private static final int SIZE = 10;
  private static final int shipLength = 3;
  private final Cell[][] boardGrid;
  private final List<Ship> ships = new ArrayList<>(3);

  public Board() {
    this.boardGrid = new Cell[SIZE][SIZE];
    createBoard();
  }

  public void createBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        boardGrid[i][j] = new Cell(i, j);
      }
    }
  }

  public void placeShips(int[][] shipPositions) {
    for (int[] position : shipPositions) {
      int topX = position[0];
      int topY = position[1];

      Set<Cell> derivedCells = getVerticalCells(topX, topY);
      Ship ship = new Ship(derivedCells);
      ships.add(ship);

      for (Cell c : derivedCells) {
        if (c.getShip() != null) {
          throw new IllegalArgumentException(
              String.format("Ship overlap detected at (%d,%d)", topX, topY));
        }
        c.setShip(ship);
      }
    }
  }

  public ShotResult shoot(int x, int y) {
      if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
          return ShotResult.OUT_OF_BOUNDS;
      }
      Cell cell = boardGrid[x][y];
      Ship ship = cell.getShip();

      if (ship == null) {
          return ShotResult.MISS;
      } else {
          boolean isHit = ship.registerHit(x,y);
          if (isHit) {
              return ship.isSunk() ? ShotResult.SUNK : ShotResult.HIT;
          }
          return ShotResult.ALREADY_HIT;
      }
  }

  private Set<Cell> getVerticalCells(int topX, int topY) {
    if (topX < 0 || topX >= 10 || topY < shipLength - 1 || topY >= SIZE) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid ship placement at (%d,%d). Three cell vertical ship does not fit",
              topX, topY));
    }
    return new HashSet<>(List.of(boardGrid[topX][topY], boardGrid[topX][topY - 1], boardGrid[topX][topY - 2]));
  }
}
