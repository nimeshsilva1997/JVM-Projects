package com.springboot.controller; //control class sens and reads a form view

import com.springboot.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //sets Controller to control and read the MyController class
public class MyController {

    @GetMapping("/addUser") //sets up getting the mapping to add user
    public String sendForm (User user) {
        return "addUser";
    }
    @PostMapping("/addUser") //sets up posting the mapping to show a message
    public String processForm (User user) {
        return "showMessage";
    }
}
