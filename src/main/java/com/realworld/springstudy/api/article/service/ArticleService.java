package com.realworld.springstudy.api.article.service;

import com.realworld.springstudy.api.article.dto.ArticleRequest;
import com.realworld.springstudy.api.article.dto.CommentRequest;
import com.realworld.springstudy.api.article.entity.Article;
import com.realworld.springstudy.api.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void addArticles(ArticleRequest articleRequest) {
        Article.ArticleBuilder builder = Article.builder();

        builder.description(articleRequest.getDescription());
        builder.title(articleRequest.getTitle());
        builder.body(articleRequest.getBody());

        builder.slug(this.createSlug(articleRequest.getTitle()));

        Article build = builder.build(); // use builder entity create

        articleRepository.save(build); // jpa extends auto save

    }

    private String createSlug(String title){
        return title.toLowerCase().replaceAll(" ", "-");
    }


    public List<Article> getArticleListAll() {
        return articleRepository.findAll();
    }

    public Article getArticleBySlug(String slug) {
        return articleRepository.findBySlug(slug);

    }

    public Article addComments(String slug){
        //Article.ArticleBuilder builder = Article.builder();

        return articleRepository.findBySlug(slug);

    }
}
