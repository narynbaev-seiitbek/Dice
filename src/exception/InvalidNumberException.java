package exception;

public class InvalidNumberException extends IllegalArgumentException{
    public InvalidNumberException() {
    }

    public InvalidNumberException(String s) {
        super(s);
    }
}
