package link.liwei.app.blog.basic.service.impl;

import link.liwei.app.blog.basic.dao.UserDao;
import link.liwei.app.blog.basic.entity.po.User;
import link.liwei.app.blog.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insert(User user) {
        return userDao.insert(user);

    }
}
