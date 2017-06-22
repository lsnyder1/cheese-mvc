package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseType;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * Created by lonny on 5/24/2017.
 */
@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;


    @RequestMapping(value="")

    public String index(Model model) {

        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";

    }
    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors,
                                       Model model) {

        if(errors.hasErrors()){
            model.addAttribute("title","Add Cheese");
            return "cheese/add";
        }
        cheeseDao.save(newCheese);
        return "redirect:";


    }
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            cheeseDao.delete(cheeseId);
        }

        return "redirect:";
    }
    @RequestMapping(value ="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId){
        Cheese cheese = cheeseDao.findOne(cheeseId);
        model.addAttribute("cheeseTypes", CheeseType.values());
        model.addAttribute("cheese",cheese);
        model.addAttribute("title","Edit cheese "+cheese.getName());
        return"cheese/edit";


    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese newCheese,Errors errors,Model model){
        if (errors.hasErrors()){
            model.addAttribute("title", "Edit Cheese " + newCheese.getName());
            //Cheese cheese = CheeseData.getById(cheeseId);
            model.addAttribute("cheese",newCheese);
            model.addAttribute("cheeseTypes", CheeseType.values());

            return "cheese/edit";
        }
        Cheese cheese= cheeseDao.findOne(newCheese.getId());
        model.addAttribute("cheeseTypes", CheeseType.values());
        cheese.setName(newCheese.getName());
        cheese.setDescription(newCheese.getDescription());
        cheese.setType(newCheese.getType());

        return "redirect:";


    }
}
