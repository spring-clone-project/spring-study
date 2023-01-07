package com.realworld.springstudy.api.article.repository;

import com.realworld.springstudy.api.article.entity.Comment;
import com.realworld.springstudy.api.article.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long>  {

    @Query("select f from Favorite f join Article a on f.article.id = a.id where a.slug = :slug")
    Favorite findBySlug(@Param(value = "slug") String slug);

}
