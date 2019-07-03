package springboot.exception;

public class NoUserException extends RuntimeException {
    private String login;

    public NoUserException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}