package mongo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by doppler on 2016/5/26.
 */
@Controller
@RequestMapping("test")
public class TestCappedCollection {
    @Resource
    PersonRepository personRepository;
    @RequestMapping("")
    public @ResponseBody String test(){
        Person person = new Person("jack",11);
        person.setCreatedAt(DateFomater.format(new Date()));
        personRepository.insert(person);
        return "ok";
    }
}
