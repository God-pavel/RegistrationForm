package springboot.exception;

public class NotUniqueException extends RuntimeException {
    private String login;

    public NotUniqueException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}