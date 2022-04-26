import javax.swing.*;
import java.awt.*;

public class RobFrame extends JFrame{
    private int xLoc, yLoc;
    private Player currentPlayer, stealPlayer;
    private JPanel panel;
    private JButton button;
    private JLabel robber;
    private Container win;

    public RobFrame(){
        super("Rob Frame");
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
        button.setBackground(Color.green);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        // add(panel);
        add(button);
    }

    public void next(){}

    public void moveRobber(int x, int y){}

    public void steal(){}

}
