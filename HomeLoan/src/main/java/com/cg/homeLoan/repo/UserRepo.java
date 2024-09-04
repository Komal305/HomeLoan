package com.cg.homeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeLoan.entity.User;

import java.util.Optional;



public interface UserRepo extends JpaRepository<User, Long> {
Optional<User> findByEmail(String email);
Optional<User> findById(long id);
void deleteById(Long userId);
Optional<User> findByName(String name);

}
