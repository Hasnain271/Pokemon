import java.awt.CardLayout;
import javax.swing.JFrame;

public class GUI  {
    static CardLayout cl = new CardLayout();
    static JFrame panels = new JFrame();

    public GUI() {
        panels.setSize(960, 573);
        panels.setLayout(cl);
        panels.add(new StartPanel().getStartPanel(), "Start Panel");
        panels.add(new BattlePanel().getBattlePanel(), "Battle Panel");
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panels.setResizable(false);
        panels.setVisible(true);
        

    }



    public static void main(String[] args) {
        GUI t = new GUI();
    }
}
