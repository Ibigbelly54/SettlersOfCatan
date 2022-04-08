import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BuildFrame extends JFrame{
    private BufferedImage tile;
    private int side, xLoc, yLoc;
    private Player currentPlayer;
    private JPanel panel;
    private JButton button;
    private int buildType;

    public BuildFrame(){
        setSize(400, 400);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void buildRoad(Player player, int side){

    }
    public void buildSettlement(Player player, int x, int y){

    }
    public void buildCity(Player player, int x, int y){

    }
}
