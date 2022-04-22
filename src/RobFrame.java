import javax.swing.*;
import java.awt.*;

public class RobFrame extends JFrame{
    private int xLoc, yLoc;
    private Player currentPlayer, stealPlayer;
    private JPanel panel;
    private JButton button;
    private JLabel robber;

    public RobFrame(){
        super("Rob Frame");
        setSize(1000, 1000);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(50,50);
        button = new JButton("Confirm");
        button.setSize(50,10);
        button.setBackground(Color.pink);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        robber = new JLabel();robber.setSize(642, 900);robber.setLocation(150,75);panel.add(robber);ImageIcon icon = new ImageIcon("src/Image/robber.png");robber.setIcon(icon);
        add(panel);
        panel.add(button);
    }

    public void next(){}

    public void moveRobber(int x, int y){}

    public void steal(){}

}
