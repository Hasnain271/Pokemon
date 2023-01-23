import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;


public class BattlePanel {
    private JPanel battlePanel = new JPanel();
    //private Pokemon[] pokemonsHuman;
    //private Pokemon[] pokemonsAI;
    //private JLabel pokemonHumanIMG = new JLabel();
    //private JLabel pokemonAIIMG = new JLabel();
    private GridBagLayout gl = new GridBagLayout();
    private JButton attackButton = new JButton("Attack!");
    private JButton bagButton = new JButton("Bag!");
    private JButton runButton = new JButton("Run!");
    private JButton pokemonsButton = new JButton("Pokemon!");
    private GridBagConstraints constraints = new GridBagConstraints();

    public BattlePanel() {
        battlePanel.setLayout(gl);

        //pokemonsHuman = human.getTeam();




        getConstraints(0);
        gl.setConstraints(attackButton, constraints);
        battlePanel.add(attackButton);
        attackButton();

        getConstraints(1);
        gl.setConstraints(bagButton, constraints);
        battlePanel.add(bagButton);
        bagButton();

        getConstraints(3);
        gl.setConstraints(runButton, constraints);
        battlePanel.add(runButton);
        runButton();

        getConstraints(2);
        gl.setConstraints(pokemonsButton, constraints);
        battlePanel.add(pokemonsButton);
        pokemonsButton();



        battlePanel.setVisible(true);
        
        
    }

    public void getConstraints(int num) {
        // constraints.fill = GridBagConstraints.NONE;
        // constraints.weightx = 0;
        // constraints.weighty = 0;    
        constraints.gridx = num;
        constraints.gridy = 1;
        // constraints.gridwidth = 1;
        // constraints.gridheight = 1;

    }


    public JPanel getBattlePanel() {
        return battlePanel;
    }

    public void attackButton() {
    attackButton.setPreferredSize(new Dimension(192, 100));

    }

    public void bagButton() {
        bagButton.setPreferredSize(new Dimension(192, 100));

        bagButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Bag Panel");
            }
        });
    }

    public void runButton() {
        runButton.setPreferredSize(new Dimension(192, 100));
        runButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Start Panel");
            }
        });
    }


    public void pokemonsButton() {
        pokemonsButton.setPreferredSize(new Dimension(192, 100));
    }



}
