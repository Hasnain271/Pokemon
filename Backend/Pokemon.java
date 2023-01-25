import java.io.File;
import java.util.Scanner;
import java.util.Random;


public class Pokemon {
    private int num; // Number of pokemon corresponding to the image
    private String name; 
    private String type; 
    private int attack; 
    private int defense;
    private int hp;
    private Status status;
    private Move[] moves = new Move[4]; // 4 Moves for the pokemon


    public Pokemon(int num, String name, String type, int hp, int attack, int defense, Move[] moves, Status status) {
        this.num = num;
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.moves = moves;
        this.status = status;
    }

    
    /** 
     * Get number of pokemon
     * @return int
     */
    public int getNum() {
        return num;
    }

    
    /** 
     * Get name of pokemon
     * @return String
     */
    public String getName() {
        return name;
    }
    
    
    /** 
     * Get type of pokemon
     * @return String
     */
    public String getType() {
        return type;
    }

    
    /** 
     * Get attack value of pokemon
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    
    /** 
     * Get defense value of pokemon
     * @return int
     */
    public int getDefense() {
        return defense;
    }

    
    /** 
     * Get the hp of the pokemon
     * @return int
     */
    public int getHp() {
        return hp;
    }

    
    /** 
     * Get the moves of the pokemon
     * @return Move[]
     */
    public Move[] getMoves() {
        return moves;
    }
    
    
    /** 
     * Set the hp of the pokemon to a value
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    
    /** 
     * Get the status of a pokemon
     * @return Status
     */
    public Status getStatus() {
        return status;
    }

    
    /** 
     * Set the status of a pokemon
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    
    /** 
     * Generate all pokemons read from the pokemon.csv file
     * @return Pokemon[]
     */
    
    //#,Name,Type,HP,Attack,Defense
    public static Pokemon[] generatePokemons(){
        int i = 0;
        Pokemon[] pokemons = new Pokemon[151];
        try {
            File file = new File("assets/pokemon.csv");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineSplit = line.split(",");
                pokemons[i] = new Pokemon(Integer.valueOf(lineSplit[0]), lineSplit[1], lineSplit[2], Integer.valueOf(lineSplit[3]), Integer.valueOf(lineSplit[4]), Integer.valueOf(lineSplit[5]), generatePokemonMoves(), new Status("None"));
                i++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return pokemons;
    }

    
    /** 
     * Generate 4 random moves for each pokemon.
     * Each move is read from the moves.csv file.
     * @return Move[]
     */
    private static Move[] generatePokemonMoves() {
        Move[] t = Move.generateMoves();
        Random generator = new Random();
        Move[] x = new Move[4];

        for (int i = 0; i < 4; i++) {
            x[i] = t[generator.nextInt(162)];
        }
        

        // While loop ensures each move is unique for the pokemon
        while (x[0].equals(x[1]) || x[0].equals(x[2]) || x[0].equals(x[3]) || x[1].equals(x[2]) || x[1].equals(x[3]) || x[2].equals(x[3])) {
            for (int i = 0; i < 4; i++) {
                x[i] = t[generator.nextInt(162)];
            }
        }

        return x;

    }

    
    /** 
     * Check if one pokemons name equals another pokemons name
     * @param e
     * @return boolean
     */
    public boolean equals(Pokemon e) {
        if (this.getName().equals(e.getName())) {
            return true;
        }
        return false;
    }

    
    /** 
     * Check if the pokemon has a status inflicted on it
     * @return boolean
     */
    public boolean hasStatus() {
        if (!status.getName().equals("None")) {
            return true;
        }
        return false;
    }

    
    /** 
     * Check if the pokemon is feinted (HP is less than or equal to 0)
     * @return boolean
     */
    public boolean isFeinted() {
        if (this.getHp() < 1) {
            return true;
        }
        return false;
    }
}