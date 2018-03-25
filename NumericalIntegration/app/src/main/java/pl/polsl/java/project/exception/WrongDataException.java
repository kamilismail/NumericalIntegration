package pl.polsl.java.project.exception;

/**
 * @author Kamil Ismail
 * @version 3.0
 */
/**
 * My own exception. It extends from Exception.
 */
public class WrongDataException extends Exception {

    /**
     * Methode that uses 'super' to show info of the occured exception.
     *
     * @param info
     */
    public WrongDataException(String info) {
        super(info);
    }
}
