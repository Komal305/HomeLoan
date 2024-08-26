package com.cg.homeLoan.services;

import java.util.List;

import com.cg.homeLoan.Dto.LoanDTO;
import com.cg.homeLoan.Exception.ResourceNotFoundException;
import com.cg.homeLoan.entity.Loan;

public interface LoanService {
	Loan applyForLoan(LoanDTO loanDTO)throws ResourceNotFoundException;

    Loan getLoanById(Long loanId)throws ResourceNotFoundException;

    List<Loan> getLoansByUserId(Long userId)throws ResourceNotFoundException;

    void updateLoan(LoanDTO loanDTO)throws ResourceNotFoundException;

    void deleteLoan(Long loanId) throws ResourceNotFoundException;
}
