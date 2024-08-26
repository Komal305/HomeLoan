package com.cg.homeLoan;

import static org.assertj.core.api.Assertions.assertThat;

import javax.management.relation.Role;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;

import com.cg.homeLoan.entity.Users;
import com.cg.homeLoan.repo.UserRepo;
import com.cg.homeLoan.repo.UserRepo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true) // Set to true to roll back changes after the test
public class UserRepositoryTests {

    @Autowired
    private UserRepo repo;
    
    
//    @Test
//    public void testCreateUser() {
//        Users user = new Users("komal@example.com", "komal"); // Update this if your User constructor differs
//
//        Users savedUser = repo.save(user);
//        assertThat(savedUser).isNotNull();
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
    
    @Test
  public void testListAllUsers() {
  	Iterable<Users> listUser=repo.findAll();
  	listUser.forEach(user -> System.out.println(user));
  }
    
    @Test
  public void testDeleteUser() {
  	Long userId=1l;
  	repo.deleteById(userId);
  }
}
