package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lonny on 6/7/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("title", "Sign Up");
        return "user/add";
    }
    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String add(Model model, User user, String verify){
        model.addAttribute("user",user);
        boolean passwordsMatch = true;
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            model.addAttribute("error3", "Passwords must match");
        }
        if (passwordsMatch){
            return "user/index";
        }
        return "user/add";


    }


}
