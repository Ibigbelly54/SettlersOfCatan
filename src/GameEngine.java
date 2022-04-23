import java.util.*;

public class GameEngine {

    private ResourceCard wool, ore, wheat, wood, brick;
    private static Stack<ResourceCard> woolDeck, wheatDeck, brickDeck, oreDeck, woodDeck;
    private Stack<DevelopmentCard> developmentCardDeck;
    private static Random r;
    private static int[] dice;
    private static int rollNum, currentPlayer;
    private SettlementNode[][] intersections;
    private static MapTile[][] board;
    private static boolean gameEnd;
    private static int playerWon;
    private static TreeMap<Integer, Integer[][]> tokenMap;
    private static ArrayList<Port> ports;
    private static ArrayList<Player> players;


    public GameEngine() {
        r = new Random();
        setup();
//        initialRound();
//        run();
    }



    private void setup() {
        cardCreation();
        // Create the various ports then randomly assign onto board??
        // 1 2:1 trade per resource, 4 3:1 trade anything
        portCreation();
        players = new ArrayList<Player>();
        players.add(new Player("blue"));
        players.add(new Player("orange"));
        players.add(new Player("magenta"));
        players.add(new Player("yellow"));

    }

    private void cardCreation() {
        wool = new ResourceCard("wool");
        ore = new ResourceCard("ore");
        wheat = new ResourceCard("wheat");
        wood = new ResourceCard("wood");
        brick = new ResourceCard("brick");

        woolDeck = new Stack<ResourceCard>();
        oreDeck = new Stack<ResourceCard>();
        wheatDeck = new Stack<ResourceCard>();
        woodDeck = new Stack<ResourceCard>();
        brickDeck = new Stack<ResourceCard>();

        for(int i=0; i<19; i++) {
            woolDeck.push(wool);
            oreDeck.push(ore);
            wheatDeck.push(wheat);
            woodDeck.push(wood);
            brickDeck.push(brick);
        }


        // instantiate correctly !
        DevelopmentCard knight = new KnightCard();
        DevelopmentCard roadBuild = new RoadBuilding();
        DevelopmentCard monopoly = new Monopoly();
        DevelopmentCard yearPlenty = new YearOfPlenty();
        DevelopmentCard vp1 = new VictoryPoint(1);
        DevelopmentCard vp2 = new VictoryPoint(2);
        DevelopmentCard vp3 = new VictoryPoint(3);
        DevelopmentCard vp4 = new VictoryPoint(4);
        DevelopmentCard vp5 = new VictoryPoint(5);


    }

    private void portCreation() {
        // creates ArrayList and Port instances
        ports = new ArrayList<Port>();
        Port portWool = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wool, wool)));
        Port portBrick = new Port(true,new ArrayList<ResourceCard>(Arrays.asList(brick, brick)));
        Port portOre = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(ore, ore)));
        Port portWheat = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wheat, wheat)));
        Port portWood = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wood, wood)));
        Port port6 = new Port(false);
        Port port7 = new Port(false);
        Port port8 = new Port(false);
        Port port9 = new Port(false);
        ports.add(portWool);
        ports.add(portBrick);
        ports.add(portOre);
        ports.add(portWheat);
        ports.add(portWood);
        ports.add(port6);
        ports.add(port7);
        ports.add(port8);
        ports.add(port9);
        Collections.shuffle(ports, r);
    }
    private void distributeResources() {

    }
    public static void roll() {
        dice[0] = r.nextInt(7);
        dice[1] = r.nextInt(7);
        rollNum = dice[0] + dice[1];
    }

    public static boolean steal(Player player, ResourceCard card) {
        if(player.getHand().contains(card)) {
            player.deleteCard(card);
            players.get(currentPlayer).addCard(card);
            return true;
        }
        return false;
    }

    public static void moveRobber(int x, int y) {
        boolean stop = false;
        for(int r=0; r<5 && !stop; r++) {
            for(int c=0; c<5 && !stop; c++) {
                if(board[r][c] != null && board[r][c].getRobber()) {
                    board[r][c].setRobber(false);
                    stop = true;
                }
            }
        }
        board[x][y].setRobber(true);
    }

    public static void removeSupply(ResourceCard card) {
        if(woolDeck.contains(card)) {
            woolDeck.remove(card);
        }
        else if(woodDeck.contains(card)) {
            woodDeck.remove(card);
        }
        else if(wheatDeck.contains(card)) {
            wheatDeck.remove(card);
        }
        else if(brickDeck.contains(card)) {
            brickDeck.remove(card);
        }
        else if(oreDeck.contains(card)) {
            oreDeck.remove(card);
        }
    }

    // ALL THE TRADE METHODS //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static boolean SpecialPortTrade(Player player, int portLoc, ResourceCard gain) {
        ArrayList<ResourceCard> playerHand = player.getHand();
        ArrayList<ResourceCard> cardsTrade = ports.get(portLoc).getTrade();
        int count = 0;
        ResourceCard cardCheck = cardsTrade.get(0);
        for(int j=0; j<playerHand.size(); j++) {
            if(playerHand.contains(cardCheck) && count <= 2) {
                playerHand.remove(cardCheck);
                count++;
            }
        }
        if(count == 2) {
            player.addCard(gain);
            return true;
        }
        else if(count == 1) {
            player.addCard(cardCheck);
            return false;
        }
        return false;
    }

    public static boolean portTrade(Player player, ArrayList<ResourceCard> test, ResourceCard gain) {
        ArrayList<ResourceCard> playerHand = player.getHand();
        ResourceCard cardCheck = test.get(0);
        int count = 0;
        for(int j=0; j<test.size(); j++) {
            if(test.contains(cardCheck) && count <= 3) {
                count++;
            }
        }
        if(count == 3) {
            for(int i=0; i<3; i++) {
                playerHand.remove(cardCheck);
            }
            player.addCard(gain);
            return true;
        }
        return false;
    }

    public static void domesticTrade(Player player1, Player player2, ArrayList<ResourceCard> p1, ArrayList<ResourceCard> p2) {
        // needs to check logic if they are cheating/going against rules? nah
        for(int i=0; i<p1.size(); i++) {
            player2.addCard(p1.get(i));
            player1.deleteCard(p1.get(i));
        }
        for(int i=0; i<p2.size(); i++) {
            player1.addCard(p2.get(i));
            player2.deleteCard(p2.get(i));
        }
    }

    public static boolean fourTrade(Player player, ResourceCard lost, ResourceCard gain) {
        ArrayList<ResourceCard> playerHand = player.getHand();
        int count = 0;
        for(int i=0; i<playerHand.size(); i++) {
            if(playerHand.get(i) == lost) {
                count++;
            }
        }
        if(count == 4) {
            player.addCard(gain);
            for(int i=0; i<4; i++) {
                player.deleteCard(lost);
            }
            return true;
        }
        return false;
    }



    // CHECK METHODS //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void check() {
        checkIfWin();
        checkLongestRoad();
        checkLargestArmy();
        checkRobber();
    }
    public static boolean checkIfWin() {
        if(players.get(currentPlayer).getVP() >= 10) {
            gameEnd = true;
            playerWon = currentPlayer;
            return true;
        }
        return false;
    }
    public static void checkLongestRoad() {

    }
    public static void checkLargestArmy() {
        int currentHolder = -1;
        int knightNum = -1;
        for(int i=0; i<players.size(); i++) {
            if(players.get(i).getLargestArmy()) {
                currentHolder = i;
                knightNum = players.get(i).getKnight();
            }
        }
        for(int i=0; i<players.size(); i++) {
            if(i != currentHolder) {
                int check = players.get(i).getKnight();
                if(check > knightNum) {
                    players.get(currentHolder).setLargestArmy(false);
                    currentHolder = i;
                    knightNum = check;

                }
            }
        }
        players.get(currentHolder).setLargestArmy(true);
    }

    public static void checkRobber() {
        if(rollNum == 7) {
            // GameFrame.callRobFrame(); ? something like that
        }
    }

    // CHECK METHODS //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean buildSettlement(Player player, int x, int y) {
        return false;
    }
    public static boolean buildCity(Player player, int x, int y) {
        return false;
    }
    public static boolean buildRoad(Player player, int x, int y) {
        return false;
    }



    // GETTERS ?
    public static ArrayList<Port> getPort() { return ports; }
    public static TreeMap<Integer, Integer[][]> getTokenMap() { return tokenMap; }
    public static MapTile[][] getBoard() { return board; }
    public static ArrayList<Player> getPlayers() { return players; }

    public static int[] getDice() { return dice; }
}
