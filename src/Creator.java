import java.util.Scanner;
public class Creator {
    private Scanner input; 
   public Creator() {
        this.input = new Scanner(System.in);
    }

    public Player[] getPlayers() {
        System.out.println("How many players are playing?:");
        int numPlayers = this.input.nextInt();
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("What is player " + i + "'s name: ");
            String name = this.input.nextLine();
            Player player = new Player(name);
            players[i] = player;
        }
        return players;
    }

    /*public Player getFirstPlayer(Player[] players) {
        int highestRoll = 0;
        Player highestPlayer = null;
        for (int i = 0; i < players.length; i++) {
            
            
        }
         > initialize highestRoll & highestPlayer
        > for loop: for player in players
            > roll for player 
            > if player is the first in the List
                > highestRoll = roll
                > highestPlayer = player
            > else 
                > if player rolled higher
                    > highestRoll = roll
                    > highestPlayer = player
                > else 
                    > continue
        return highestPlayer
    }*/
    
    public Board createBoard() {
        Board board = new Board();
        return board;
    }
}