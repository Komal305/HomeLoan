package com.cg.homeLoan.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.homeLoan.entity.LoanOffer;

@Repository
public interface LoanRepository extends JpaRepository<LoanOffer, Long> {
    Optional<LoanOffer> findById(Long userId);
}
