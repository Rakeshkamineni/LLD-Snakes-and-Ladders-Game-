import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's Start the Game");

        System.out.println("Enter the Board Size");
        int boardSize = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the no of snakes");
        int noOfSnakes = Integer.parseInt(sc.nextLine());

        HashMap<Integer, Integer> snakesPositions = new HashMap<Integer, Integer>();
        for (int i = 0; i < noOfSnakes; i++) {
            String[] snakeArray = sc.nextLine().split(" ");
            int start = Integer.parseInt(snakeArray[0]);
            int end = Integer.parseInt(snakeArray[1]);
            snakesPositions.put(start, end);
        }
        System.out.println("Enter No of Ladders");
        int noOfLadders = Integer.parseInt(sc.nextLine());
        HashMap<Integer, Integer> laddersPositions = new HashMap<Integer, Integer>();

        for (int i = 0; i < noOfLadders; i++) {
            String[] ladderArray = sc.nextLine().split(" ");
            int start = Integer.parseInt(ladderArray[0]);
            int end = Integer.parseInt(ladderArray[1]);
            laddersPositions.put(start, end);
        }

        // Players input

        Queue<Player> playersQueue = new LinkedList<Player>();

        System.out.println("Enter number of players");
        int noOfplayers = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Players Name");
        for (int i = 0; i < noOfplayers; i++) {
            String name = sc.nextLine();
            Player p = new Player(name);
            playersQueue.add(p);
        }

        Board board = new Board(boardSize, snakesPositions, laddersPositions, playersQueue);
        board.letsStartGame();
    }
}
