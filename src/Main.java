public class Main {
    public static void main(String[] args){
        Game game = new Game();
        game.createBoard(new int[][]{{1,2},{2,4},{3,9}});
        System.out.println(game.fireShot(1,0)); // Hit!
        System.out.println(game.fireShot(1,1)); // Hit!
        System.out.println(game.fireShot(1,2)); // Hit!
    }
}
