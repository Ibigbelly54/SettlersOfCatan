import java.awt.image.BufferedImage;

public class MapTile {

    private boolean desert, hasRobber;
    private BufferedImage image;
    private String resource;
    private int value;
    private int[] roads; // 0-4 player, pos out of 6 sides

    public MapTile(String type, int val, boolean isDesert) {
        resource = type;
        value = val;
        if(isDesert) {
            desert = true;
            hasRobber = true;
        }
        else {
            desert = false;
            hasRobber = false;
        }
    }

    public void setRobber(boolean bool) {
        hasRobber = bool;
    }
}
