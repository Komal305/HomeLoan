package com.cg.homeLoan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.homeLoan.entity.HomeLoan;

@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long> {
	    List<HomeLoan> findByUsersId(Integer userId);
	
}

