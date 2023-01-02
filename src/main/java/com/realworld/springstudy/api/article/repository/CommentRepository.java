package com.realworld.springstudy.api.article.repository;

import com.realworld.springstudy.api.article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
