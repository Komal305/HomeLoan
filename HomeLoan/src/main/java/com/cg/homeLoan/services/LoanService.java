package com.cg.homeLoan.services;

import java.util.Optional;

import com.cg.homeLoan.Dto.LoanDTO;
import com.cg.homeLoan.Exception.ResourceNotFoundException;
import com.cg.homeLoan.entity.LoanOffer;

public interface LoanService {
	LoanOffer applyForLoan(LoanDTO loanDTO)throws ResourceNotFoundException;

    LoanOffer getLoanById(Long loanId)throws ResourceNotFoundException;

    Optional<LoanOffer> getLoanByUserId(Long userId)throws ResourceNotFoundException;

    void updateLoan(LoanDTO loanDTO)throws ResourceNotFoundException;

    void deleteLoan(Long loanId) throws ResourceNotFoundException;
}
