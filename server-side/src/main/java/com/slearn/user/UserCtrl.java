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

    @ResponseBody
    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public User loginUser(@RequestBody User input) {

        //this should be login with spring auth
        User user = userService.getUserById((long)1);

        return user;
    }


}
