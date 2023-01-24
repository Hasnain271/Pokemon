import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JProgressBar;
import java.awt.Color;


public class BattlePanel {
    private JPanel battlePanel = new JPanel();

    static Pokemon[] pokemonsHuman = GUI.human.getTeam();
    static Pokemon[] pokemonsAI = GUI.robot.getTeam();

    private JProgressBar humanHealth = new JProgressBar();
    private JProgressBar robotHealth = new JProgressBar();
    private int[] humanMaxHP = maxHumanHPS();
    private int[] robotMaxHP = maxAIHPS();


    private JLabel pokemonHumanLABEL = new JLabel();
    private JLabel pokemonAILABEL = new JLabel();

    static int indexOfPokemon = 0;
    static int indexOfAIPokemon = 0;

    private GridBagLayout gl = new GridBagLayout();

    private JButton attackButton = new JButton("Attack!");
    private JButton bagButton = new JButton("Bag!");
    private JButton runButton = new JButton("Run!");
    private JButton pokemonsButton = new JButton("Pokemon!");

    private GridBagConstraints constraints = new GridBagConstraints();


    public BattlePanel() {
        battlePanel.setLayout(gl);

        
        attackButton();
        bagButton();
        runButton();
        pokemonsButton();


        makePlayerPokemon(indexOfPokemon);
        makeRobotPokemon(indexOfAIPokemon);
        makeHumanHealthBar();
        makeAIHealthBar();


        battlePanel.add(pokemonHumanLABEL);
        battlePanel.add(pokemonAILABEL);
        battlePanel.setVisible(true);

        
        
        
    }

    public void getButtonConstraints(int num) {
        constraints.weightx = 1;
        constraints.weighty = 1;    
        constraints.gridx = num;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

    }


    public void getImageConstraints(int num) {
        constraints.gridx = num;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;
    }

    public void getHealthBarConstraints(int num) {
        constraints.gridx = num;
        constraints.gridy = 1;
    }




    public JPanel getBattlePanel() {
        return battlePanel;
    }

    public void attackButton() {
        attackButton.setPreferredSize(new Dimension(192, 100));
        battlePanel.add(attackButton);
        getButtonConstraints(0);
        gl.setConstraints(attackButton, constraints);

        attackButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Moves Panel");
            }
        });



    }

    public void bagButton() {
        bagButton.setPreferredSize(new Dimension(192, 100));
        battlePanel.add(bagButton);
        getButtonConstraints(1);
        gl.setConstraints(bagButton, constraints);

        bagButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Bag Panel");
            }
        });
    }

    public void runButton() {
        runButton.setPreferredSize(new Dimension(192, 100));
        battlePanel.add(runButton);
        getButtonConstraints(3);
        gl.setConstraints(runButton, constraints);

        runButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Start Panel");
            }
        });
    }


    public void pokemonsButton() {
        pokemonsButton.setPreferredSize(new Dimension(192, 100));
        battlePanel.add(pokemonsButton);
        getButtonConstraints(2);
        gl.setConstraints(pokemonsButton, constraints);
    }


    public void makePlayerPokemon(int index) {
        String pokeNum = String.valueOf(pokemonsHuman[index].getNum());
        ImageIcon playerPokemonICON = new ImageIcon("assets/back/" + pokeNum + ".png");
        Image scaledImg = playerPokemonICON.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        playerPokemonICON = new ImageIcon(scaledImg);
        pokemonHumanLABEL.setIcon(playerPokemonICON);
        getImageConstraints(0);
        gl.setConstraints(pokemonHumanLABEL, constraints);

        
    }

    public void makeHumanHealthBar() {
        humanHealth.setMinimum(0);
        humanHealth.setMaximum(humanMaxHP[indexOfPokemon]);
        humanHealth.setValue(pokemonsHuman[indexOfPokemon].getHp());
        humanHealth.setForeground(Color.GREEN);
        battlePanel.add(humanHealth);
        getHealthBarConstraints(0);
        gl.setConstraints(humanHealth, constraints);
        humanHealth.setString(String.valueOf(pokemonsHuman[indexOfPokemon].getHp()) + "/" + String.valueOf(humanMaxHP[indexOfPokemon]));
        humanHealth.setStringPainted(true);
        humanHealth.setPreferredSize(new Dimension(100, 50));
        
    }

    public void makeRobotPokemon(int index) {
        String pokeNum = String.valueOf(pokemonsAI[index].getNum());
        ImageIcon robotPokemonICON = new ImageIcon("assets/front/" + pokeNum + ".png");
        Image scaledImg = robotPokemonICON.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
        robotPokemonICON = new ImageIcon(scaledImg);
        pokemonAILABEL.setIcon(robotPokemonICON);
        getImageConstraints(2);
        gl.setConstraints(pokemonAILABEL, constraints);
    }

    public void makeAIHealthBar() {
        robotHealth.setMinimum(0);
        robotHealth.setMaximum(robotMaxHP[indexOfAIPokemon]);
        robotHealth.setValue(pokemonsAI[indexOfAIPokemon].getHp());
        robotHealth.setForeground(Color.RED);
        battlePanel.add(robotHealth);
        getHealthBarConstraints(2);
        gl.setConstraints(robotHealth, constraints);
        robotHealth.setStringPainted(true);
        robotHealth.setPreferredSize(new Dimension(100, 50));
        robotHealth.setString(String.valueOf(pokemonsAI[indexOfAIPokemon].getHp()) + "/" + String.valueOf(robotMaxHP[indexOfAIPokemon]));

    }

    public int[] maxAIHPS() {
        int[] t = {pokemonsAI[0].getHp(), pokemonsAI[1].getHp(), pokemonsAI[2].getHp(), pokemonsAI[3].getHp()};
        return t;
    }

    public int[] maxHumanHPS() {
        int[] t = {pokemonsHuman[0].getHp(), pokemonsHuman[1].getHp(), pokemonsHuman[2].getHp(), pokemonsHuman[3].getHp()};
        return t;
    }

    public static void main(String[] args) {
    
    }



}
