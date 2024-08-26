package com.cg.homeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.homeLoan.Dto.EmiCalculatorDTO;
import com.cg.homeLoan.Exception.CalculatorException;
import com.cg.homeLoan.services.EmiCalculatorService;

@Controller
public class EmiCalculatorController {

	@Autowired
	private EmiCalculatorService emiCalculatorService;


	@PostMapping("/public/calculateEmi") // checked http://localhost:8081/public/calculateEmi
	public ResponseEntity<Double> calculateEmi(@RequestBody EmiCalculatorDTO emiCalculatorDTO) {
		try {
			Double emi = emiCalculatorService.CalculateEMI(emiCalculatorDTO);
			return ResponseEntity.ok(emi);
		} catch (CalculatorException e) {

			return ResponseEntity.badRequest().body(null);
		}
	}

}