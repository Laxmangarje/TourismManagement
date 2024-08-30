package com.example.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tourism.entity.Admin;
@Repository
public interface adminrepository extends JpaRepository<Admin,Long> {

Admin username(String username);

}
