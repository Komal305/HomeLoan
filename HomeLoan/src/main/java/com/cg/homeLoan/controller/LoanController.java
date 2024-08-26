package com.cg.homeLoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.homeLoan.Dto.HomeLoanDto;
import com.cg.homeLoan.Dto.LoanDTO;
import com.cg.homeLoan.Exception.ResourceNotFoundException;
import com.cg.homeLoan.entity.Loan;
import com.cg.homeLoan.entity.Users;
import com.cg.homeLoan.repo.UserRepo;
import com.cg.homeLoan.services.HomeLoanTrackerService;
import com.cg.homeLoan.services.LoanService;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private HomeLoanTrackerService homeLoanTrackerService;

	@GetMapping("/user/userloan")
	public ResponseEntity<List<HomeLoanDto>> getUserLoans(Authentication authentication) {
		String username = authentication.getName();

		Users user = userRepo.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

		List<HomeLoanDto> loans = homeLoanTrackerService.getLoansByUsersId(user.getId());
		return ResponseEntity.ok(loans);
	}

	@GetMapping("/user/{loanId}")
	public ResponseEntity<HomeLoanDto> getLoanDetails(@PathVariable Long loanId) {
		HomeLoanDto loanDetails = homeLoanTrackerService.getLoanDetails(loanId);
		return ResponseEntity.ok(loanDetails);
	}

	@PostMapping("/auth/loan/apply") // checked
	public String applyForLoan(@RequestBody LoanDTO loanDTO, Model model) throws ResourceNotFoundException {
		Loan newLoan = loanService.applyForLoan(loanDTO);
		model.addAttribute("loan", newLoan);
		model.addAttribute("message", "Loan application submitted successfully!");
		return "success";
	}

	@GetMapping("/user/loan/{loanId}") // checked
	public ResponseEntity<Loan> getLoanById(@PathVariable Long loanId) throws ResourceNotFoundException {
		Loan loan = loanService.getLoanById(loanId);
		return ResponseEntity.ok(loan);
	}

	@GetMapping("/user/{userId}") // checked
	public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable Long userId) throws ResourceNotFoundException {
		List<Loan> loans = loanService.getLoansByUserId(userId);
		return ResponseEntity.ok(loans);
	}

	@PutMapping("/admin/update") // checked
	public ResponseEntity<Void> updateLoan(@RequestBody LoanDTO loanDTO) throws ResourceNotFoundException {
		loanService.updateLoan(loanDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/admin/{loanId}") // checked
	public ResponseEntity<Void> deleteLoan(@PathVariable Long loanId) throws ResourceNotFoundException {
		loanService.deleteLoan(loanId);
		return ResponseEntity.noContent().build();
	}
}
