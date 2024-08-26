package com.cg.homeLoan.services;

import com.cg.homeLoan.Dto.EmiCalculatorDTO;
import com.cg.homeLoan.Exception.CalculatorException;


public interface EmiCalculatorService {
	public Double CalculateEMI(EmiCalculatorDTO emicalculator) throws CalculatorException;
}
