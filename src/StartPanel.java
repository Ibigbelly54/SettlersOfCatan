import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class StartPanel extends JPanel implements MouseListener {

    private BufferedImage start;

    public StartPanel(){
        try{
            start = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/startFrame.png")));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static JFrame frame;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    private Container win;

    public StartPanel(){
        super();
        frame = new JFrame("StartPanel");
        win = frame.getContentPane();
        win.setLayout(null);

        frame.setSize(400, 400);
        frame.setVisible (true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            start = ImageIO.read(Objects.requireNonNull(StartPanel.class.getResource("/Image/startFrame.png")));

        }
        catch(IOException e){
            System.out.print("error");
        }
        addMouseListener(this);

    }

    public void paint(Graphics g)
    {
      //  super.paint(g);
        g.drawImage(start, 20, 20, 200, 200, null);
       // revalidate();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
