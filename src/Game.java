import enums.ShotResult;

public class Game {
    private Board board;

    public void createBoard(int[][] shipPositions){
        board = new Board();
        board.placeShips(shipPositions);
    }

    public String fireShot(int x, int y){
        ShotResult result = board.shoot(x,y);
        return switch (result) {
            case HIT -> "Hit!";
            case MISS -> "Miss!";
            case SUNK -> "Sunk!";
            case ALREADY_HIT -> "Already hit!";
            case OUT_OF_BOUNDS -> "Out of bounds!";
        };
    }
}
