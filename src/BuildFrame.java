
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BuildFrame extends JFrame{

    private int side, xLoc, yLoc;
    private Player currentPlayer;
    private JPanel panel;
    private JButton button;
    private int buildType;

    public BuildFrame(){
        super("Build Frame");
        setSize(1000, 1000);
        setVisible (true);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(50,50);
        button = new JButton("Confirm");
        button.setSize(50,10);
        button.setBackground(Color.pink);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        add(panel);
        panel.add(button);
    }
    public void next(){
        //go to game frame
    }
    public void buildRoad(Player player, int side){buildType=0;
        //panel.drawRect(side, side, 4,10);
        }
    public void buildSettlement(Player player, int x, int y){
        buildType=1;
    }
    public void buildCity(Player player, int x, int y){
        buildType=2;
   }
}

