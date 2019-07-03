package springboot.exception;

public class WrongPasswordException extends RuntimeException {
    private String login;

    public WrongPasswordException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}