import java.io.IOException;
import java.util.*;

public class GameEngine {

    private ResourceCard wool, ore, wheat, wood, brick;
    private static Stack<ResourceCard> woolDeck, wheatDeck, brickDeck, oreDeck, woodDeck;
    private static Stack<DevelopmentCard> developmentCardDeck;
    private static Random r;
    private static int[] dice;
    private static int rollNum, currentPlayer;
    private static SettlementNode[][] intersections;
    private static MapTile[][] board;
    private static boolean gameEnd;
    private static int playerWon;
    private static TreeMap<Integer, ArrayList<Integer>> tokenMap;
    private static ArrayList<Port> ports;
    private static ArrayList<Player> players;


    public GameEngine() {
        r = new Random();
        setup();
        initialRound();
//        run();
    } // NOT FINISHED

    // CREATION/SETUP ////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setup() {
        cardCreation();
        // Create the various ports then randomly assign onto board??
        // 1 2:1 trade per resource, 4 3:1 trade anything
        portCreation();
        try {
            boardCreation();
        } catch (IOException e) {
            e.printStackTrace();
        }
        players = new ArrayList<Player>();
        players.add(new Player("blue"));
        players.add(new Player("orange"));
        players.add(new Player("magenta"));
        players.add(new Player("yellow"));
    } // NOT FINISHED DEFINITELY NOT.
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

        developmentCardDeck = new Stack<DevelopmentCard>();
        ArrayList<DevelopmentCard> devCardSet = new ArrayList<DevelopmentCard>();
        for(int i=0; i<14; i++) {
            devCardSet.add(knight);
        }
        for(int i=0; i<2; i++) {
            devCardSet.add(roadBuild);
            devCardSet.add(yearPlenty);
            devCardSet.add(monopoly);
        }
        devCardSet.add(vp1);
        devCardSet.add(vp2);
        devCardSet.add(vp3);
        devCardSet.add(vp4);
        devCardSet.add(vp5);
        Collections.shuffle(devCardSet);
        for(int i=0; i<devCardSet.size(); i++) {
            developmentCardDeck.push(devCardSet.get(i));
        }
    }
    private void boardCreation() throws IOException {
        tokenMap = new TreeMap<Integer, ArrayList<Integer>>();
        ArrayList<MapTile> mapTiles = new ArrayList<MapTile>();
        MapTile wood = new MapTile("wood", false);
        MapTile wool = new MapTile("wool", false);
        MapTile wheat = new MapTile("wheat", false);
        MapTile brick = new MapTile("brick", false);
        MapTile ore = new MapTile("ore", false);
        MapTile desert = new MapTile("desert", true);
        for(int i=0; i<4; i++) {
            mapTiles.add(wood);
            mapTiles.add(wheat);
            mapTiles.add(wool);
        }
        for(int i=0; i<3; i++) {
            mapTiles.add(brick);
            mapTiles.add(ore);
        }
        mapTiles.add(desert);
        Collections.shuffle(mapTiles);
        Stack<MapTile> mapTileStack = new Stack<MapTile>();
        for(int i=0; i<mapTiles.size(); i++) {
            mapTileStack.push(mapTiles.get(i));
        }
        board = new MapTile[5][5];
        for(int i=0; i<3; i++) {
            board[0][i] = mapTileStack.pop();
            board[4][i] = mapTileStack.pop();
        }
        for(int i=0; i<4; i++) {
            board[1][i] = mapTileStack.pop();
            board[3][i] = mapTileStack.pop();
        }
        for(int i=0; i<5; i++) {
            board[2][i] = mapTileStack.pop();
        }
        ArrayList<Integer> tokens = new ArrayList<Integer>(Arrays.asList(5, 2, 6, 3, 8, 10, 9, 12, 11, 4, 8, 10, 9, 4, 5, 6, 3, 11));
        //hardcode lol
        if(!board[0][0].isDesert()) {
            int val = tokens.remove(0);
            board[0][0].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(0, 0)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 0, 0)));
            }
        }
        if(!board[1][0].isDesert()) {
            int val = tokens.remove(0);
            board[1][0].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(1, 0)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 1, 0)));
            }
        }
        if(!board[2][0].isDesert()) {
            int val = tokens.remove(0);
            board[2][0].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(2, 0)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 2, 0)));
            }
        }
        if(!board[3][0].isDesert()) {
            int val = tokens.remove(0);
            board[3][0].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(3, 0)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 3, 0)));
            }
        }
        if(!board[4][0].isDesert()) {
            int val = tokens.remove(0);
            board[4][0].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(4, 0)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 4, 0)));
            }
        }
        if(!board[4][1].isDesert()) {
            int val = tokens.remove(0);
            board[4][1].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(4, 1)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 4, 1)));
            }
        }
        if(!board[4][2].isDesert()) {
            int val = tokens.remove(0);
            board[4][2].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(4, 2)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 4, 2)));
            }        }
        if(!board[3][3].isDesert()) {
            int val = tokens.remove(0);
            board[3][3].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(3, 3)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 3, 3)));
            }        }
        if(!board[2][4].isDesert()) {
            int val = tokens.remove(0);
            board[2][4].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(2, 4)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 2, 4)));
            }        }
        if(!board[1][3].isDesert()) {
            int val = tokens.remove(0);
            board[1][3].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(1, 3)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 1, 3)));
            }        }
        if(!board[0][2].isDesert()) {
            int val = tokens.remove(0);
            board[0][2].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(0, 2)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 0, 2)));
            }        }
        if(!board[0][1].isDesert()) {
            int val = tokens.remove(0);
            board[0][1].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(0, 1)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 0, 1)));
            }        }
        if(!board[1][1].isDesert()) {
            int val = tokens.remove(0);
            board[1][1].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(1, 1)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 1, 1)));
            }        }
        if(!board[2][1].isDesert()) {
            int val = tokens.remove(0);
            board[2][1].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(2, 1)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 2, 1)));
            }        }
        if(!board[3][1].isDesert()) {
            int val = tokens.remove(0);
            board[3][1].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(3, 1)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 3, 1)));
            }        }
        if(!board[3][2].isDesert()) {
            int val = tokens.remove(0);
            board[3][2].setTokenValue(val);
            tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(3, 2)));
        }
        if(!board[2][3].isDesert()) {
            int val = tokens.remove(0);
            board[2][3].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(2, 3)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 2, 3)));
            }        }
        if(!board[1][2].isDesert()) {
            int val = tokens.remove(0);
            board[1][2].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(1, 2)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 1, 2)));
            }        }
        if(!board[2][2].isDesert()) {
            int val = tokens.remove(0);
            board[2][2].setTokenValue(val);
            if(tokenMap.get(val) == null) {
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(2, 2)));
            }
            else if(tokenMap.get(val) != null) {
                int one = tokenMap.get(val).get(0);
                int two = tokenMap.get(val).get(1);
                tokenMap.remove(val);
                tokenMap.put(val, new ArrayList<Integer>(Arrays.asList(one, two, 2, 2)));
            }        }
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

    // RANDOM METHODS IDK GAME ENGINE STUFF ///////////////////////////////////////////////////////////////////////////////
    private void distributeResources() {
        if(!checkRobber()) {
            ArrayList<Integer> positions = tokenMap.get(rollNum);
            if(positions.size() == 4) {
                int x1 = positions.get(0);
                int y1 = positions.get(1);
                int x2 = positions.get(2);
                int y2 = positions.get(3);
                if(!board[x1][y1].getRobber()) {
                    // FINISH HERE I DONT WANT TO THINK ABOUT IT RN NEEDS TO CHECK SURROUNDING NODES OR SOMETHING IDK
                }
                if(!board[x2][y2].getRobber()) {

                }
            }
            else {
                int x = positions.get(0);
                int y = positions.get(1);
                if(!board[x][y].getRobber()) {

                }
            }
        }
    } // NOT FINISHED
    public void initialRound() {} // HOW TO DO THIS SOBBING CRYING
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

    } // NOT FINISHED
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
    public static boolean checkRobber() {
        if(rollNum == 7) {
            return true;
            // GameFrame.callRobFrame(); ? something like that
        }
        return false;
    } // NOT FINISHED

    // BUILD METHODS //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean buildSettlement(Player player, int x, int y) {
        return false;
    } // NOT FINISHED
    public static boolean buildCity(Player player, int x, int y) {
        return false;
    } // NOT FINISHED
    public static boolean buildRoad(Player player, int x, int y) {
        return false;
    } // NOT FINISHED

    // GETTERS
    public static ArrayList<Port> getPort() { return ports; }
    public static TreeMap<Integer, ArrayList<Integer>> getTokenMap() { return tokenMap; }
    public static MapTile[][] getBoard() { return board; }
    public static ArrayList<Player> getPlayers() { return players; }
    public static int[] getDice() { return dice; }


}
