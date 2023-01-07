package com.realworld.springstudy.api.article.entity;

import com.realworld.springstudy.api.user.entity.User;
import com.realworld.springstudy.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@SequenceGenerator(
        name = "comment_seq_gen",
        sequenceName = "comment_seq"
)
@EqualsAndHashCode
@Entity
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq_gen")
    private Long id;

    private String body;

    @ManyToOne(fetch = FetchType.EAGER) // 컨트롤러에서 엔티티 조회시 객체 정보를 한번에 가져올때는 EAGER 사용해야한다. LAZY는 객체를 타고타고 정보를 가져올순있지만 객체의 모든정보를 한번에 가져오긴어렵다.
    @JoinColumn(name = "author_id", nullable = false) // author_id fk컬럼을 만들겠다는것
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
}
