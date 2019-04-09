
package com.lucien.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "lucien");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "man");
        return "switch";
    }

    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("userName", "lucien");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request) {
        request.setAttribute("request", "I am request");
        request.getSession().setAttribute("session", "I am session");
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute("userName", "lucien");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 4);
        map.addAttribute("date", new Date());
        return "utility";
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
