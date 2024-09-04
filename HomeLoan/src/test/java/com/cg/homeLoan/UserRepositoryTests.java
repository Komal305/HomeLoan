package com.cg.homeLoan;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.cg.homeLoan.entity.Role;
import com.cg.homeLoan.entity.RoleType;
import com.cg.homeLoan.entity.User;
import com.cg.homeLoan.repo.RoleRepository;
import com.cg.homeLoan.repo.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(true) // Set to true to roll back changes after the test
public class UserRepositoryTests {

    @Autowired
    private UserRepo repo;
    
    @Autowired
    RoleRepository roleRepository;
    
    
    @Test
    public void testCreateUser() {
    	Role role = new Role(1L,  RoleType.USER);
        roleRepository.save(role);
    	//(Long id, String email, String name, String password, String city, Role role)
        User user = new User(1l,"komal@example.com", "komal", "komal", "bhagalpur", role); // Update this if your User constructor differs

        User savedUser = repo.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    
    @Test
  public void testListAllUsers() {
  	Iterable<User> listUser=repo.findAll();
  	listUser.forEach(user -> System.out.println(user));
  }
    
    @Test
  public void testDeleteUser() {
  	Long userId=1l;
  	repo.deleteById(userId);
  }
}