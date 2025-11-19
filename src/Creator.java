import java.util.Scanner;
public class Creator {
    private Scanner input; 
   public Creator(Scanner input) {
        this.input = input;
    }

    public Player[] getPlayers(Board board) {
        System.out.println("How many players are playing?:");
        int numPlayers = this.input.nextInt();
        input.nextLine();
        System.out.println("number of players:" + numPlayers);
        Player[] players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("What is player " + (i+1) + "'s name: ");
            String name = this.input.next();
            Player player = new Player(name);
            player.setLocation(board.getBoardSpace(0));
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