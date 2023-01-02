package com.realworld.springstudy.api.article.service;

import com.realworld.springstudy.api.article.dto.ArticleRequest;

import com.realworld.springstudy.api.article.dto.ArticleUpdateRequest;
import com.realworld.springstudy.api.article.entity.Article;
import com.realworld.springstudy.api.article.entity.Article.ArticleBuilder;
import com.realworld.springstudy.api.article.entity.Comment;
import com.realworld.springstudy.api.article.repository.ArticleRepository;
import com.realworld.springstudy.api.article.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public void addArticles(ArticleRequest articleRequest) {
        ArticleBuilder builder = Article.builder();

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

    @Transactional // 트랜잭션을 하겠다고 명시하는 어노테이션 (begin과 commit 처리를 하겠다는것)
    public void updateArticleBySlug(String slug, ArticleUpdateRequest body) {
        //jpa update
        //1. dirty check
        Article entity = articleRepository.findBySlug(slug);
        ArticleBuilder builder = Article.builder();

        builder.id(entity.getId());
        builder.slug(entity.getSlug());
        builder.description(entity.getDescription());

        builder.title(body.getTitle());

        articleRepository.save(builder.build());


        //2. 강제 update
    }

    @Transactional
    public void deleteArticlesBySlug(String slug) {

        Article entity = articleRepository.findBySlug(slug);

        articleRepository.deleteById(entity.getId());
    }

    public void addComments(String slug){

        System.out.println("슬러그 : " + slug);
        System.out.println("들어옴2");
        Comment.CommentBuilder builder = Comment.builder();
        builder.body(slug);

        Comment build = builder.build();
        System.out.println("들어옴3");
        commentRepository.save(build);

    }
}
