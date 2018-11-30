package image;

public class NotSupportedException extends RuntimeException {

    public String errorMessage;

    public NotSupportedException(String errorMessage){
        super(errorMessage);
    }
}
