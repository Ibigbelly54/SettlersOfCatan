import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class StartFrame extends JFrame  implements ActionListener {

   // private static StartPanel panel;
    private Container win;
    private JButton button, helpButton;
    private BufferedImage start;

    public StartFrame()
    {
        super();
        win = getContentPane();
        win.setLayout(null);

        button = new JButton("Start");
        button.setBounds(700, 900, 200, 100);
        button.setFont(new Font("TimesRoman", Font.BOLD, 30));
        win.add(button);
        button.addActionListener(this);

        helpButton = new JButton("Help");
        helpButton.setBounds(1000, 900, 200, 100);
        helpButton.setFont(new Font("TimesRoman", Font.BOLD, 30));
        win.add(helpButton);
        helpButton.addActionListener(this);

        try {
            start = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/Image/startFrame1.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible (true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        g.drawImage(start, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(helpButton))
           new Helpmenu();
        if(e.getSource().equals(button))
            new BuildFrame();
    }
}
