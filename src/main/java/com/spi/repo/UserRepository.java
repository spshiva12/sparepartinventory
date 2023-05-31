package com.spi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUsername(String username);

}
