package com.realworld.springstudy.api.article.controller;

import com.realworld.springstudy.api.article.dto.ArticleRequest;
import com.realworld.springstudy.api.article.dto.ArticleUpdateRequest;
import com.realworld.springstudy.api.article.entity.Article;
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

        System.out.println(articleBySlug);
        return articleBySlug;
    }

    @PutMapping("/articles/{slug}")
    public void updateArticleBySlug(@PathVariable String slug, @RequestBody ArticleUpdateRequest body) {
        articleService.updateArticleBySlug(slug, body);
    }

    @DeleteMapping("/articles/{slug}")
    public void deleteArticlesBySlug(@PathVariable String slug){
        articleService.deleteArticlesBySlug(slug);
    }
}
