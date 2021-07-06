package com.company.shopr.controller;

import com.company.shopr.domain.Game;
import com.company.shopr.domain.Lp;
import com.company.shopr.enums.LpGenre;
import com.company.shopr.services.LpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LpController {

    @Autowired
    LpService lpService;


    @GetMapping(value = "/showLp")
    public String showLpPage(Model model) {
        model.addAttribute("allLps", lpService.getLps());

        return "showLp";
    }

    @GetMapping(value = "/addLp")
    public String showLpAddPage(Model model){
        model.addAttribute("newLp" , new Lp());
        model.addAttribute("lpGenre" , LpGenre.values());
        return "addLp";
    }

    @PostMapping(value = "/addLp")
    public String add(@ModelAttribute Lp newLp) {
        lpService.addLp(newLp);
        return "redirect:/showLp";
    }

    @GetMapping(value = "/detailLp/{lpId}")
    public String showDetailLp(Model model, @PathVariable("lpId") Long lpId){
        model.addAttribute("detailLp",lpService.findLpById(lpId));
        return "detailLp";
    }
    @GetMapping(value = "/editLp/{id}")
    public String showEditPage(@PathVariable("id") long id, Model model){
        model.addAttribute("editAnLp", lpService.findLpById(id));
        return "editLp";
    }

    @PostMapping(value = "/editLp/{id}")
    public String editLp(@ModelAttribute Lp editedLp) {
        lpService.editLpById(editedLp);
        return "redirect:/showLp";
    }

    @GetMapping(value = "/removeLp/{id}")
    public String removeLp(@PathVariable("id") long id) {
        lpService.removeLp(id);
        return "redirect:/showLp";
    }
}

