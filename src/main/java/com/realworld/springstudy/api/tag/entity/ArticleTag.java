package com.realworld.springstudy.api.tag.entity;

import com.realworld.springstudy.api.article.entity.Article;
import com.realworld.springstudy.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SequenceGenerator(
        name = "articleTag_seq_gen",
        sequenceName = "articleTag_seq"
)
@Entity
public class ArticleTag extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "articleTag_seq_gen")
    private Long id;
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
}
