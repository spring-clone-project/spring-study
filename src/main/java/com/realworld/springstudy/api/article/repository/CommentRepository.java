package com.realworld.springstudy.api.article.repository;

import com.realworld.springstudy.api.article.entity.Article;
import com.realworld.springstudy.api.article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c join Article a on c.article.id = a.id where a.slug = :slug")
    List<Comment> findBySlug(@Param(value = "slug") String slug);

    Comment findByArticleAndId(Article article, Long id);
}
