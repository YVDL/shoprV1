package com.company.shopr.controller;

import com.company.shopr.domain.Book;
import com.company.shopr.domain.User;
import com.company.shopr.services.ArticleService;
import com.company.shopr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/showArticles")
    public String showArticlePage(Model model) {
        model.addAttribute("allArticles", articleService.findAllArticles());
        model.addAttribute("allUsers", userService.findAllUsers());
        return "showArticles";
    }

    @GetMapping("/search")
    public String search (@Param("search") String search, Model model) {

        List<Book> searchResult = articleService.search(search);

        model.addAttribute("search", search);
        model.addAttribute("pageTitle", "Search results for '" + search + "'");
        model.addAttribute("searchResult", searchResult);
        return "searchResult";
    }
}
