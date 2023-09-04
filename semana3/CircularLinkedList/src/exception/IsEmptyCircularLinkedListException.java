package exception;

public class IsEmptyCircularLinkedListException extends Exception{

    private String message;

    public IsEmptyCircularLinkedListException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
