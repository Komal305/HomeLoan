package com.cg.homeLoan.services;

import java.util.List;

import com.cg.homeLoan.Dto.HomeLoanDto;

public interface HomeLoanTrackerService {
 
	//List<HomeLoanDto> getLoansByLoanId(Integer loanId);
	
	
	    List<HomeLoanDto> getLoanByUserId(Long userId);
	    HomeLoanDto getLoanDetails(Long loanId);
	

}

