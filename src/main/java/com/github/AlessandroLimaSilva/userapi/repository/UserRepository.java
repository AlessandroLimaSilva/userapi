package com.github.AlessandroLimaSilva.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.AlessandroLimaSilva.userapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
