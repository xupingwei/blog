package link.liwei.app.blog.admin;

import link.liwei.app.blog.basic.entity.ResultBean;
import link.liwei.app.blog.basic.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ManagerController {

    @PostMapping("/home")
    public ResultBean home() {
        return ResultUtils.success();
    }
}
