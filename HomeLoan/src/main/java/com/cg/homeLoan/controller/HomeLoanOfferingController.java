package com.cg.homeLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.homeLoan.Dto.HomeLoanOfferingDTO;
import com.cg.homeLoan.services.HomeLoanOfferingService;


@Controller
public class HomeLoanOfferingController {
	
	 @Autowired
	    private HomeLoanOfferingService homeLoanOfferingService;
	 
	

	    
	    @GetMapping("/public/offering")//checked
	    public ResponseEntity<List<HomeLoanOfferingDTO>> getAllOfferings() {
	        List<HomeLoanOfferingDTO> offerings = homeLoanOfferingService.getAllOfferings();
	        return ResponseEntity.ok(offerings);
	    }
	    
	    @GetMapping("/public/offering/{id}")//checked
	    public ResponseEntity<HomeLoanOfferingDTO> getOfferingById(@PathVariable("id") Long id) {
	    	HomeLoanOfferingDTO offering = homeLoanOfferingService.getOfferingById(id);
	        return ResponseEntity.ok(offering); 
	    }
	    
}
