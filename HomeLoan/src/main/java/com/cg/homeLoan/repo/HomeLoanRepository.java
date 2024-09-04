package com.cg.homeLoan.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.homeLoan.entity.HomeLoan;

@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long> {
	    Optional<HomeLoan> findById(Long id);
	
}

