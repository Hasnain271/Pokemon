import java.util.Scanner;
import java.io.File;

public class Status {
    private String name; // The name of the status
    private Move move; // What move can cause the status


    public Status(String name, Move move) {
        this.name = name;
        this.move = move;
    }

    public Status(String name) {
        this.name = name;
    }

    
    /** 
     * Get the name of a status
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Get the move 
     * @return Move
     */
    public Move getMove() {
        return move;
    }

    
    /** 
     * Generates all the status' read from the special_status_pokemon.csv file
     * @return Status[]
     */
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

}
