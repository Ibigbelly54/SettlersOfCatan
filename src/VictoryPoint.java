import java.awt.image.BufferedImage;

public class VictoryPoint extends DevelopmentCard{

    private int cardNum;
    private BufferedImage image;

    public VictoryPoint(int num) {
        super("VictoryPoint");
        cardNum = num;
    }

    public void use() {
        GameEngine.getPlayers().get(super.getPlayerPossesion()).setVP(GameEngine.getPlayers().get(super.getPlayerPossesion()).getVP() + 1);
    }
}
