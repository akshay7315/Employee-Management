package com.main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.User_1;

@Repository
public interface Userrepo extends JpaRepository<User_1, String> {

	public Optional<User_1> findByUsername(String username);
}
