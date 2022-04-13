
import javax.swing.*;
import java.awt.*;


public class StartFrame extends JFrame {

    private static StartPanel panel;
    public StartFrame(){
        panel = new StartPanel();
        add(panel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
     super.paint(g);
    }

}
