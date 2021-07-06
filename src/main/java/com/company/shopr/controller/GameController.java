package com.company.shopr.controller;

import com.company.shopr.domain.Game;
import com.company.shopr.enums.GameGenre;
import com.company.shopr.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

    @Autowired
    GameService gameService;


    @GetMapping(value = "/showGame")
    public String showGamePage(Model model) {
        model.addAttribute("allGames", gameService.getGames());
        return "showGame";
    }

    @GetMapping(value = "/addGame")
    public String showGameAddPage(Model model){
        model.addAttribute("newGame" , new Game());
        model.addAttribute("gameGenre" , GameGenre.values());
        return "addGame";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute Game newGame) {
        gameService.addGame(newGame);
        return "redirect:/showGame";
    }

    @GetMapping(value = "/detailGame/{gameId}")
    public String showDetailGame(Model model, @PathVariable("gameId") Long gameId){
        model.addAttribute("detailGame",gameService.findGameById(gameId));
        return "detailGame";
    }

    @GetMapping(value = "/editGame/{id}")
    public String showEditPage(@PathVariable("id") long id, Model model){
        model.addAttribute("editAGame", gameService.findGameById(id));
        return "editGame";
    }

    @PostMapping(value = "/editGame/{id}")
    public String editGame(@ModelAttribute Game editedGame) {
        gameService.editGameById(editedGame);
        return "redirect:/showGame";
    }
    @GetMapping(value = "/removeGame/{id}")
    public String removeGame(@PathVariable("id") long id) {
        gameService.removeGame(id);
        return "redirect:/showGame";
    }
}
