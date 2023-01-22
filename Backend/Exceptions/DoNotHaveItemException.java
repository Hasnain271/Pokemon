package Exceptions;

public class DoNotHaveItemException extends Exception {
    
    public DoNotHaveItemException() {
        super("You do not have this item!");
    }


    public DoNotHaveItemException(String message) {
        super(message);
    }
}
