import java.util.Scanner;
public class Creator {
    private Scanner input; 
    private Die die;

    public Creator(Scanner input) {
        this.input = input;
        this.die = new Die();
    }

    public Player[] getPlayers(Board board) {
        System.out.println("How many players are playing?:");
        int numPlayers = this.input.nextInt();
        input.nextLine();
        System.out.println("number of players:" + numPlayers);
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("What is player " + (i+1) + "'s name: ");
            String name = this.input.nextLine();
            Player player = new Player(name);
            player.setLocation(board.getBoardSpace(0));
            players[i] = player;
        }
        return players;
    }

    public Player getFirstPlayer(Player[] players) {
        //initialize highestRoll & highestPlayer
        int highestRoll = 0;
        Player highestPlayer = null;
        for (int i = 0; i < players.length; i++) {
            Player playerRolling = players[i];
            if (i == 0) {
                highestPlayer = playerRolling;
                highestRoll = die.roll() + die.roll();
            }
            else { 
                int playersRoll = die.roll() + die.roll();
                if (playersRoll > highestRoll) {
                    highestPlayer = playerRolling;
                    highestRoll = playersRoll;
                }
            }
        }
        System.out.println(highestPlayer.getName() + " will go first!\n");
        return highestPlayer;
    }
    
    public Board createBoard() {
        Board board = new Board();
        return board;
    }
}