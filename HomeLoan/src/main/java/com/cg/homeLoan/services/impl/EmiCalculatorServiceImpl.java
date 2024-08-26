package com.cg.homeLoan.services.impl;



import org.springframework.stereotype.Service;

import com.cg.homeLoan.Dto.EmiCalculatorDTO;
import com.cg.homeLoan.Exception.CalculatorException;
import com.cg.homeLoan.services.EmiCalculatorService;


@Service
public class EmiCalculatorServiceImpl implements EmiCalculatorService{


	@Override
	public Double CalculateEMI(EmiCalculatorDTO emicalculator) throws CalculatorException {
		Double loanAmount = emicalculator.getLoanAmount();
		Integer tenure = emicalculator.getLoanTenure();
		Double rate = emicalculator.getRateOfInterest();
		
		Double monthlyRate = rate/12/100;
		Double emi =loanAmount*monthlyRate*(Math.pow(1+monthlyRate,tenure))/Math.pow(1+monthlyRate,tenure-1);
	return emi;
	}
	

}
