package com.cg.homeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeLoan.entity.Users;

import java.util.Optional;



public interface UserRepo extends JpaRepository<Users, Integer> {
Optional<Users> findByEmail(String email);
Optional<Users> findById(long id);
void deleteById(Long userId);
Optional<Users> findByName(String name);

}
