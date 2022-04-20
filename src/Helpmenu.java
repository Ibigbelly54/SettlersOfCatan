import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Helpmenu extends JFrame implements ActionListener {
    private JButton back, pOne, pTwo, pThree, pFour, pFive, pSix, pSeven, pEight, pNine, pTen, pEleven, pTwelve, pThirteen;
    private JLabel heading, page, general,navigation;
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 1100;

    public Helpmenu() {
        super("Help Menu");
        Container win = getContentPane();
        win.setLayout(null);

        heading = new JLabel("Help Menu");heading.setSize(750, 60);heading.setFont(new Font("Arial", Font.BOLD, 50));heading.setForeground(new Color(98, 98, 103, 255));heading.setHorizontalAlignment(JLabel.CENTER);heading.setVerticalAlignment(JLabel.CENTER);
        win.add(heading);

        page = new JLabel();page.setSize(642, 900);page.setLocation(150,100);
        win.add(page);
        ImageIcon icon = new ImageIcon("src/Image/p1.png");
        page.setIcon(icon);

        back = new JButton("Back");
        back.setSize(100,45);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(new Color(98, 98, 103,255));
        back.setLocation(30,75);
        back.addActionListener(this);
        win.add(back);

        general = new JLabel("General Rules");general.setSize(100,50);general.setLocation(850,50);
        general.setFont(new Font("Arial", Font.BOLD, 14));
        win.add(general);



        pOne = new JButton("1");pOne.setSize(50,35);
        pOne.setFont(new Font("Arial", Font.BOLD, 12));pOne.setForeground(new Color(98, 98, 103,255));pOne.setLocation(825,100);
        pOne.addActionListener(this);
        win.add(pOne);

        pTwo= new JButton("2");pTwo.setSize(50,35);
        pTwo.setFont(new Font("Arial", Font.BOLD, 12));pTwo.setForeground(new Color(98, 98, 103,255));pTwo.setLocation(825,175);
        pTwo.addActionListener(this);
        win.add(pTwo);

        pThree = new JButton("3");pThree.setSize(50,35);
        pThree.setFont(new Font("Arial", Font.BOLD, 12));pThree.setForeground(new Color(98, 98, 103,255));pThree.setLocation(825,250);
        pThree.addActionListener(this);
        win.add(pThree);

        pFour = new JButton("4");pFour.setSize(50,35);
        pFour.setFont(new Font("Arial", Font.BOLD, 12));pFour.setForeground(new Color(98, 98, 103,255));pFour.setLocation(825,325);
        pFour.addActionListener(this);
        win.add(pFour);

        pFive = new JButton("5");pFive.setSize(50,35);
        pFive.setFont(new Font("Arial", Font.BOLD, 12));pFive.setForeground(new Color(98, 98, 103,255));pFive.setLocation(825,400);
        pFive.addActionListener(this);
        win.add(pFive);

        pSix = new JButton("6");pSix.setSize(50,35);
        pSix.setFont(new Font("Arial", Font.BOLD, 12));pSix.setForeground(new Color(98, 98, 103,255));pSix.setLocation(825,475);
        pSix.addActionListener(this);
        win.add(pSix);

        pSeven = new JButton("7");pSeven.setSize(50,35);
        pSeven.setFont(new Font("Arial", Font.BOLD, 12));pSeven.setForeground(new Color(98, 98, 103,255));pSeven.setLocation(825,550);
        pSeven.addActionListener(this);
        win.add(pSeven);

        pEight = new JButton("8");pEight.setSize(50,35);
        pEight.setFont(new Font("Arial", Font.BOLD, 12));pEight.setForeground(new Color(98, 98, 103,255));pEight.setLocation(825,625);
        pEight.addActionListener(this);
        win.add(pEight);

        pNine = new JButton("9");pNine.setSize(50,35);
        pNine.setFont(new Font("Arial", Font.BOLD, 12));pNine.setForeground(new Color(98, 98, 103,255));pNine.setLocation(925,100);
        pNine.addActionListener(this);
        win.add(pNine);

        pTen = new JButton("10");pTen.setSize(50,35);
        pTen.setFont(new Font("Arial", Font.BOLD, 12));pTen.setForeground(new Color(98, 98, 103,255));pTen.setLocation(925,175);
        pTen.addActionListener(this);
        win.add(pTen);

        pEleven = new JButton("11");pEleven.setSize(50,35);
        pEleven.setFont(new Font("Arial", Font.BOLD, 12));pEleven.setForeground(new Color(98, 98, 103,255));pEleven.setLocation(925,250);
        pEleven.addActionListener(this);
        win.add(pEleven);

        pTwelve = new JButton("12");pTwelve.setSize(50,35);
        pTwelve.setFont(new Font("Arial", Font.BOLD, 12));pTwelve.setForeground(new Color(98, 98, 103,255));pTwelve.setLocation(925,325);
        pTwelve.addActionListener(this);
        win.add(pTwelve);

        pThirteen = new JButton("13");pThirteen.setSize(50,35);
        pThirteen.setFont(new Font("Arial", Font.BOLD, 12));pThirteen.setForeground(new Color(98, 98, 103,255));pThirteen.setLocation(925,400);
        pThirteen.addActionListener(this);
        win.add(pThirteen);
        /*n1 = new JButton("1");n1.setSize(50,35);n1.setFont(new Font("Arial", Font.BOLD, 12));n1.setForeground(new Color(98, 98, 103,255));n1.setLocation(900,100);
        n1.addActionListener(this);
        win.add(n1);*/

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String link = "/Image/" ;
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
        /*else if(e.getSource()==n1){
            link+="new1.PNG";
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(Helpmenu.class.getResource(link)));
            page.setIcon(icon);
        }*/
    }
}
