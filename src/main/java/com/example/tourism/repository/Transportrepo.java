package com.example.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tourism.entity.Transport;

@Repository
public interface Transportrepo extends JpaRepository<Transport,Long> {

}
