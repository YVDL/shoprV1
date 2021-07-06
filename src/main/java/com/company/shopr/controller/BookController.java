package com.company.shopr.controller;

import com.company.shopr.domain.Book;
import com.company.shopr.domain.BookFiction;
import com.company.shopr.domain.BookNonFiction;
import com.company.shopr.enums.BookGenre;
import com.company.shopr.enums.BookSubject;
import com.company.shopr.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "/showBookFiction")
    public String showBookFictionPage(Model model) {
        model.addAttribute("allBooksFiction", bookService.getBooksFiction());

        return "showBookFiction";
    }

    @GetMapping(value = "/showBookNonFiction")
    public String showBookNonFictionPage(Model model) {
        model.addAttribute("allBooksNonFiction", bookService.getBooksNonFiction());

        return "showBookNonFiction";
    }

    @GetMapping(value = "/addBookFiction")
    public String showBookFictionAddPage(Model model){
        model.addAttribute("newBookFiction", new BookFiction() {});
        model.addAttribute("bookGenre" , BookGenre.values());
        return "addBookFiction";
    }

    @PostMapping(value = "/addedBookFiction")
    public String add(@ModelAttribute BookFiction newBookFiction) {
        bookService.addBookFiction(newBookFiction);
        return "redirect:/showBookFiction";
    }

    @GetMapping(value = "/addBookNonFiction")
    public String showBookNonFictionAddPage(Model model){
        model.addAttribute("newBookNonFiction", new BookNonFiction() {});
        model.addAttribute("bookSubject" , BookSubject.values());
        return "addBookNonFiction";
    }

    @PostMapping(value = "/addedBookNonFiction")
    public String add(@ModelAttribute BookNonFiction newBookNonFiction) {
        bookService.addBookNonFiction(newBookNonFiction);
        return "redirect:showBookNonFiction";
    }
    @GetMapping(value = "/detailBook/{id}")
    public String showDetailBook(Model model, @PathVariable("id") Long id){
        model.addAttribute("detailBook",bookService.findById(id));
        return "detailBook";
    }

    @GetMapping("editBookFiction/{id}")
    public String editBookFiction(@PathVariable ("id") long id, Model model){
        model.addAttribute("editThisBookFiction", bookService.findById(id));
        return "editBookFiction";
    }

    @PostMapping(value = "/editBookFiction/{id}")
    public String editedBookFiction(@ModelAttribute BookFiction editedBookFiction) {
        bookService.editBookFictionById(editedBookFiction);
        return "redirect:/showBookFiction";
    }

    @GetMapping("editBookNonFiction/{id}")
    public String editBookNonFiction(@PathVariable ("id") long id, Model model){
        model.addAttribute("editThisBookNonFiction", bookService.findById(id));
        return "editBookNonFiction";
    }

    @PostMapping(value = "/editBookNonFiction/{id}")
    public String editedBookNonFiction(@ModelAttribute BookNonFiction editedBookNonFiction) {
        bookService.editBookNonFictionById(editedBookNonFiction);
        return "redirect:/showBookNonFiction";
    }

    @GetMapping(value = "/removeBookFiction/{id}")
    public String removeBookFiction(@PathVariable("id") long id) {
        bookService.removeBookFiction(id);
        return "redirect:/showBookFiction";
    }

    @GetMapping(value = "/removeBookNonFiction/{id}")
    public String removeBookNonFiction(@PathVariable("id") long id) {
        bookService.removeBookNonFiction(id);
        return "redirect:/showBookNonFiction";
    }
}
