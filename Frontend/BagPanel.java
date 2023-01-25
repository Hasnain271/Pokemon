import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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


        itemOne();
        itemTwo();
        itemThree();
        itemFour();
        backButton();
        

        bagPanel.setVisible(true);

    }


    public JPanel getBagPanel() {
        return bagPanel;
    }


    public void backButton() {
        backButton = new JButton("Back!");
        backButton.setPreferredSize(new Dimension(190, 100));
        bagPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }

    public void itemOne() {
        item1 = new JButton(GUI.human.getBag().getItems().get(0).getName());
        item1.setPreferredSize(new Dimension(190, 100));
        bagPanel.add(item1);

        item1.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });

    }

    public void itemTwo() {
        item2 = new JButton(GUI.human.getBag().getItems().get(1).getName());
        item2.setPreferredSize(new Dimension(190, 100));
        bagPanel.add(item2);

        item2.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }

    public void itemThree() {
        item3 = new JButton(GUI.human.getBag().getItems().get(2).getName());
        item3.setPreferredSize(new Dimension(190, 100));
        bagPanel.add(item3);

        item3.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }

    public void itemFour() {
        item4 = new JButton(GUI.human.getBag().getItems().get(3).getName());
        item4.setPreferredSize(new Dimension(190, 100));
        bagPanel.add(item4);

        item4.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }


}
