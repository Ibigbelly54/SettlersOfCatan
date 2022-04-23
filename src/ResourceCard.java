import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ResourceCard {

    private String resource;
    private BufferedImage image;

    public ResourceCard(String type) {
        resource = type;
        try {
            if (resource.equals("wool")) {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
            }
            if (resource.equals("wood")) {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
            }
            if (resource.equals("wheat")) {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
            }
            if (resource.equals("brick")) {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
            }
            if (resource.equals("ore")) {
                image = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
            }
        } catch(IOException e){
            System.out.print("error");
        }
    }

    public String getResource() {
        return resource;
    }
    public BufferedImage getImage() {
        return image;
    }
}
