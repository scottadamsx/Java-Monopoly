public class Game {
    private Creator creator;
    private Board board;
    private Player[] players;
    private int numHouses;
    private int numHotels;
    private int currentPlayerIndex;
    private Die die;

    public Game() {
        this.creator = new Creator();
        this.board = this.creator.createBoard();
        this.players = this.creator.getPlayers();
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

    private void takeTurn(Player player) {
        int doublesCount = 0;
        boolean doubles;

        do {
            // Player rolls dice
            int die1 = die.roll();
            int die2 = die.roll();
            System.out.println(player.getName() + " rolled " + die1 + " and " + die2);

            // Check for doubles
            doubles = (die1 == die2);
            if (doubles) {
                doublesCount++;
                if (doublesCount == 3) {
                    System.out.println(player.getName() + " rolled doubles 3 times and goes to jail!");
                    // TODO: send player to jail
                    break;
                }
            } else {
                // TODO: move player by die1 + die2
                // TODO: check property, pay rent or allow purchase
            }

        } while (doubles);
    }

    private void afterTurnMenu(Player player) {
        boolean exitMenu = false;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (!exitMenu) {
            System.out.println("Choose an option:");
            System.out.println("1. Buy Houses");
            System.out.println("2. Sell Houses");
            System.out.println("3. Check Properties");
            System.out.println("4. Make Trade");
            System.out.println("5. End Turn");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // TODO: implement buy houses
                    break;
                case 2:
                    // TODO: implement sell houses
                    break;
                case 3:
                    // TODO: display player properties
                    break;
                case 4:
                    // TODO: implement trading
                    break;
                case 5:
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
