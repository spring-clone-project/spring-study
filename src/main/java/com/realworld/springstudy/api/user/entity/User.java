package com.realworld.springstudy.api.user.entity;

import com.realworld.springstudy.global.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@SequenceGenerator(
        name = "user_seq_gen",
        sequenceName = "user_seq"
)
@Table(name = "test_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    Long id;
    private String name;
    private String email;
    private String password;
    private String bio;
    private String image;

}