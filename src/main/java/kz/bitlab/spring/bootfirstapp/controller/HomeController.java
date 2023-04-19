package kz.bitlab.spring.bootfirstapp.controller;

import kz.bitlab.spring.bootfirstapp.DBManager.DBManager;
import kz.bitlab.spring.bootfirstapp.model.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String homePage(Model model){
        ArrayList<Items> items = DBManager.getAllItems();
        model.addAttribute("items",items);
        return "home";
    }

    @GetMapping(value = "/additem")
    public String addItem(){
        return "additem";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "name") String name,
                          @RequestParam(name = "description") String description,
                          @RequestParam(name = "price") double price){

        Items item = new Items();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);

        DBManager.addItem(item);
        return "redirect:/";
    }

    @GetMapping(value = "/details/{itemId}")
    public String detailsPage(@PathVariable(name = "itemId") Long id,
                              Model model){
        Items item = DBManager.getItem(id);
        model.addAttribute("item",item);
        return "details";
    }
}
