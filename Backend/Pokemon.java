import java.io.File;
import java.util.Scanner;


public class Pokemon {
    private String name;
    private String type;
    private int attack;
    private int defense;
    private int hp;
    private Status status;
    private Move[] move = new Move[4];


    public Pokemon(String name, String type, int hp, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
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
                pokemons[i] = new Pokemon(lineSplit[1], lineSplit[2], Integer.valueOf(lineSplit[3]), Integer.valueOf(lineSplit[4]), Integer.valueOf(lineSplit[5]));
                i++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return pokemons;
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

    public String toString() {
        return this.name;
    }



    public static void main(String[] args) {
        Pokemon[] x = Pokemon.generatePokemons();
        
        for (Pokemon e : x) {
            System.out.println(e.toString());
        }
    }



}