import java.util.ArrayList;

public class Player
{
    boolean largestArmy, longestRoad;
    ArrayList<ResourceCard> playerHand;
    ArrayList<DevelopmentCard> devCards;
    int vp, cities, roads, settlements, knight;
    private String color;

    public Player(String str)
    {
        color = str;
        vp = 0;
        cities = 4;
        settlements = 5;
        roads = 15;
    }


    // PROBABLY NEEDED TO UPDATE THE VP COUNT WITH ALL CURRENT VARIABLES
    public void updateVP() {

    }

    // CARD STUFF
    public void addCard(ResourceCard card)
    {
        playerHand.add(card);
    }
    public boolean deleteCard(ResourceCard card) { return playerHand.remove(card); }

    public void useDevelopmentCard(DevelopmentCard card)
    {


        if(devCards.contains(card))
        {
            if(card.getResource().equals("Monopoly")) {
                // put in graphics as response
            }
            if(card.getResource().equals("KnightCard")) {

            }
            if(card.getResource().equals("RoadBuilding")) {

            }
            if(card.getResource().equals("VictoryPoint")) {

            }
            if(card.getResource().equals("YearOfPlenty")) {

            }
            devCards.remove(card);
        }
    }


    // SETTERS
    public void setKnight(int num)
    {
        knight=num;
    }
    public void setLargestArmy(boolean bool) { largestArmy = bool; }
    public void setLongestRoad(boolean bool) { longestRoad = bool; }
    public void setVP(int x) { vp = x; }


    // GETTERS
    public boolean getLargestArmy() { return largestArmy; }
    public boolean getLongestRoad() { return longestRoad; }
    public int getVP()
    {
        return vp;
    }
    public int getKnight() { return knight; }
    public ArrayList<ResourceCard> getHand() { return playerHand; }
    public ArrayList<DevelopmentCard> getDevCards() { return getDevCards(); }



}
