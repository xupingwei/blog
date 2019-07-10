package link.liwei.app.blog.admin.controller;

import link.liwei.app.blog.basic.entity.ResultBean;
import link.liwei.app.blog.basic.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ManagerController {

    @PostMapping("/create")
    public ResultBean create() {
        return ResultUtils.success();
    }
}
