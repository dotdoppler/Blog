package mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by doppler on 2016/5/19.
 */
@Controller
public class TestController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CCRepository ccRepository;
    @RequestMapping("")
    public String testSave(){

        return "test/insert";
    }
    @RequestMapping("cc")
    public @ResponseBody String cc(){
        CC capped = new CC();
        capped.setName(88);
        ccRepository.insert(capped);
        return "ok";
    }
    @RequestMapping(value = "insert",method = POST)
    public @ResponseBody User testInsert(@RequestParam("email") String email, @RequestParam("pwd") String pwd){
        User user = new User();
        user.setEmail(email);
        user.setPwd(pwd);
        return userRepository.save(user);
    }

}
