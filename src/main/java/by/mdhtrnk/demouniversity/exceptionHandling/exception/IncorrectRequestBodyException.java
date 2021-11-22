package by.mdhtrnk.demouniversity.exceptionHandling.exception;

public class IncorrectRequestBodyException extends RuntimeException{

    public IncorrectRequestBodyException(String message) {
        super(message);
    }
}
