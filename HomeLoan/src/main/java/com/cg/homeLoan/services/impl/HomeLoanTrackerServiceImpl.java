package com.cg.homeLoan.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.homeLoan.Dto.HomeLoanDto;
import com.cg.homeLoan.entity.HomeLoan;
import com.cg.homeLoan.repo.HomeLoanRepository;
import com.cg.homeLoan.services.HomeLoanTrackerService;

@Service
public class HomeLoanTrackerServiceImpl implements HomeLoanTrackerService {

    @Autowired
    private HomeLoanRepository homeLoanRepository;

    @Override
    public List<HomeLoanDto> getLoanByUserId(Long userId) {
        Optional<HomeLoan> loans = homeLoanRepository.findById(userId);
        return loans.stream().map(loan -> {
            HomeLoanDto dto = new HomeLoanDto();
            dto.setLoanId(loan.getId());
            dto.setLoanAccountNumber(loan.getLoanAccountNumber());
            dto.setLoanAmount(loan.getLoanAmount());
            dto.setLoanCreationDate(loan.getLoanCreationDate());

            // Check if the loan is newly created
            if (loan.getLoanCreationDate().isAfter(LocalDate.now().minusWeeks(2))) {
                dto.setMessage("Home loan creation will be completed after required approvals.");
            } else {
                dto.setMessage("Loan approved.");
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public HomeLoanDto getLoanDetails(Long loanId) {
        HomeLoan loan = homeLoanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        HomeLoanDto dto = new HomeLoanDto();
        dto.setLoanId(loan.getId());
        dto.setLoanAccountNumber(loan.getLoanAccountNumber());
        dto.setLoanAmount(loan.getLoanAmount());
        dto.setLoanCreationDate(loan.getLoanCreationDate());

        return dto;
    }






}

