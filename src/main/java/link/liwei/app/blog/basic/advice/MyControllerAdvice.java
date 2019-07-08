package link.liwei.app.blog.basic.advice;

import link.liwei.app.blog.basic.Constants;
import link.liwei.app.blog.basic.entity.ResultBean;
import link.liwei.app.blog.basic.exce.AuthException;
import link.liwei.app.blog.basic.utils.ResultUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xupingwei
 * @date 14:06 2018-04-04
 */
@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局异常捕捉处理
     *
     * @param ex 全局异常
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBean errorExce(Exception ex) {
        ex.printStackTrace();
        if (ex instanceof NullPointerException) {
            return ResultUtils.failure("NullPointerException", Constants.FAILURE);
        }
        return ResultUtils.failure(ex.getMessage(), Constants.FAILURE);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResultBean errorRunExce(RuntimeException ex) {
        ex.printStackTrace();
        return ResultUtils.failure(ex.getMessage(), Constants.FAILURE);
    }


    @ExceptionHandler(value = AuthException.class)
    public ResultBean errorAuth(HttpServletRequest httpServletRequest, AuthException ex) {
        ex.printStackTrace();
        return ResultUtils.failure(ex.getMessage(), Constants.FAILURE);
    }
}
