package link.liwei.app.blog.custom;

import link.liwei.app.blog.basic.entity.ResultBean;
import link.liwei.app.blog.basic.entity.po.User;
import link.liwei.app.blog.basic.service.UserService;
import link.liwei.app.blog.basic.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultBean register(User user) {
        return ResultUtils.success(userService.insert(user));
    }
}
