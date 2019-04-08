
package com.lucien.controller;

import java.util.ArrayList;
import java.util.List;

import com.lucien.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "ityouknow");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    private List<User> getUserList() {
        List<User> list = new ArrayList<>();
        User user1 = new User("Tom", 18, "123");
        User user2 = new User("Tony", 17, "234");
        User user3 = new User("Kare", 16, "345");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
}
