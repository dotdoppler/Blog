package doppler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by doppler on 2016/5/10.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "", method = GET)
    public String index(){
        return "home/index";
    }
}
