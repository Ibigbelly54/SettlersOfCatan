import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class StartFrame extends JFrame {

    private BufferedImage start;
    private static JFrame frame;

    public StartFrame(){
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setVisible (true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try{
            start = ImageIO.read(this.getClass().getResource("/Image/startFrame.png"));

        }
        catch(IOException e){
            System.out.print("error");
        }
       // addMouseListener(this);

    }

    public void paint(Graphics g)
    {
     //   super.paint(g);
        g.drawImage(start, 0, 0, 400, 400, null);
        revalidate();
    }


//    @Override
//    public void mouseClicked(MouseEvent e) {
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
}
