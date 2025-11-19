public class App {

    /*  
    I will now try and make a functional gameloop that will:

    - create a new game Object
    - start game
    - loop through players and allow them to buy properties, or pay rent on them
    - if their money gets below 0, bankrupt them and remove them from the game

    very simple, but this will allow me to have a skeleton to build on 
    */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Game game = new Game();
        game.start();

    }
}

