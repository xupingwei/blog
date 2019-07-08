package link.liwei.app.blog.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import link.liwei.app.blog.basic.Constants;
import link.liwei.app.blog.basic.dao.UserDao;
import link.liwei.app.blog.basic.entity.po.User;
import link.liwei.app.blog.basic.exce.BusinessException;
import link.liwei.app.blog.basic.service.UserService;
import link.liwei.app.blog.basic.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User insert(User user) {
        String token = JwtUtil.sign(user.getPhone(), user.getPassword());
        user.setToken(token);
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        int i = userDao.insert(user);
        if (i == 0) {
            throw new BusinessException(Constants.VALUES.get(Constants.REGISTER_FAILED));
        }
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("token", token);
        return userDao.selectOne(userQueryWrapper);

    }
}
