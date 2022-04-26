
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
    private Container win;
    private JLabel label;

    public BuildFrame(){
        super("Build Frame");
        win = getContentPane();
        win.setLayout(null);

        setVisible (true);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel board = new BoardPanel();
        board.setSize(getWidth(), getHeight());
        win.add(board);
        board.setVisible(true);

      //  panel = new JPanel();
      //  panel.setSize(500,1000);
        button = new JButton("Confirm");
        button.setSize(200,100);
        button.setLocation(getWidth()-400, getHeight()/2-100);
        button.setBackground(Color.pink);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));
       // add(panel);
        add(button);

        label = new JLabel("Pick a line segment to place your ");
        label.setSize(500,50);
        label.setLocation(getWidth()/3+50,0);
        label.setFont(new Font("TimesRoman", Font.BOLD, 30));
        add(label);
    }

//    public void paint(Graphics g){
//        g.drawImage();
//    }
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

