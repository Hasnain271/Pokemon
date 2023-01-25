import java.util.Random;
import java.util.ArrayList;

public class AI extends Player {
    
    public AI() {
        super();
    }


    /**
     * Let the computer play the turn
     */
    public void playTurn() {
        if (BattlePanel.getDefensePokemon().isFeinted()) {
            changePokemon();
        } else if (BattlePanel.getDefensePokemon().hasStatus()) {
            if (hasAnItemForStatus(BattlePanel.getDefensePokemon(), getBag().getItems())) {
                playItem();
            }

        } else {
            playAttack();
        }

    }


    /**
     * Play an item from your bag
     */
    public void playItem() {
        for (int i = 0; i < getBag().getItems().size(); i++) {
            if (getBag().getItems().get(i).equals(BattlePanel.getDefensePokemon().getStatus())) {
                useItem(BattlePanel.getDefensePokemon(), getBag().getItems().get(i));
                break;
            }
        }
    }

    /**
     * Play a randomized move to deal an attack
     */
    public void playAttack() {
        GUI.robot.attack(BattlePanel.getDefensePokemon(), BattlePanel.getAttackPokemon(), BattlePanel.pokemonsAI[BattlePanel.indexOfAIPokemon].getMoves()[getRandomMoveIndex()]);
        BattlePanel.humanStatus.setText("Status: " + BattlePanel.getAttackPokemon().getStatus().getName());
        BattlePanel.setHumanHealth();

    }


    /**
     * Change which pokemon the computer is using to battle
     */
    public void changePokemon() {
        int i = 0;
        for (Pokemon t : BattlePanel.pokemonsAI) {
            if (!t.isFeinted() && !t.hasStatus()) {
                BattlePanel.indexOfAIPokemon = i;
                BattlePanel.setRobotPokemon();
                BattlePanel.setRobotHealth();
                break;
            } 
            i++;
        }

    }


    
    /** 
     * Get a random number between 0-3 
     * @return int
     */
    private int getRandomMoveIndex() {
        Random generator = new Random();
        return generator.nextInt(4);
    }


    
    /** 
     * Check if AI has an item for the status of a pokemon by going an bag of items the AI has
     * @param p
     * @param b
     * @return boolean
     */
    public boolean hasAnItemForStatus(Pokemon p, ArrayList<Item> b) {
        for (Item t : b) {
            if (t.equals(p.getStatus())) {
                return true;
            }
        }
        return false;
    }



}
