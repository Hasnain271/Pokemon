import java.io.File;
import java.util.Scanner;

public class Move {
    private String name;
    private String type;
    private int power;


    public Move(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPower() {
        return power;
    }


    public static Move[] generateMoves() {
        Move[] x = new Move[165];
        int i = 0;
        try {
            File file = new File("assets/moves.csv");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineSplit = line.split(",");
                x[i] = new Move(lineSplit[0], lineSplit[1], Integer.valueOf(lineSplit[2]));
                i++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return x;
    }

    public static int findMoveIndex(Move[] e, String name) {
        int index = 0;
        for (int i = 0; i < e.length; i++) {
            if (name.equals(e[i].name)) {
                index = i;
            }
        }

        return index;
    }


    public static void main(String[] args) {
        Move[] x = Move.generateMoves();

        for (Move e : x) {
            System.out.println(e.getName());
        }
    }
}
