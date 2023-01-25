import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;


public class ShowDamagePanel {
    private JPanel damagePanel = new JPanel();
    static JLabel damageString = new JLabel();


    public ShowDamagePanel() {
        damagePanel.setLayout(new GridBagLayout());
        damagePanel.setBackground(Color.GRAY);
        damagePanel.add(damageString);
        //damagePanel.setVisible(true);
    

 

    }

    public JPanel getDamagePanel() {
        return damagePanel;
    }


}
