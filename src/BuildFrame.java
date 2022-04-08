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
        setSize(400, 400);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(50,50);
        button = new JButton();
        button.setSize(10,50);
        button.setText("Confirm");
        add(panel);
        add(button);
    }
    public void next(){

    }
    public void buildRoad(Player player, int side){

    }
    public void buildSettlement(Player player, int x, int y){

    }
    public void buildCity(Player player, int x, int y){

    }
}
