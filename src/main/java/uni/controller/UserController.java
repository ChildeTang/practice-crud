package uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uni.model.User;
import uni.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Candy on 2018/6/6
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(String name, Integer age, String email) {
        if (null == name) return "error";
        User user = new User(null, name, age, email);
        userService.saveUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String editUser(Integer id, String name, Integer age, String email) {
        if (null == id) return "error";
        if (null == name) return "error";
        User user = new User(id, name, age, email);
        userService.updateUser(user);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "success";
    }


}
