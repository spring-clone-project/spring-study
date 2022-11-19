package com.realworld.springstudy.api.user.repository;

import com.realworld.springstudy.api.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> // <entity클래스, entity ID타입>
{

}
