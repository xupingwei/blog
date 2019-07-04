package link.liwei.app.blog.basic.utils;


import link.liwei.app.blog.basic.Constants;
import link.liwei.app.blog.basic.entity.ResultBean;

public class ResultUtils {

    public static ResultBean success(Object obj) {
        ResultBean bean = new ResultBean("成功", 0);
        bean.setData(obj);
        return bean;
    }

    public static ResultBean success() {
        ResultBean bean = new ResultBean("成功", 0);
        return bean;
    }

    public static ResultBean failure(String msg, int code) {
        return new ResultBean(msg, code);
    }

    public static ResultBean failure(int code) {
        return new ResultBean(Constants.VALUES.get(code), code);
    }

    public static ResultBean failure(String msg) {
        return new ResultBean(msg, Constants.FAILURE);
    }
}
