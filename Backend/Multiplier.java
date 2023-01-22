import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class Multiplier {
    double[][] multipliers = new double[18][18];

    public Multiplier() {
        generateMultiplier();
    }

    public void generateMultiplier() {

        try {
            File file = new File("assets/multiplier.csv");
            Scanner input = new Scanner(file);
            int t = 0;
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.startsWith("//")) {
                    continue;
                }
                String[] lineSplit = line.split(",");
                int z = 0;
                for (int i = 1; i < lineSplit.length; i++) {
                    multipliers[t][z] = Double.valueOf(lineSplit[i]);
                    z++;
                }
                t++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public double getMultiplier(Pokemon attack, Pokemon defense) {
        int[] x = convertTypeToIndex(attack, defense);
        return multipliers[x[1]][x[0]];
    }

    private int[] convertTypeToIndex(Pokemon attack, Pokemon defense) {
        HashMap<String, Integer> TypeIndex = new HashMap<String, Integer>() {{
            put("Normal", 0);
            put("Fighting", 1);
            put("Flying", 2);
            put("Poison", 3);
            put("Ground", 4);
            put("Rock", 5);
            put("Bug", 6);
            put("Ghost", 7);
            put("Steel", 8);
            put("Fire", 9);
            put("Water", 10);
            put("Grass", 11);
            put("Electric", 12);
            put("Psychic", 13);
            put("Ice", 14);
            put("Dragon", 15);
            put("Dark", 16);
            put("Fairy", 17);
        }};

        int[] x = new int[2];

        x[1] = TypeIndex.get(defense.getType());
        x[0] = TypeIndex.get(attack.getType());

        return x;
        
    }

    public static void main(String[] args) {
        Multiplier t = new Multiplier();
        Pokemon[] x = Pokemon.generatePokemons();
        t.getMultiplier(x[3], x[0]);
        System.out.println(t.getMultiplier(x[3], x[0]));
    }
    

}
