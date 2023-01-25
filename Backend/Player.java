import java.util.Random;


public class Player {

    protected Pokemon[] team = new Pokemon[4]; // Represents the four pokemon a player has
    protected Bag bag; // Represents a bag of items a player has

    public Player() {
        bag = new Bag();
        generateTeam();
    }


    
    /** 
     * Gets the team of pokemon
     * @return Pokemon[]
     */
    public Pokemon[] getTeam() {
        return team;
    }

    
    /** 
     * Gets the bag
     * @return Bag
     */
    public Bag getBag() {
        return bag;
    }


    // Generates a team of four unique pokemon
    public void generateTeam() {

        team = generateRandomPokemon();
        // While loop ensures there are no duplicate pokemon
        while (team[0].equals(team[1]) || team[0].equals(team[2]) || team[0].equals(team[3]) || team[1].equals(team[2]) || team[1].equals(team[3]) || team[2].equals(team[3])) {
            team = generateRandomPokemon();
        }
    }


    
    /** 
     * Private method to help generate a team for a player
     * @return Pokemon[]
     */
    private Pokemon[] generateRandomPokemon() {
        Pokemon[] pokemons = Pokemon.generatePokemons();
        Random generator = new Random();
        Pokemon[] t = new Pokemon[4];
        

        //Generates 4 random pokemons
        for (int i = 0; i < 4; i++) {
            t[i] = pokemons[generator.nextInt(151)];
        }

        return t;
    }

    
    /** 
     * Check if a player has an item in their bag
     * @param e
     * @return boolean
     */
    public boolean hasItem(Item e) {
        for (Item z : bag.getItems()) {
            if (z.equals(e)) {
                return true;
            }
         }
         return false;
    }


    
    /** 
     * Gets the total damage the pokemon does and rounds it then returns the int value
     * @param attack
     * @param defense
     * @param m
     * @return int
     */
    public int totalDamage(Pokemon attack, Pokemon defense, Move m) {
        Multiplier e = new Multiplier();
        double damage = (6 * m.getPower() * (attack.getAttack()/defense.getDefense())/50 + 2) * e.getMultiplier(attack, defense) * 5;
        int damageInt = (int) Math.round(damage);
        return damageInt;
    }

    
    /** 
     * Checks if a move inflcits a status
     * @param e
     * @return boolean
     */
    public boolean doesMoveInflictStatus(Move e) {
        Status[] t = Status.generateStatus();

        for (Status x : t) {
            if (e.equals(x.getMove())) {
                return true;
            }
        }

        return false;

    } 


    
    /** 
     * If move can inflict a status it has a 1/4 chance of doing it
     * @param e
     * @param defense
     */
    public void inflictStatus(Move e, Pokemon defense) {
        Random generator = new Random();
        Status[] t = Status.generateStatus();

        for (Status x : t) {
            int randomNum = generator.nextInt(4);
            if (e.equals(x.getMove())) {
                if (randomNum == 0) { 
                    defense.setStatus(x);
                } else {
                    break;
                }
            } else {
                continue;
            }
        }

    }



    
    /** 
     * Use an item to cure status effect
     * @param p
     * @param e
     */
    public void useItem(Pokemon p, Item e) {
        bag.replaceItem(e, "No Item");
        p.setStatus(new Status("None"));
    }

    
    /** 
     * Checks if the player has the right item for the status the pokemon has
     * @param p
     * @param e
     * @return boolean
     */
    public boolean hasItemForStatus(Pokemon p, Item e) {
        if (e.equals(p.getStatus()) || e.getName().equals("Full Heal")) {
            return true;
        }
        return false;
    }


    
    /** 
     * Deals damage and inflicts a status
     * @param attack
     * @param defense
     * @param m
     */
    public void attack(Pokemon attack, Pokemon defense, Move m) {
        int damageInt = totalDamage(attack, defense, m);
        defense.setHp(defense.getHp() - damageInt);
        if (doesMoveInflictStatus(m)) {
            inflictStatus(m, defense);
        }
    }
    

}
