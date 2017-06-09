package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by lonny on 6/7/2017.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model){
        model.addAttribute((new User()));

        return "user/add";
    }
    @RequestMapping( value ="add", method = RequestMethod.POST)
    public String add(@ModelAttribute @Valid User user,Errors errors, Model model, String verify){
        model.addAttribute("user",user);
        String error3="Your passwords do not match.";
        boolean passwordsMatch = true;
        if (errors.hasErrors()){
            model.addAttribute("user", user);
            model.addAttribute("errors",errors);

        }
        if (user.getPassword() == null || verify == null
                || !user.getPassword().equals(verify)) {
            passwordsMatch = false;
            model.addAttribute("error3", error3);
        }
        if (passwordsMatch){
            return "user/index";
        }
        return "user/add";


    }


}
