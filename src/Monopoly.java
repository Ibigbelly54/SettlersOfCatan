import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Monopoly extends DevelopmentCard {

    private BufferedImage image;

    public Monopoly() {
        super("Monopoly");
    }

    public void use(ResourceCard card) {
        ArrayList<Player> players = GameEngine.getPlayers();
        int receiver = super.getPlayerPossesion();
        for(int i=0; i<players.size(); i++) {
            if(i != receiver) {
                ArrayList<ResourceCard> pDeck = players.get(i).getHand();
                if (pDeck.contains(card)) {
                    while(pDeck.contains(card)) {
                        pDeck.remove(card);
                        players.get(receiver).addCard(card);
                    }
                }
            }
        }
    }


}
