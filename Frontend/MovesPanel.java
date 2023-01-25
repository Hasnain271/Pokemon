import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class MovesPanel {
    private JPanel moves = new JPanel();
    private GridBagLayout gl = new GridBagLayout();
    private static JButton moveOne;
    private static JButton moveTwo;
    private static JButton moveThree;
    private static JButton moveFour;
    private JButton back;
    static int indexOfMove;

    public MovesPanel() {
        moves.setLayout(gl);

        moveOne();
        moveTwo();
        moveThree();
        moveFour();
        back();
        
    }

    public JPanel getMovesPanel() {
        return moves;
    }

    public void moveOne() {
        moveOne = new JButton(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[0].getName());
        moveOne.setPreferredSize(new Dimension(190, 100));
        moves.add(moveOne);

        moveOne.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                if (!BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].hasStatus() && !BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].isFeinted()) {
                    indexOfMove = 0;
                    ShowDamagePanel.damageString.setText("The damage you did was: " + ShowDamagePanel.getDamageValue());
                    ShowDamagePanel.damageString.repaint();
                    GUI.human.attack(BattlePanel.getAttackPokemon(), BattlePanel.getDefensePokemon(), BattlePanel.getAttackPokemon().getMoves()[indexOfMove]);
                    BattlePanel.humanStatus.setText("Status: " + BattlePanel.getDefensePokemon().getStatus().getName());
                    BattlePanel.setRobotHealth();

                    GUI.cl.show(GUI.panels.getContentPane(), "Damage Panel");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                        }
                    }, 2000);
    
                }
            }
        });
    }


    public static void setAllMoves() {
        moveOne.setText(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[0].getName());
        moveTwo.setText(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[1].getName());
        moveThree.setText(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[2].getName());
        moveFour.setText(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[3].getName());

    }

    public void moveTwo() {
        moveTwo = new JButton(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[1].getName());
        moveTwo.setPreferredSize(new Dimension(190, 100));
        moves.add(moveTwo);

        moveTwo.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                if (!BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].hasStatus() && !BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].isFeinted()) {
                    indexOfMove = 1;
                    ShowDamagePanel.damageString.setText("The damage you did was: " + ShowDamagePanel.getDamageValue());
                    ShowDamagePanel.damageString.repaint();
                    GUI.human.attack(BattlePanel.getAttackPokemon(), BattlePanel.getDefensePokemon(), BattlePanel.getAttackPokemon().getMoves()[indexOfMove]);
                    BattlePanel.humanStatus.setText("Status: " + BattlePanel.getDefensePokemon().getStatus().getName());
                    BattlePanel.setRobotHealth();
                    GUI.cl.show(GUI.panels.getContentPane(), "Damage Panel");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                        }
                    }, 2000);
    
                }
            }
        });
    }


    public void moveThree() {
        moveThree = new JButton(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[2].getName());
        moveThree.setPreferredSize(new Dimension(190, 100));
        moves.add(moveThree);

        moveThree.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                if (!BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].hasStatus() && !BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].isFeinted()) {
                    indexOfMove = 2;
                    ShowDamagePanel.damageString.setText("The damage you did was: " + ShowDamagePanel.getDamageValue());
                    ShowDamagePanel.damageString.repaint();
                    GUI.human.attack(BattlePanel.getAttackPokemon(), BattlePanel.getDefensePokemon(), BattlePanel.getAttackPokemon().getMoves()[indexOfMove]);
                    BattlePanel.humanStatus.setText("Status: " + BattlePanel.getDefensePokemon().getStatus().getName());
                    BattlePanel.setRobotHealth();

                    GUI.cl.show(GUI.panels.getContentPane(), "Damage Panel");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                        }
                    }, 2000);
    
                }
            }
        });
    }

    public void moveFour() {
        moveFour = new JButton(GUI.human.getTeam()[BattlePanel.indexOfPokemon].getMoves()[3].getName());
        moveFour.setPreferredSize(new Dimension(190, 100));
        moves.add(moveFour);

        moveFour.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                if (!BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].hasStatus() && !BattlePanel.pokemonsHuman[BattlePanel.indexOfPokemon].isFeinted()) {
                    indexOfMove = 3;
                    ShowDamagePanel.damageString.setText("The damage you did was: " + ShowDamagePanel.getDamageValue());
                    ShowDamagePanel.damageString.repaint();
                    GUI.human.attack(BattlePanel.getAttackPokemon(), BattlePanel.getDefensePokemon(), BattlePanel.getAttackPokemon().getMoves()[indexOfMove]);
                    BattlePanel.humanStatus.setText("Status: " + BattlePanel.getDefensePokemon().getStatus().getName());
                    BattlePanel.setRobotHealth();

                    GUI.cl.show(GUI.panels.getContentPane(), "Damage Panel");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
                        }
                    }, 2000);
    
                }
            }
        });
    }

    public void back() {
        back = new JButton("Back!");
        back.setPreferredSize(new Dimension(190, 100));
        moves.add(back);

        back.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                GUI.cl.show(GUI.panels.getContentPane(), "Battle Panel");
            }
        });
    }


}
