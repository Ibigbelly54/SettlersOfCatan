import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class MapTile {

    private boolean desert, hasRobber;
    private BufferedImage image;
    private String resource;
    private int value;
    private int[] roads; // 0-4 player, pos out of 6 sides

    public MapTile(String type, int val, boolean isDesert) throws IOException {
        resource = type;
        value = val;
        if(isDesert) {
            desert = true;
            hasRobber = true;
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/desertTile.png")));
        }
        else {
            desert = false;
            hasRobber = false;
        }
        if(type.equals("wood"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/woodTile.png")));
        if(type.equals("brick"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/brickTile.png")));
        if(type.equals("ore"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/oreTile.png")));
        if(type.equals("sheep"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/sheepTile.png")));
        if(type.equals("wheat"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/wheatTile.png")));
    }

    public void setRobber(boolean bool) {
        hasRobber = bool;
    }
}
