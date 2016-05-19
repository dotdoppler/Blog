package mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import  static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by doppler on 2016/5/19.
 */
@Controller
public class TestController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserRepository userRepository;
    @RequestMapping("")
    public String testSave(){
        return "test/insert";
    }
    @RequestMapping(value = "insert",method = POST)
    public @ResponseBody String testInsert(@RequestParam("email") String email,
    @RequestParam("pwd") String pwd){
        User user = new User();
        user.setEmail(email);
        user.setPwd(pwd);
        userRepository.save(user);
        return "hhh";
    }

}
