package com.cg.homeLoan.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.homeLoan.Dto.HomeLoanOfferingDTO;
import com.cg.homeLoan.services.HomeLoanOfferingService;


@Service
public class HomeLoanOfferingServiceImpl implements HomeLoanOfferingService {


   
    
    private static final List<HomeLoanOfferingDTO> predefinedOfferings = List.of(
    		new HomeLoanOfferingDTO(1L, "Home Loan", "Basic Home Loan", 5000000.0, 20, 7.5, 0.0, 0),
    	    new HomeLoanOfferingDTO(2L, "Home Loan", "Luxury Home Loan", 10000000.0, 30, 8.2, 0.0, 0),
    	    new HomeLoanOfferingDTO(3L, "Home Loan", "Commercial Property Loan", 15000000.0, 25, 6.8, 0.0, 0),
    	    new HomeLoanOfferingDTO(4L, "Home Loan", "Land Purchase Loan", 3000000.0, 15, 6.5, 0.0, 0),
    	    new HomeLoanOfferingDTO(5L, "Home Loan", "Home Renovation Loan", 2000000.0, 10, 7.0, 0.0, 0),
    	    new HomeLoanOfferingDTO(6L, "Home Loan", "Home Extension Loan", 3500000.0, 12, 6.9, 0.0, 0),
    	    new HomeLoanOfferingDTO(7L, "Home Loan", "NRI Home Loan", 12000000.0, 25, 8.0, 0.0, 0),
    	    new HomeLoanOfferingDTO(8L, "Home Loan", "Affordable Housing Loan", 2500000.0, 20, 6.2, 0.0, 0),
    	    new HomeLoanOfferingDTO(9L, "Home Loan", "Top-Up Loan", 4000000.0, 15, 7.4, 0.0, 0),
    	    new HomeLoanOfferingDTO(10L, "Home Loan", "Bridge Loan", 4500000.0, 5, 9.0, 0.0, 0),
    	    new HomeLoanOfferingDTO(11L, "Home Loan", "Green Home Loan", 8000000.0, 25, 7.1, 0.0, 0),
    	    new HomeLoanOfferingDTO(12L, "Home Loan", "Home Equity Loan", 6000000.0, 18, 7.8, 0.0, 0),
    	    new HomeLoanOfferingDTO(13L, "Home Loan", "Smart Home Loan", 7000000.0, 20, 7.0, 0.0, 0),
    	    new HomeLoanOfferingDTO(14L, "Home Loan", "Self-Employed Home Loan", 10000000.0, 30, 8.5, 0.0, 0),
    	    new HomeLoanOfferingDTO(15L, "Home Loan", "Joint Home Loan", 9000000.0, 25, 7.9, 0.0, 0)
    	);

	@Override
	public List<HomeLoanOfferingDTO> getAllOfferings() {
				return predefinedOfferings;		
	}
	
	
	  @Override
	    public HomeLoanOfferingDTO getOfferingById(Long offeringId) {
	        return predefinedOfferings.stream()
	                .filter(offering -> offering.getLoanId().equals(offeringId))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Loan not found with id: " + offeringId));
	    }
	 
   

}
