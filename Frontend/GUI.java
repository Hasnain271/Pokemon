import java.awt.CardLayout;
import javax.swing.JFrame;

public class GUI  {
    static CardLayout cl = new CardLayout();
    static JFrame panels = new JFrame();
    static Player human = new Player();
    static AI robot = new AI();

    public GUI() {
        panels.setSize(960, 573);
        panels.setLayout(cl);
        panels.add(new StartPanel().getStartPanel(), "Start Panel");
        panels.add(new BattlePanel().getBattlePanel(), "Battle Panel");
        panels.add(new BagPanel().getBagPanel(), "Bag Panel");
        panels.add(new MovesPanel().getMovesPanel(), "Moves Panel");
        panels.add(new ShowDamagePanel().getDamagePanel(), "Damage Panel");
        panels.add(new PokemonsPanel().getPokemonsPanel(), "Pokemons Panel");
        panels.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panels.setResizable(false);
        panels.setVisible(true);
        


    }



    public static void main(String[] args) {
        GUI t = new GUI();
    }
}
