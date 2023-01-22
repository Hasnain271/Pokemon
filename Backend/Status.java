import java.util.Scanner;
import java.io.File;

public class Status {
    private String name;
    private Move move;


    public Status(String name, Move move) {
        this.name = name;
        this.move = move;
    }

    public Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Move getMove() {
        return move;
    }

    public static Status[] generateStatus() {
        Status[] x = new Status[19];
        Move[] t = Move.generateMoves();
        int i = 0;
        try {
            File file = new File("assets/special_status_pokemon.csv");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] lineSplit = line.split(",");
                int index = Move.findMoveIndex(t, lineSplit[0]);
                x[i] = new Status(lineSplit[1], t[index]);
                i++;
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return x;
    }


    public static void main(String[] args) {
        Status[] x = Status.generateStatus();
        System.out.println(x.length);

        for (Status t : x) {
            System.out.println(t.getName());
        }
    }

}
