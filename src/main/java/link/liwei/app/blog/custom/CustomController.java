package link.liwei.app.blog.custom;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class CustomController {


    @GetMapping("/home")
    public String home() {

        return "User Home";
    }
}
