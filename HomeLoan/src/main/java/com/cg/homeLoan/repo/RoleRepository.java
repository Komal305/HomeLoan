package com.cg.homeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.homeLoan.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
Role findByRole(String roleName);
}
