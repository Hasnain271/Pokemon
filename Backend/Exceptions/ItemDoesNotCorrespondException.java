package Exceptions;

public class ItemDoesNotCorrespondException extends Exception {
    
    public ItemDoesNotCorrespondException() {
        super("You do not have the correct item for the status afflicted!");
    }

    public ItemDoesNotCorrespondException(String message) {
        super(message);
    }
}
