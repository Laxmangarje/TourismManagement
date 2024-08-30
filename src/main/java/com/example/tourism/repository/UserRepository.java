package com.example.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tourism.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	 User username(String username);

}
