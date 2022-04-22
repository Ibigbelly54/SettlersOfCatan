import java.util.ArrayList;

public class Port {

    private boolean specialTrade;
    private ArrayList<ResourceCard> tradeList;

    public Port(boolean special, ArrayList<ResourceCard> cards) {
        specialTrade = special;
        tradeList = cards;
    }

    public Port(boolean special) {
        specialTrade = special;
        tradeList = new ArrayList<ResourceCard>();
    }

    public ArrayList<ResourceCard> getTrade() { return tradeList; }
    public boolean isSpecialTrade() {
        return specialTrade;
    }
}
