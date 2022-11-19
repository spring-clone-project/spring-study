package com.realworld.springstudy.api.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest {
    private String email;
    private String bio;
    private String image;

}
