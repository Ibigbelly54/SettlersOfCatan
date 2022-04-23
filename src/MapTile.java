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

    public MapTile(String type, boolean isDesert) throws IOException {
        resource = type;
        if(isDesert) {
            desert = true;
            hasRobber = true;
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/desertTile.png")));
        }
        else {
            desert = false;
            hasRobber = false;
        }
        if(type.equals("wood"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/woodTile.png")));
        if(type.equals("brick"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/brickTile.png")));
        if(type.equals("ore"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/oreTile.png")));
        if(type.equals("wool"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/sheepTile.png")));
        if(type.equals("wheat"))
            image=ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
    }

    public void setRobber(boolean bool) {
        hasRobber = bool;
    }
    public void setTokenValue(int num) { value = num; }
    public String getResource() { return resource; }
    public void addRoad(int side, int player) {

    }
    public int getToken() { return value; }
    public boolean getRobber() { return hasRobber; }
    public boolean isDesert() { return desert; }
}
