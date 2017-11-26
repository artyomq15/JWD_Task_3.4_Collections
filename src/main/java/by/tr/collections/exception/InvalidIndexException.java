package by.tr.collections.exception;

public class InvalidIndexException extends RuntimeException{
    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }

    public InvalidIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidIndexException(Throwable cause) {
        super(cause);
    }
}
