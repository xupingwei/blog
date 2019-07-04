package link.liwei.app.blog.basic.exce;

import org.apache.shiro.authc.AuthenticationException;

public class AuthException extends AuthenticationException {

    private String message;

    public AuthException() {
        super();
    }

    public AuthException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
