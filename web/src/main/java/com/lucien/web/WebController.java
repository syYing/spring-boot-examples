
package com.lucien.web;

import java.util.List;
import java.util.ArrayList;

import com.lucien.model.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping(name = "/getUser", method = RequestMethod.POST)
    public User getUser() {
        User user = new User();
        user.setName("lucien");
        user.setAge(23);
        user.setPass("123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("neo"); 
        user1.setAge(30); 
        user1.setPass("neo123"); 
        users.add(user1); 
        User user2=new User(); 
        user2.setName("lucien"); 
        user2.setAge(12); 
        user2.setPass("123456"); 
        users.add(user2);

        return users;
    }

    @RequestMapping(value = "get/{name}", method = RequestMethod.GET)
    public String get(@PathVariable String name) {
        return name;
    }
}
