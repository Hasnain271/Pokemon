import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattlePanel {
    private JPanel battlePanel = new JPanel();
    private Pokemon pokemon;
    private GridLayout gl = new GridLayout(2, 2);
    private JButton attack = new JButton("Attack!");
    private JButton bag = new JButton("Bag");
    private JButton run = new JButton("Run");
    private JButton pokemons = new JButton("Pokemon");

    public BattlePanel() {

        battlePanel.setLayout(gl);
        battlePanel.add(attack);
        battlePanel.add(bag);
        battlePanel.add(run);
        battlePanel.add(pokemons);
        runButton();
    }


    public JPanel getBattlePanel() {
        return battlePanel;
    }

    public void attackButton() {

    }

    public void bagButton() {

    }

    public void runButton() {

        run.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Start Panel");
            }
        });
    }

    public void pokemonsButton() {

    }



}
