//import java.util.*;
//
//public class GameEngine {
//
//    private ResourceCard wool, ore, wheat, wood, brick;
//    private Stack<ResourceCard> woolDeck, wheatDeck, brickDeck, oreDeck, woodDeck;
//    private Stack<DevelopmentCard> developmentCardDeck;
//    private Random r;
//    private static int[] dice;
//    private int rollNum;
//    private SettlementNode[][] intersections;
//    private static MapTile[][] board;
//    private boolean gameEnd;
//    private int playerWon;
//    private static TreeMap<Integer, Integer[][]> tokenMap;
//    private static ArrayList<Port> ports;
//    private static ArrayList<Player> players;
//
//
//    public GameEngine() {
//        setup();
////        initialRound();
////        run();
//    }
//
//    private void setup() {
//        cardCreation();
//        // Create the various ports then randomly assign onto board??
//        // 1 2:1 trade per resource, 4 3:1 trade anything
//        portCreation();
//        players = new ArrayList<Player>();
//        players.add(new Player("blue"));
//        players.add(new Player("orange"));
//        players.add(new Player("magenta"));
//        players.add(new Player("yellow"));
//
//    }
//
//    private void cardCreation() {
//        wool = new ResourceCard("wool");
//        ore = new ResourceCard("ore");
//        wheat = new ResourceCard("wheat");
//        wood = new ResourceCard("wood");
//        brick = new ResourceCard("brick");
//
//        woolDeck = new Stack<ResourceCard>();
//        oreDeck = new Stack<ResourceCard>();
//        wheatDeck = new Stack<ResourceCard>();
//        woodDeck = new Stack<ResourceCard>();
//        brickDeck = new Stack<ResourceCard>();
//
//        for(int i=0; i<19; i++) {
//            woolDeck.push(wool);
//            oreDeck.push(ore);
//            wheatDeck.push(wheat);
//            woodDeck.push(wood);
//            brickDeck.push(brick);
//        }
//
//
//        // instantiate correctly !
//        DevelopmentCard knight = new KnightCard();
//        DevelopmentCard roadBuild = new RoadBuilding();
//        DevelopmentCard monopoly = new Monopoly();
//        DevelopmentCard yearPlenty = new YearOfPlenty();
//        DevelopmentCard vp1 = new VictoryPoint(1);
//        DevelopmentCard vp2 = new VictoryPoint(2);
//        DevelopmentCard vp3 = new VictoryPoint(3);
//        DevelopmentCard vp4 = new VictoryPoint(4);
//        DevelopmentCard vp5 = new VictoryPoint(5);
//
//
//    }
//
//    private void portCreation() {
//        // creates ArrayList and Port instances
//        ports = new ArrayList<Port>();
//        Port portWool = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wool, wool)));
//        Port portBrick = new Port(true,new ArrayList<ResourceCard>(Arrays.asList(brick, brick)));
//        Port portOre = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(ore, ore)));
//        Port portWheat = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wheat, wheat)));
//        Port portWood = new Port(true, new ArrayList<ResourceCard>(Arrays.asList(wood, wood)));
//        Port port6 = new Port(false);
//        Port port7 = new Port(false);
//        Port port8 = new Port(false);
//        Port port9 = new Port(false);
//        ports.add(portWool);
//        ports.add(portBrick);
//        ports.add(portOre);
//        ports.add(portWheat);
//        ports.add(portWood);
//        ports.add(port6);
//        ports.add(port7);
//        ports.add(port8);
//        ports.add(port9);
//        Collections.shuffle(ports, r);
//    }
//
//    public static int[] getDice() { return dice; }
//    private void distributeResources() {
//
//    }
//
//
//
//
//
//    public static Port[] getPort() { return ports; }
//    public static TreeMap<Integer, Integer[][]> getTokenMap() { return tokenMap; }
//    public static MapTile[][] getBoard() { return board; }
//    public static ArrayList<Player> getPlayers() {
//        return players;
//    }
//
//}
