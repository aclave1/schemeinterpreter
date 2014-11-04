/**
 * Created by al on 10/29/14.
 */
public class InvalidApplyException extends Exception {
    public InvalidApplyException(String message) {
        super(message);
    }
    public InvalidApplyException() {
        super("");
    }
}
