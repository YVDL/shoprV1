package com.company.shopr.repositories;

import com.company.shopr.domain.Article;
import com.company.shopr.domain.Book;
import com.company.shopr.domain.Game;
import com.company.shopr.domain.Lp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Article> findAllArticles() {
        List<Article> articleList = new ArrayList<>();
        articleList.addAll(entityManager.createQuery("select g from Game g order by g.type, g.title, g.publisher, g.price", Game.class).getResultList());
        articleList.addAll(entityManager.createQuery("select lp from Lp lp order by lp.type, lp.title, lp.producer, lp.price", Lp.class).getResultList());
        articleList.addAll(entityManager.createQuery("select b from Book b order by b.type, b.title, b.Author, b.price", Book.class).getResultList());
        return articleList;
    }

    @Query(value = "SELECT * FROM book WHERE MATCH (type, title, author, description) AGAINST (?1)",
            nativeQuery = true)
    public List<Book> search(String keyword) {
        return null;
    }
}
