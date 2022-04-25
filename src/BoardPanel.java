
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class BoardPanel extends JFrame  {

    // private static StartPanel panel;
    private Container win;
    private JButton button, helpButton;
    private BufferedImage ore, wood, wheat, wool, brick;

    public BoardPanel()
    {
        super();
        win = getContentPane();
        win.setLayout(null);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        MapTile[][] board = GameEngine.getBoard();
        int setLength = board[2][2].getImage().getWidth() / 2;
        int setHeight = board[2][2].getImage().getHeight() / 2;
        int startHeight = getHeight()/6;
        int startLength = getWidth()/5;
        //first row

        for(int r=2; r<5; r++) {
            BufferedImage image = board[r-2][0].getImage();
            g.drawImage(image, r*setLength + startLength, startHeight, setLength, setHeight, null);
        }
        //second row
        for(int r=1; r<5; r++) {
            BufferedImage image = board[r-1][1].getImage();
            g.drawImage(image, r*setLength + setLength/2 + startLength, (int)(setLength * .86) + startHeight, setLength, setHeight, null);
        }
        //third row
        for(int r=1; r<6; r++) {
            BufferedImage image = board[r-1][2].getImage();
            g.drawImage(image, r*setLength + startLength, (int)(setLength * 1.72) + startHeight, setLength, setHeight, null);
        }
        //fourth row
        for(int r=1; r<5; r++) {
            BufferedImage image = board[r-1][3].getImage();
            g.drawImage(image, r*setLength + setLength/2 + startLength, (int)(setLength* 2.58) + startHeight, setLength, setHeight, null);
        }
        //fifth row
        for(int r=2; r<5; r++) {
            BufferedImage image = board[r-2][4].getImage();
            g.drawImage(image, r*setLength + startLength, (int)(setLength * 3.44) + startHeight, setLength, setHeight, null);
        }

    }
}


