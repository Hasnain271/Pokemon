import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;


public class ShowDamagePanel {
    private JPanel damagePanel = new JPanel();
    static JLabel damageString = new JLabel();


    public ShowDamagePanel() {

        damagePanel.setBackground(Color.GRAY);
        damagePanel.add(damageString);

 

    }

    public JPanel getDamagePanel() {
        return damagePanel;
    }

    public static String getDamageValue() {
        return String.valueOf(GUI.human.totalDamage(GUI.human.getTeam()[BattlePanel.indexOfPokemon], GUI.robot.getTeam()[BattlePanel.indexOfAIPokemon], GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[MovesPanel.indexOfMove]));
    }

}
