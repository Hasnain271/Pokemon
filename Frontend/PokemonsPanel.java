import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;


public class PokemonsPanel {
    private JPanel pokemonPanel = new JPanel();
    private GridBagLayout gl = new GridBagLayout();
    private JButton pokemonOne;
    private JButton pokemonTwo;
    private JButton pokemonThree;
    private JButton back = new JButton("Back!");
    private int[] x = getNonPlayingPokemon(BattlePanel.pokemonsHuman, BattlePanel.getAttackPokemon());
    static int[] p = getNonPlayingPokemon(BattlePanel.pokemonsAI, BattlePanel.getDefensePokemon());



    public PokemonsPanel() {
        pokemonPanel.setLayout(gl);

        
        pokemonOneButton();
        pokemonTwoButton();
        pokemonThreeButton();
        back();

    }


    public JPanel getPokemonsPanel() {
        return pokemonPanel;
    }



    public void pokemonOneButton() {
        pokemonOne = new JButton(BattlePanel.pokemonsHuman[x[0]].getName());
        pokemonPanel.add(pokemonOne);
        pokemonOne.setPreferredSize(new Dimension(192, 100));

        pokemonOne.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                int[] z = Arrays.copyOf(x, x.length);
                x[0] = BattlePanel.indexOfPokemon;
                pokemonOne.setText(BattlePanel.getAttackPokemon().getName());
                BattlePanel.indexOfPokemon = z[0];
                MovesPanel.setAllMoves();
                BattlePanel.setHumanPokemon();
                BattlePanel.setHumanHealth();
                GUI.end();
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                GUI.robot.playTurn();
                GUI.end();
            }
        });
    }

    public void pokemonTwoButton () {
        pokemonTwo = new JButton(BattlePanel.pokemonsHuman[x[1]].getName());
        pokemonPanel.add(pokemonTwo);
        pokemonTwo.setPreferredSize(new Dimension(192, 100));

        pokemonTwo.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                int[] z = Arrays.copyOf(x, x.length);
                x[1] = BattlePanel.indexOfPokemon;
                pokemonTwo.setText(BattlePanel.getAttackPokemon().getName());
                BattlePanel.indexOfPokemon = z[1];
                MovesPanel.setAllMoves();
                BattlePanel.setHumanPokemon();
                BattlePanel.setHumanHealth();
                GUI.end();
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                GUI.robot.playTurn();
                GUI.end();
            }
        });
    }

    public void pokemonThreeButton() {
        pokemonThree = new JButton(BattlePanel.pokemonsHuman[x[2]].getName());
        pokemonPanel.add(pokemonThree);
        pokemonThree.setPreferredSize(new Dimension(192, 100));

        pokemonThree.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                int[] z = Arrays.copyOf(x, x.length);
                x[2] = BattlePanel.indexOfPokemon;
                pokemonThree.setText(BattlePanel.getAttackPokemon().getName());
                BattlePanel.indexOfPokemon = z[2];
                MovesPanel.setAllMoves();
                BattlePanel.setHumanPokemon();
                BattlePanel.setHumanHealth();
                GUI.end();
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                GUI.robot.playTurn();
                GUI.end();
            }
        });
    }

    public void back() {
        pokemonPanel.add(back);
        back.setPreferredSize(new Dimension(192, 100));

        back.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }


    public static int[] getNonPlayingPokemon(Pokemon[] p, Pokemon o) {
        int[] t = new int[3];
        int i = 0;
        int l = 0;
        for (Pokemon x : p) {
            if (!x.equals(o)) {
                t[i] = l;
                i++;
                l++;
            } else if (x.equals(o)) {
                l++;
            }
        }

        return t;
    }


}

    



