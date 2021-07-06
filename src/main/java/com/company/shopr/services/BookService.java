package com.company.shopr.services;

import com.company.shopr.domain.Book;
import com.company.shopr.domain.BookFiction;
import com.company.shopr.domain.BookNonFiction;
import com.company.shopr.domain.Game;
import com.company.shopr.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public void addBookFiction(BookFiction newBookFiction) {
        bookRepository.addBookFiction(newBookFiction);
    }

    public void addBookNonFiction(BookNonFiction newBookNonFiction) { bookRepository.addBookNonFiction(newBookNonFiction); }

    public Book findById(Long id) { return bookRepository.findBookById(id); }

    public void removeBookFiction(long id) { bookRepository.removeBookFiction(id); }

    public void removeBookNonFiction(long id) { bookRepository.removeBookNonFiction(id); }

    public void editBookFictionById(BookFiction newBookFiction) { bookRepository.editBookFictionById(newBookFiction); }

    public void editBookNonFictionById(BookNonFiction newBookNonFiction) { bookRepository.editBookNonFictionById(newBookNonFiction); }

    public List getBooksFiction() { return bookRepository.getBooksFiction(); }

    public List getBooksNonFiction() { return bookRepository.getBooksNonFiction(); }
}

