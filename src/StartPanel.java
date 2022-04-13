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

    public StartPanel() {
        try {
            start = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/startFrame.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(start, 0, 0, getWidth(), getHeight(), null);
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
