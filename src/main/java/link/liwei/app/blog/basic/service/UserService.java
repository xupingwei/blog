package link.liwei.app.blog.basic.service;

import link.liwei.app.blog.basic.entity.po.User;

public interface UserService {

    User register(User user);

    User login(String phone, String password);
}
