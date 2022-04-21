import java.awt.image.BufferedImage;

public class YearOfPlenty extends DevelopmentCard {

    private BufferedImage image;
    int count = 0;

    public YearOfPlenty() {
        super("YearOFPlenty");
    }

    public void use(Player year, ResourceCard one, ResourceCard two)
    {
        year.addCard(one);
        year.addCard(two);
    }
}
