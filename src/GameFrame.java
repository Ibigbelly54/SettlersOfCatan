import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameFrame extends JFrame
{
    private BufferedImage wood, brick, desert, ore, sheep, wheat;
    public GameFrame()
    {
        try{
            wood = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/woodTile.png")));
            brick = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/brickTile.png")));
            desert = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/desertTile.png")));
            ore = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/oreTile.png")));
            sheep = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/sheepTile.png")));
            wheat = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/wheatTile.png")));
        }
        catch(IOException e){
            System.out.print("error");
        }
    }
}
