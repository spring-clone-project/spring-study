package com.realworld.springstudy.api.article.entity;

import com.realworld.springstudy.api.tag.entity.ArticleTag;
import com.realworld.springstudy.api.user.entity.User;
import com.realworld.springstudy.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@SequenceGenerator(
        name = "article_seq_gen",
        sequenceName = "article_seq"
)
@EqualsAndHashCode
@Builder
public class Article extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq_gen")
    private Long id;
    private String slug;
    private String title;
    private String description;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User author;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ArticleTag> tagList;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Favorite> favoriteList;
}
