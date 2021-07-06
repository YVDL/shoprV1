package com.company.shopr.services;

import com.company.shopr.domain.Article;
import com.company.shopr.domain.Book;
import com.company.shopr.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> findAllArticles() {
        return articleRepository.findAllArticles();
    }

    public List<Book> search(String keyword) {
        return articleRepository.search(keyword);
    }
}
