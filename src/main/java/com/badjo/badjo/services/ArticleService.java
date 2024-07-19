package com.badjo.badjo.services;

import java.util.List;
import java.util.Optional;

import com.badjo.badjo.domain.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badjo.badjo.domain.models.Article;
import com.badjo.badjo.domain.repository.ArticleRepository;

@Service
public class ArticleService {

    private final  ArticleRepository articleRepository;
    @Autowired
    ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }


    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }


    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
