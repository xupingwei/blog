package link.liwei.app.blog.basic.exce;


import org.apache.shiro.authc.AuthenticationException;

/**
 * AuthException 自动以异常必须继承 RuntimeException，否则无法拦截
 */
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
