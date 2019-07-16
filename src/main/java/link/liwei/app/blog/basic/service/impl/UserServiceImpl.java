package link.liwei.app.blog.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import link.liwei.app.blog.basic.Constants;
import link.liwei.app.blog.basic.dao.UserDao;
import link.liwei.app.blog.basic.entity.po.User;
import link.liwei.app.blog.basic.exce.BusinessException;
import link.liwei.app.blog.basic.service.UserService;
import link.liwei.app.blog.basic.utils.JwtUtil;
import link.liwei.app.blog.basic.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User register(User user) {
        if (StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.getUserName())) {
            throw new BusinessException("用户名或手机号不能为空");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            throw new BusinessException("密码不能为空");
        }
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("phone", user.getPhone());
        User u = userDao.selectOne(userWrapper);
        if (null != u) {
            return u;
        }
//        String token = JwtUtil.sign(user.getPhone(), user.getPassword());
//        user.setToken(token);
        //密码MD5
        user.setPassword(MD5Util.string2MD5(user.getPassword()));
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        int i = userDao.insert(user);
        if (i == 0) {
            throw new BusinessException(Constants.VALUES.get(Constants.REGISTER_FAILED));
        }
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.eq("token", token);
        return userDao.selectOne(userWrapper);
    }

    @Override
    public User login(String phone, String password) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            throw new BusinessException("账号或密码不能为空");
        }
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper
                .eq("phone", phone)
                .eq("password", MD5Util.string2MD5(password));
        User user = userDao.selectOne(userWrapper);
        if (null == user) {
            throw new BusinessException("账号或密码错误");
        }
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setToken(JwtUtil.sign(user.getPhone(), user.getPassword()));
        userDao.updateById(user);
        return userDao.selectById(user.getUserId());
    }
}
