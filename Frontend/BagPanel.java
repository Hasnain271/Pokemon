import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class BagPanel {
    private JPanel bagPanel = new JPanel();
    private GridBagLayout gl = new GridBagLayout();
    private JButton item1;
    private JButton item2;
    private JButton item3;
    private JButton item4;
    private JButton backButton;
    

    public BagPanel() {

        bagPanel.setLayout(gl);
        // item1 = new JButton(GUI.human.getBag().getItems().get(0).getName());
        // item2 = new JButton(GUI.human.getBag().getItems().get(1).getName());
        // item3 = new JButton(GUI.human.getBag().getItems().get(2).getName());
        // item4 = new JButton(GUI.human.getBag().getItems().get(3).getName());
        backButton = new JButton("Back!");

        // bagPanel.add(item1);
        // bagPanel.add(item2);
        // bagPanel.add(item3);
        // bagPanel.add(item4);
        bagPanel.add(backButton);

        bagPanel.setVisible(true);

    }


    public JPanel getBagPanel() {
        return bagPanel;
    }


}
