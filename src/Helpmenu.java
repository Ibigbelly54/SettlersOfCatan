import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Helpmenu extends JFrame implements ActionListener {
    private JButton back, pOne, pTwo, pThree, pFour, pFive, pSix, pSeven, pEight, pNine, pTen, pEleven, pTwelve, pThirteen;
    private JLabel heading, page, general;
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 1000;

    public Helpmenu() {
        super("Help Menu");
        Container win = getContentPane();
        win.setLayout(null);

        heading = new JLabel("Help Menu");heading.setSize(300, 80);heading.setFont(new Font("Arial", Font.BOLD, 55));heading.setForeground(new Color(98, 98, 103, 255));
        heading.setHorizontalAlignment(JLabel.CENTER);heading.setVerticalAlignment(JLabel.CENTER);
        heading.setLocation(320,10);
        win.add(heading);

        page = new JLabel();page.setSize(642, 900);page.setLocation(150,75);win.add(page);ImageIcon icon = new ImageIcon("src/Image/HelpMenu/p1.png");page.setIcon(icon);

        back = new JButton("Back");back.setSize(100,45);back.setFont(new Font("Arial", Font.BOLD, 14));back.setForeground(new Color(98, 98, 103,255));
        back.setLocation(20,75);
        back.addActionListener(this);
        win.add(back);

        general = new JLabel("Click Buttons below to navigate");general.setSize(300,50);general.setLocation(750,50);
        general.setFont(new Font("Arial", Font.BOLD, 14));
        win.add(general);

        pOne = new JButton("1");pOne.setSize(50,35);pOne.setFont(new Font("Arial", Font.BOLD, 12));pOne.setForeground(new Color(98, 98, 103,255));pOne.setLocation(850,100);
        pOne.addActionListener(this);
        win.add(pOne);

        pTwo= new JButton("2");pTwo.setSize(50,35);pTwo.setFont(new Font("Arial", Font.BOLD, 12));pTwo.setForeground(new Color(98, 98, 103,255));pTwo.setLocation(850,160);
        pTwo.addActionListener(this);
        win.add(pTwo);

        pThree = new JButton("3");pThree.setSize(50,35);pThree.setFont(new Font("Arial", Font.BOLD, 12));pThree.setForeground(new Color(98, 98, 103,255));pThree.setLocation(850,220);
        pThree.addActionListener(this);
        win.add(pThree);

        pFour = new JButton("4");pFour.setSize(50,35);pFour.setFont(new Font("Arial", Font.BOLD, 12));pFour.setForeground(new Color(98, 98, 103,255));pFour.setLocation(850,280);
        pFour.addActionListener(this);
        win.add(pFour);

        pFive = new JButton("5");pFive.setSize(50,35);pFive.setFont(new Font("Arial", Font.BOLD, 12));pFive.setForeground(new Color(98, 98, 103,255));pFive.setLocation(850,340);
        pFive.addActionListener(this);
        win.add(pFive);

        pSix = new JButton("6");pSix.setSize(50,35);pSix.setFont(new Font("Arial", Font.BOLD, 12));pSix.setForeground(new Color(98, 98, 103,255));pSix.setLocation(850,400);
        pSix.addActionListener(this);
        win.add(pSix);

        pSeven = new JButton("7");pSeven.setSize(50,35);pSeven.setFont(new Font("Arial", Font.BOLD, 12));pSeven.setForeground(new Color(98, 98, 103,255));pSeven.setLocation(850,460);
        pSeven.addActionListener(this);
        win.add(pSeven);

        pEight = new JButton("8");pEight.setSize(50,35);pEight.setFont(new Font("Arial", Font.BOLD, 12));pEight.setForeground(new Color(98, 98, 103,255));pEight.setLocation(850,520);
        pEight.addActionListener(this);
        win.add(pEight);

        pNine = new JButton("9");pNine.setSize(50,35);pNine.setFont(new Font("Arial", Font.BOLD, 12));pNine.setForeground(new Color(98, 98, 103,255));pNine.setLocation(850,580);
        pNine.addActionListener(this);
        win.add(pNine);

        pTen = new JButton("10");pTen.setSize(50,35);pTen.setFont(new Font("Arial", Font.BOLD, 12));pTen.setForeground(new Color(98, 98, 103,255));pTen.setLocation(850,640);
        pTen.addActionListener(this);
        win.add(pTen);

        pEleven = new JButton("11");pEleven.setSize(50,35);pEleven.setFont(new Font("Arial", Font.BOLD, 12));pEleven.setForeground(new Color(98, 98, 103,255));pEleven.setLocation(850,700);
        pEleven.addActionListener(this);
        win.add(pEleven);

        pTwelve = new JButton("12");pTwelve.setSize(50,35);pTwelve.setFont(new Font("Arial", Font.BOLD, 12));pTwelve.setForeground(new Color(98, 98, 103,255));pTwelve.setLocation(850,760);
        pTwelve.addActionListener(this);
        win.add(pTwelve);

        pThirteen = new JButton("13");pThirteen.setSize(50,35);pThirteen.setFont(new Font("Arial", Font.BOLD, 12));pThirteen.setForeground(new Color(98, 98, 103,255));pThirteen.setLocation(850,820);
        pThirteen.addActionListener(this);
        win.add(pThirteen);

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = "/Image/HelpMenu/" ;
        if(e.getSource()==pOne){
            link+="p1.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pTwo){
            link+="p2.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pThree){
            link+="p3.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pFour){
            link+="p4.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pFive){
            link+="p5.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pSix){
            link+="p6.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pSeven){
            link+="p7.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pEight){
            link+="p8.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pNine){
            link+="p9.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pTen){
            link+="p10.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pEleven){
            link+="p11.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pTwelve){
            link+="p12.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==pThirteen){
            link+="p13.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }
        else if(e.getSource()==back){
            dispose();
        }
    }
}
