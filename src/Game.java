import java.util.Scanner;
public class Game {
    private Scanner input;
    private Creator creator;
    private Board board;
    private Deck chanceDeck;
    private Deck chestDeck;
    private Player[] players;
    private int numHouses;
    private int numHotels;
    private int currentPlayerIndex;
    private Die die;

    public Game() {
        this.input = new Scanner(System.in);
        this.creator = new Creator(input);
        this.board = this.creator.createBoard();
        this.players = this.creator.getPlayers(board);
        CardManager.init(this, this.input);
        this.numHouses = 32;
        this.numHotels = 12;
        this.currentPlayerIndex = 0;
        this.die = new Die();
    }
    public Board getBoard() {
        return this.board;
    }

    /**
     * Move a player to a specific board index.
     * Pays GO $200 if the move passes GO (index wraps around).
     * This DOES NOT automatically trigger the landed-on space's action
     * (call that separately if you want), to avoid recursion from cards.
     */
    public void movePlayerToIndex(Player player, int newIndex) {
        if (player == null) return;

        final int BOARD_SIZE = 40;
        int currentIndex;
        try {
            currentIndex = player.getLocation();
        } catch (NullPointerException e) {
            currentIndex = 0;
        }

        boolean passedGo = newIndex < currentIndex; // wrapped around
        if (passedGo) {
            player.addMoney(200);
            System.out.println(player.getName() + " passed GO and collected $200!");
        }

        int normalized = ((newIndex % BOARD_SIZE) + BOARD_SIZE) % BOARD_SIZE;
        BoardSpace newSpace = board.getBoardSpace(normalized);
        player.setLocation(newSpace);

        System.out.println(player.getName() + " moved to space " + normalized + " (" + newSpace.getName() + ").");
    }

    /**
     * Send player to jail (index 10). Mark them as in-jail and reset jail-turns.
     * You should handle later logic for how to get out of jail (roll doubles / pay / card).
     */
    public void sendPlayerToJail(Player player) {
        if (player == null) return;

        int jailIndex = 10; // matches your Board setup
        BoardSpace jailSpace = board.getBoardSpace(jailIndex);
        player.setLocation(jailSpace);

        // mark player as in jail
        player.setInJail(true);
        player.setJailTurns(0);

        System.out.println(player.getName() + " was sent to Jail (space " + jailIndex + ").");
    }

    // deck getters so Property.getAction or Card.apply can access them
    public Deck getChanceDeck() {
        return this.chanceDeck;
    }
    public Deck getChestDeck() {
        return this.chestDeck;
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
        System.out.println(players[currentPlayerIndex].getName() + "'s turn!\nPress ENTER to roll the dice.");
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

            // perform landing action (may send to jail, draw cards, etc.)
            player.getAction(input);

            // If the landing/action sent the player to jail, the turn ends immediately.
            if (player.isInJail()) {
                // reset doubles so the loop won't continue
                doubles = false;
                break;
            }

            doubles = (die1 == die2);
            if (doubles) {
                doublesCount++;
                if (doublesCount == 3) {
                    System.out.println(player.getName() + " rolled doubles 3 times and goes to jail!");
                    // send player to jail (use Game helper)
                    sendPlayerToJail(player);
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
                    player.showProperties();
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
