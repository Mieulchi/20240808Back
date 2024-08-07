package com.example.project0807.repository;

import com.example.project0807.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user where name = :name", nativeQuery = true)
    List<User> findByName(String name);
}
