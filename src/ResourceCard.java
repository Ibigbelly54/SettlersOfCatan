import java.awt.image.BufferedImage;

public class ResourceCard {

    private String resource;
    private BufferedImage image;

    public ResourceCard(String type) {
        resource = type;
        if(resource.equals("wool")) {

        }
        if(resource.equals("wood")) {

        }
        if(resource.equals("wheat")) {

        }
        if(resource.equals("brick")) {

        }
        if(resource.equals("ore")) {

        }
    }

    public String getResource() {
        return resource;
    }
    public BufferedImage getImage() {
        return image;
    }
}
