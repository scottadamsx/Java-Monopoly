public class Board {
    private BoardSpace[] spaces;

    public Board() {
        spaces = new BoardSpace[40];

        spaces[0] = new BoardSpace(0, new Property("GO", 0, null, 0));
        spaces[1] = new BoardSpace(1, new Property("Mediterranean Avenue", 60, ColorSet.BROWN, 30));
        spaces[2] = new BoardSpace(2, new Property("Community Chest", 0, null, 0));
        spaces[3] = new BoardSpace(3, new Property("Baltic Avenue", 60, ColorSet.BROWN, 30));
        spaces[4] = new BoardSpace(4, new Property("Income Tax", 0, null, 0));
        spaces[5] = new BoardSpace(5, new Property("Reading Railroad", 200, null, 100));
        spaces[6] = new BoardSpace(6, new Property("Oriental Avenue", 100, ColorSet.LIGHT_BLUE, 50));
        spaces[7] = new BoardSpace(7, new Property("Chance", 0, null, 0));
        spaces[8] = new BoardSpace(8, new Property("Vermont Avenue", 100, ColorSet.LIGHT_BLUE, 50));
        spaces[9] = new BoardSpace(9, new Property("Connecticut Avenue", 120, ColorSet.LIGHT_BLUE, 60));
        spaces[10] = new BoardSpace(10, new Property("Jail / Just Visiting", 0, null, 0));
        spaces[11] = new BoardSpace(11, new Property("St. Charles Place", 140, ColorSet.PINK, 70));
        spaces[12] = new BoardSpace(12, new Property("Electric Company", 150, null, 75));
        spaces[13] = new BoardSpace(13, new Property("States Avenue", 140, ColorSet.PINK, 70));
        spaces[14] = new BoardSpace(14, new Property("Virginia Avenue", 160, ColorSet.PINK, 80));
        spaces[15] = new BoardSpace(15, new Property("Pennsylvania Railroad", 200, null, 100));
        spaces[16] = new BoardSpace(16, new Property("St. James Place", 180, ColorSet.ORANGE, 90));
        spaces[17] = new BoardSpace(17, new Property("Community Chest", 0, null, 0));
        spaces[18] = new BoardSpace(18, new Property("Tennessee Avenue", 180, ColorSet.ORANGE, 90));
        spaces[19] = new BoardSpace(19, new Property("New York Avenue", 200, ColorSet.ORANGE, 100));
        spaces[20] = new BoardSpace(20, new Property("Free Parking", 0, null, 0));
        spaces[21] = new BoardSpace(21, new Property("Kentucky Avenue", 220, ColorSet.RED, 110));
        spaces[22] = new BoardSpace(22, new Property("Chance", 0, null, 0));
        spaces[23] = new BoardSpace(23, new Property("Indiana Avenue", 220, ColorSet.RED, 110));
        spaces[24] = new BoardSpace(24, new Property("Illinois Avenue", 240, ColorSet.RED, 120));
        spaces[25] = new BoardSpace(25, new Property("B. & O. Railroad", 200, null, 100));
        spaces[26] = new BoardSpace(26, new Property("Atlantic Avenue", 260, ColorSet.YELLOW, 130));
        spaces[27] = new BoardSpace(27, new Property("Ventnor Avenue", 260, ColorSet.YELLOW, 130));
        spaces[28] = new BoardSpace(28, new Property("Water Works", 150, null, 75));
        spaces[29] = new BoardSpace(29, new Property("Marvin Gardens", 280, ColorSet.YELLOW, 140));
        spaces[30] = new BoardSpace(30, new Property("Go To Jail", 0, null, 0));
        spaces[31] = new BoardSpace(31, new Property("Pacific Avenue", 300, ColorSet.GREEN, 150));
        spaces[32] = new BoardSpace(32, new Property("North Carolina Avenue", 300, ColorSet.GREEN, 150));
        spaces[33] = new BoardSpace(33, new Property("Community Chest", 0, null, 0));
        spaces[34] = new BoardSpace(34, new Property("Pennsylvania Avenue", 320, ColorSet.GREEN, 160));
        spaces[35] = new BoardSpace(35, new Property("Short Line Railroad", 200, null, 100));
        spaces[36] = new BoardSpace(36, new Property("Chance", 0, null, 0));
        spaces[37] = new BoardSpace(37, new Property("Park Place", 350, ColorSet.DARK_BLUE, 175));
        spaces[38] = new BoardSpace(38, new Property("Luxury Tax", 0, null, 0));
        spaces[39] = new BoardSpace(39, new Property("Boardwalk", 400, ColorSet.DARK_BLUE, 200));
    }
}
