import java.io.File;
import java.util.Scanner;
import java.util.Random;


public class Pokemon {
    private int num;
    private String name;
    private String type;
    private int attack;
    private int defense;
    private int hp;
    private Status status;
    private Move[] moves = new Move[4];


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

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

    public Move[] getMoves() {
        return moves;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // #,Name,Type,HP,Attack,Defense

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

    public static Move[] generatePokemonMoves() {
        Move[] t = Move.generateMoves();
        Random generator = new Random();
        Move[] x = new Move[4];

        for (int i = 0; i < 4; i++) {
            x[i] = t[generator.nextInt(162)];
        }

        while (x[0].equals(x[1]) || x[0].equals(x[2]) || x[0].equals(x[3]) || x[1].equals(x[2]) || x[1].equals(x[3]) || x[2].equals(x[3])) {
            for (int i = 0; i < 4; i++) {
                x[i] = t[generator.nextInt(162)];
            }
        }

        return x;

    }

    public boolean equals(Pokemon e) {
        if (this.getName().equals(e.getName())) {
            return true;
        }
        return false;
    }

    public boolean hasStatus() {
        if (!status.getName().equals("None")) {
            return true;
        }
        return false;
    }

    public boolean isFeinted() {
        if (this.getHp() < 1) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        Pokemon[] x = Pokemon.generatePokemons();
        
        for (Pokemon e : x) {
            System.out.println(e.getName());
        }
    }



}