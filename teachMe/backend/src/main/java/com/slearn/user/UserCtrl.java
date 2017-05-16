package com.slearn.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by E-M on 4/27/2017.
 */

@Controller
public class UserCtrl {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityServiceImpl securityService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginUser(@RequestBody User input) {

        //this should be login with spring auth
        //User user = userService.getUserById((long)1);

        System.out.println("usr "+input.toString());


        User user = securityService.autologin(input.getUsername(), input.getPassword());

        return user;
    }


    @ResponseBody
    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User input) {

        System.out.println("usr "+input.toString());

        //this should be login with spring auth
        User user = userService.saveUser(input);

        return user;
    }


    @ResponseBody
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable long id) {

        System.out.println("in java ctrl");
        User user = userService.getUserById(id);


        return user;
    }


}
