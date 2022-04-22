import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameFrame extends JFrame
{
    private BufferedImage wood, brick, desert, ore, sheep, wheat;
    public GameFrame()
    {
        try{
            wood = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/woodTile.png")));
            brick = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/brickTile.png")));
            desert = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/desertTile.png")));
            ore = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/oreTile.png")));
            sheep = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/sheepTile.png")));
            wheat = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/Tiles/wheatTile.png")));
        }
        catch(IOException e){
            System.out.print("error");
        }
    }
}
