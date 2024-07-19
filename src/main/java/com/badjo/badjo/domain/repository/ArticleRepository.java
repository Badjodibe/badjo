package com.badjo.badjo.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.badjo.badjo.domain.models.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
