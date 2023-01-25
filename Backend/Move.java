import java.io.File;
import java.util.Scanner;

public class Move {
    private String name; // The name of the move
    private String type; // The type of the move
    private int power; // The power of the move


    public Move(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    
    /** 
     * Get the name of the move
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Get the type of the move
     * @return String
     */
    public String getType() {
        return type;
    }

    
    /** 
     * Get the power of the move
     * @return int
     */
    public int getPower() {
        return power;
    }


    
    /** 
     * Generates all moves read from the moves.csv file
     * @return Move[]
     */
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

    
    /** 
     * Find the index of a move using the name of the move
     * @param e
     * @param name
     * @return int
     */
    public static int findMoveIndex(Move[] e, String name) {
        int index = 0;
        for (int i = 0; i < e.length; i++) {
            if (name.equals(e[i].name)) {
                index = i;
            }
        }

        return index;
    }

    
    /** 
     * Checks if one moves name is equal to another moves naem
     * @param e
     * @return boolean
     */
    public boolean equals(Move e) {
        if (this.name.equals(e.name)) {
            return true;
        }
        return false;
    }
}
