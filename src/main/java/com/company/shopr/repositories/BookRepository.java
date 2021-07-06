package com.company.shopr.repositories;

import com.company.shopr.domain.Book;
import com.company.shopr.domain.BookFiction;
import com.company.shopr.domain.BookNonFiction;
import com.company.shopr.domain.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Book> getBooks() {
        List<Book> bookList = entityManager.createQuery("select b from Book b order by b.title , b.Author, b.price", Book.class).getResultList();
        return bookList;
    }

    @Transactional
    public void addBookFiction(BookFiction newBookFiction) {
        entityManager.persist(newBookFiction);
    }

    @Transactional
    public void addBookNonFiction(BookNonFiction newBookNonFiction) { entityManager.persist(newBookNonFiction); }

    @Transactional
    public Book findBookById(Long id) { return entityManager.find(Book.class, id); }

    @Transactional
    public BookFiction findBookFictionById(Long id) { return entityManager.find(BookFiction.class, id); }

    @Transactional
    public BookNonFiction findBookNonFictionById(Long id) { return entityManager.find(BookNonFiction.class, id); }

    @Transactional
    public void removeBookFiction(long id) { BookFiction bookFiction = findBookFictionById(id); entityManager.remove(bookFiction); }

    @Transactional
    public void removeBookNonFiction(long id) { BookNonFiction bookNonFiction = findBookNonFictionById(id); entityManager.remove(bookNonFiction); }

    @Transactional
    public void editBookFictionById(BookFiction newBookFiction) { entityManager.merge(newBookFiction); }

    @Transactional
    public void editBookNonFictionById(BookNonFiction newBookNonFiction) { entityManager.merge(newBookNonFiction); }

    @Transactional
    public List<BookFiction> getBooksFiction() { return entityManager.createQuery("select b from BookFiction b", BookFiction.class).getResultList(); }

    @Transactional
    public List<BookNonFiction> getBooksNonFiction() { return entityManager.createQuery("select b from BookNonFiction b", BookNonFiction.class).getResultList(); }

    }

