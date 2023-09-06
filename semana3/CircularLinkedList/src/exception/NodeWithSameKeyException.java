package exception;

public class NodeWithSameKeyException extends RuntimeException{

    private String message;

    public NodeWithSameKeyException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
