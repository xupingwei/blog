package link.liwei.app.blog.basic;

import java.util.HashMap;

public class Constants {
    //请求成功
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1000;
    //用户没找到
    public static final int USER_NOT_FOUNT = 1001;
    //用户已经存在
    public static final int USER_ALREADY_EXIST = 1002;
    //openid不为空
    public static final int OPENID_NOT_EMPTY = 1003;
    //token不能为空
    public static final int TOKEN_NOT_EMPTY = 1004;
    //无效的token
    public static final int TOKEN_INVALID = 1005;
    //userId不能为空
    public static final int USER_ID_NOT_EMPTY = 1006;

    public static final int KEY_NOT_EMPTY = 1007;
    //参数不能为空
    public static final int PARAMETER_NOT_EMPTY = 1008;
    //参数错误
    public static final int PARAMETER_IS_INCORRECT = 1009;
    //手机号不能为空
    public static final int PHONE_NUM_NOT_EMPTY = 1010;
    //不是一个合法的手机号
    public static final int PHONE_NUM_IS_INCORRECT = 1011;
    //密码不能为空
    public static final int PASSWORD_IS_EMPTY = 1012;
    //密码必须由数字及字母组成且长度必须大于等于6位
    public static final int PASSWORD_IS_INCORRECT = 1013;
    //当前无用户登录
    public static final int NO_USER_LOGIN = 1014;
    //旧密码不能和新密码相同
    public static final int OLDPASSWORD_NOT_SAME_NEWPASSWORD = 1015;
    //旧密码不正确
    public static final int OLDPASSWORD_IS_INCORRECT = 1016;
    //密码不正确
    public static final int PASSWORD_IS_NOT_MEET_RULE = 1017;
    //用户登录存放在session中的key
    public static final String USER_LOGIN_SESSION_KEY = "userLogin";

    public static HashMap<Integer, String> VALUES = new HashMap<>();
    //预定会议室场地订单不存在
    public static  final int MEETING_AREA_ORDER_NOT_FOUND=1018;
    //会议室角色
    public static  final int MEETING_ROLE =1019;
    //预定会议室场地时间不存在
    public static  final int MEETING_AREA_TIME_NOT_FOUND=1020;
    //预定会议室场地不存在
    public static  final int MEETING_AREA_NOT_FOUND=1021;
    //会议室预约时间冲突
    public static final int ORDER_TIME_IS_CONFLICT = 1022;
    //预约起始时间应小于预约结束时间
    public static final int ORDER_STARTTIME_LESS_ENDTIME = 1023;
    //当前预约起始时间已过时
    public static final int ORDER_STARTTIME_IS_OUTDATE = 1024;
    //搜素的手机号或者姓名不能为空
    public static final int SEARCH_PHONE_OR_NAME_NOT_EMPTY = 1025;
    //邮件发送失败
    public static final int MAIL_SEND_FAIL = 1026;

    static {
        VALUES.put(SUCCESS, "成功");
        VALUES.put(USER_NOT_FOUNT, "用户没找到");
        VALUES.put(USER_ALREADY_EXIST, "用户已经存在");
        VALUES.put(OPENID_NOT_EMPTY, "openid不能为空");
        VALUES.put(TOKEN_NOT_EMPTY, "token不能为空");
        VALUES.put(TOKEN_INVALID, "无效的token");
        VALUES.put(USER_ID_NOT_EMPTY, "userId不能为空");
        VALUES.put(KEY_NOT_EMPTY, "key值不能为空");
        VALUES.put(PARAMETER_NOT_EMPTY, "参数不能为空");
        VALUES.put(PARAMETER_IS_INCORRECT, "参数不正确");
        VALUES.put(PHONE_NUM_NOT_EMPTY,"手机号不能为空");
        VALUES.put(PHONE_NUM_IS_INCORRECT,"不是一个合法的手机号");
        VALUES.put(PASSWORD_IS_EMPTY,"密码不能为空");
        VALUES.put(PASSWORD_IS_INCORRECT,"密码必须由数字及字母组成且长度必须大于等于6位");
        VALUES.put(NO_USER_LOGIN,"当前无用户登录");
        VALUES.put(OLDPASSWORD_NOT_SAME_NEWPASSWORD,"旧密码不能和新密码相同");
        VALUES.put(OLDPASSWORD_IS_INCORRECT,"旧密码不正确");
        VALUES.put(PASSWORD_IS_NOT_MEET_RULE,"密码不正确");
        VALUES.put(MEETING_AREA_ORDER_NOT_FOUND,"预定会议室场地订单不存在");
        VALUES.put(MEETING_ROLE,"角色信息不存在");
        VALUES.put(MEETING_AREA_TIME_NOT_FOUND,"预定会议室场地时间不存在");
        VALUES.put(MEETING_AREA_NOT_FOUND,"预定会议室场地不存在");
        VALUES.put(ORDER_TIME_IS_CONFLICT,"会议室预约时间冲突");
        VALUES.put(ORDER_STARTTIME_LESS_ENDTIME,"预约起始时间应小于预约结束时间");
        VALUES.put(ORDER_STARTTIME_IS_OUTDATE,"当前预约起始时间已过时");
        VALUES.put(SEARCH_PHONE_OR_NAME_NOT_EMPTY,"搜素的手机号或者姓名不能为空");
        VALUES.put(MAIL_SEND_FAIL,"邮件发送失败");
    }
}
