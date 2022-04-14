//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.Objects;
//
//public class StartPanel extends JPanel {
//
//
//
//
//    public StartPanel() {
//        try {
//            start = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/startFrame1.png")));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawImage(start, 0, 0, getWidth(), getHeight(), null);
//    }
//
//
//}
