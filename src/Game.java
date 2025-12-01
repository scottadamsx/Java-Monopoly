import java.util.Scanner;
public class Game {
    private Creator creator;
    private Board board;
    private Player[] players;
    private int numHouses;
    private int numHotels;
    private int currentPlayerIndex;
    private Die die;
    private Scanner input;

    public Game() {
        this.input = new Scanner(System.in);
        this.creator = new Creator(input);
        this.board = this.creator.createBoard();
        this.players = this.creator.getPlayers(board);
        this.numHouses = 32;
        this.numHotels = 12;
        this.currentPlayerIndex = 0;
        this.die = new Die();
        
    }

    public Player start() {
        while (players.length > 1) {
            Player player = players[currentPlayerIndex];

            takeTurn(player);
            afterTurnMenu(player);

            switchPlayer();
        }

        // Winner is the last remaining player
        Player winner = players[0];
        System.out.println("Winner is " + winner.getName() + "!");
        return winner;
    }
    public void movePlayer(Player player, int roll) {
        if (player == null) {
            throw new IllegalArgumentException("player must not be null");
        }

        // Default Monopoly board size — change this if your Board uses a different size
        final int BOARD_SIZE = 40;

        // Defensive: ensure player has a valid starting location
        int currentIndex;
        try {
            currentIndex = player.getLocation(); // uses BoardSpace.getLocation()
        } catch (NullPointerException e) {
            // If location is null, put player on 0 (GO)
            currentIndex = 0;
            player.setLocation(board.getBoardSpace(0));
            System.out.println(player.getName() + " had no location; placed on GO (0).");
        }

        int rawNewIndex = currentIndex + roll;
        boolean passedGo = rawNewIndex >= BOARD_SIZE;      // true if they crossed or landed past last index
        int newIndex = rawNewIndex % BOARD_SIZE;           // wrap-around

        if (passedGo) {
            player.addMoney(200);
            System.out.println(player.getName() + " passed GO and collected $200!");
        }

        BoardSpace newSpace = board.getBoardSpace(newIndex);
        player.setLocation(newSpace);

        System.out.println(player.getName() + " moved from space " + currentIndex
                + " to space " + newIndex + " (" + newSpace.getName() + ").");
    }



    private void waitForEnterToRoll() {
    while (true) {
        System.out.println("Press ENTER to roll the dice (press only Enter).");
        String line = input.nextLine();
        if (line == null) {
            return; 
        }
        if (line.trim().isEmpty()) {
            return; 
        }
        System.out.println("Please press only ENTER to roll. (If you typed something earlier, that input was consumed.)");
        }
    }

    private void takeTurn(Player player) {
        int doublesCount = 0;
        boolean doubles;

        do {
            // Block until user actually presses ENTER (empty line).
            waitForEnterToRoll();

            int die1 = die.roll();
            int die2 = die.roll();
            int playerRoll = die1 + die2;
            System.out.println(player.getName() + " rolled " + die1 + " and " + die2 + " / Total: " + playerRoll);

            movePlayer(player, playerRoll);

            // Make sure Player.getAction uses nextLine() internally too
            player.getAction(input);

            doubles = (die1 == die2);
            if (doubles) {
                doublesCount++;
                if (doublesCount == 3) {
                    System.out.println(player.getName() + " rolled doubles 3 times and goes to jail!");
                    // TODO: send player to jail
                    break;
                } else {
                    System.out.println("Doubles! " + player.getName() + " gets another roll.");
                }
            }
        } while (doubles);
    }

    private void afterTurnMenu(Player player) {
        boolean exitMenu = false;
        

        while (!exitMenu) {
            System.out.println("Choose an option:");
            System.out.println("1. Buy Houses");
            System.out.println("2. Sell Houses");
            System.out.println("3. Check Properties");
            System.out.println("4. Make Trade");
            System.out.println("[ENTER]. End Turn");

            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    // TODO: implement buy houses
                    break;
                case "2":
                    // TODO: implement sell houses
                    break;
                case "3":
                    // TODO: display player properties
                    break;
                case "4":
                    // TODO: implement trading
                    break;
                case "":
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.length) {
            currentPlayerIndex = 0;
        }
    }
}
