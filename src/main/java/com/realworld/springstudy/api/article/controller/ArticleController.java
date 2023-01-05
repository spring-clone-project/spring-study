package com.realworld.springstudy.api.article.controller;

import com.realworld.springstudy.api.article.dto.ArticleRequest;
import com.realworld.springstudy.api.article.dto.CommentRequest;
import com.realworld.springstudy.api.article.entity.Article;
import com.realworld.springstudy.api.article.entity.Comment;
import com.realworld.springstudy.api.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public void addArticles(@RequestBody ArticleRequest articleRequest){

        articleService.addArticles(articleRequest);

    }

    @GetMapping("/articles")
    public List<Article> getArticles() {

        return articleService.getArticleListAll();
    }

    @GetMapping("/articles/{slug}")
    public Article getArticleBySlug(@PathVariable String slug){

        Article articleBySlug = articleService.getArticleBySlug(slug);

        return articleBySlug;
    }

    @PostMapping("/articles/{slug}/comments")
    public void addComments(@PathVariable String slug, @RequestBody CommentRequest commentRequest) {
        articleService.addComments(slug,commentRequest);
    }

    @GetMapping("/articles/{slug}/comments")
    public Comment getCommentsBySlug(@PathVariable String slug) {

        Article articleBySlug = articleService.getArticleBySlug(slug);

        Comment commentByArticle = articleService.getCommentByArticle(articleBySlug);
        System.out.println("테스트 시작");
        System.out.println(articleBySlug.getId());
        System.out.println(commentByArticle.getId());
        return commentByArticle;

    }
}
