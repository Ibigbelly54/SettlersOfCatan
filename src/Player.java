import javax.swing.plaf.multi.MultiOptionPaneUI;
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
    public void setVP(int vp) {
        this.vp = vp;
    }
    public int getVP()
    {
        return vp;
    }
    public void addCard(ResourceCard card)
    {
        playerHand.add(card);
    }
    public boolean deleteCard(ResourceCard card)
    {
        return playerHand.remove(card);
    }
    public void setKnight(int num)
    {
        knight=num;
    }
    public ArrayList<ResourceCard> getHand()
    {
        return playerHand;
    }
    public ArrayList<DevelopmentCard> getDevCards()
    {
        return getDevCards();
    }
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
}
