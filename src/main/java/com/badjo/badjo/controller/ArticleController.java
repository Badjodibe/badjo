package com.badjo.badjo.controller;

import java.util.List;
import java.util.Optional;

import com.badjo.badjo.services.ConferenceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badjo.badjo.domain.models.Article;
import com.badjo.badjo.services.ArticleService;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;
    @Autowired
    ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Optional<Article> article = articleService.getArticleById(id);
        return article.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
