package exception;

public class NodeNotFoundException extends Exception{
    private String message;

    public NodeNotFoundException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
