import java.util.*;

class Board {
    private int boardSize;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private Queue<Player> playersQueue;

    Board(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, Queue<Player> playersQueue) {
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playersQueue = playersQueue;
    }

    public void letsStartGame() {
        while (true) {
            Player play = playersQueue.poll();
            int prevPosition = play.getPlayerPosition();
            int newPosition = prevPosition + Dice.roll();
            if (newPosition <= boardSize) {
                if (snakes.containsKey(newPosition)) {
                    newPosition = snakes.get(newPosition);
                    System.out.println(
                            play.getPlayerName() + " was bitten by a Snake and moved backward to " + newPosition);
                } else if (ladders.containsKey(newPosition)) {
                    newPosition = ladders.get(newPosition);
                    System.out.println(play.getPlayerName() + " claimed a ladder and moved forward to " + newPosition);
                } else {
                    System.out.println(play.getPlayerName() + " rolled a dice moved from " + prevPosition + " to "
                            + newPosition);
                    prevPosition = newPosition;
                }
                if (newPosition == boardSize) {
                    System.out.println(play.getPlayerName() + " won the game");
                    break;
                }
                play.setPlayerPosition(newPosition);
                playersQueue.add(play);
            }
        }
    }

    public Queue<Player> getPlayerturns() {
        return playersQueue;
    }

    public void setPersons(Queue<Player> playersQueue) {
        this.playersQueue = playersQueue;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public int getboardSize() {
        return boardSize;
    }
}
