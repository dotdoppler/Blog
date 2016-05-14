package doppler.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by doppler on 2016/5/12.
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @RequestMapping("")
    public String index(){
        return "admin/home/index";
    }
}
