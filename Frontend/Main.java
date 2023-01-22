import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends javax.swing.JFrame {
    DrawAPanel startBG = new DrawAPanel("/Users/hasnain/Desktop/Pokemon/assets/StartscreenBG.jpeg");
    DrawAPanel battleBG = new DrawAPanel("/Users/hasnain/Desktop/Pokemon/assets/PokemonBattleBG.png");


    public Main() {
        setLayout(new CardLayout());
        JButton play = new JButton("Play!");
        startBG.add(play);

        add(startBG, "Start");
        add(battleBG, "battle");

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
                cardLayout.next(getContentPane());
            }
        });

        setSize(960, 573);
        setVisible(true);
        //pack();
    }


    public static void main(String[] args) {
        Main t = new Main();
    }

}
