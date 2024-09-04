package com.cg.homeLoan.services.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.homeLoan.Dto.LoanDTO;
import com.cg.homeLoan.Exception.ResourceNotFoundException;
import com.cg.homeLoan.entity.LoanOffer;
import com.cg.homeLoan.entity.User;
import com.cg.homeLoan.repo.LoanRepository;
import com.cg.homeLoan.repo.UserRepo;
import com.cg.homeLoan.services.LoanService;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;
    
    @Autowired
    private UserRepo userRepository;

    @Override
    public LoanOffer applyForLoan(LoanDTO loanDTO) throws ResourceNotFoundException {
        // Convert LoanDTO to Loan entity
        LoanOffer loan = new LoanOffer();
        
        // Set properties from DTO
        loan.setLoanNumber(loanDTO.getLoanNumber());  // Assuming LoanDTO has this field
        loan.setLoanAmount(loanDTO.getLoanAmount());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setNomineeDetails(loanDTO.getNomineeDetails());
        loan.setLoanTenure(loanDTO.getLoanTenure());
        loan.setRateOfInterest(loanDTO.getRateOfInterest());
        loan.setPrincipalOutstandingAmount(loanDTO.getPrincipalOutstandingAmount());
        loan.setOutstandingEMICount(loanDTO.getOutstandingEMICount());
        loan.setCreationDate(LocalDate.now());  // Set creation date to the current date

        // Set the User entity
        User user = userRepository.findById(loanDTO.getId())
                                  .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + loanDTO.getUserId()));
        loan.setUser(user);

        // Save to the repository
        return loanRepository.save(loan);
    }


    @Override
    public LoanOffer getLoanById(Long loanId) throws ResourceNotFoundException {
       
        Optional<LoanOffer> loan = loanRepository.findById(loanId);
        return loan.orElseThrow(() -> new ResourceNotFoundException("Loan not found with ID: " + loanId));
    }

    @Override
    public Optional<LoanOffer> getLoanByUserId(Long userId) {
        return loanRepository.findById(userId);
    }

    @Override
    public void updateLoan(LoanDTO loanDTO) throws ResourceNotFoundException {
        
        Optional<LoanOffer> existingLoanOpt = loanRepository.findById(loanDTO.getId());
        if (existingLoanOpt.isPresent()) {
            LoanOffer existingLoan = existingLoanOpt.get();
            
     
            existingLoan.setLoanNumber(loanDTO.getLoanNumber());
            existingLoan.setLoanAmount(loanDTO.getLoanAmount());
            existingLoan.setLoanType(loanDTO.getLoanType());
            existingLoan.setNomineeDetails(loanDTO.getNomineeDetails());
            existingLoan.setLoanTenure(loanDTO.getLoanTenure());
            existingLoan.setRateOfInterest(loanDTO.getRateOfInterest());
            existingLoan.setPrincipalOutstandingAmount(loanDTO.getPrincipalOutstandingAmount());
            existingLoan.setOutstandingEMICount(loanDTO.getOutstandingEMICount());
            existingLoan.setCreationDate(loanDTO.getCreationDate());

            
            User user = userRepository.findById(loanDTO.getUserId())
                                      .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + loanDTO.getUserId()));
            existingLoan.setUser(user);

            
            loanRepository.save(existingLoan);
        } else {
            throw new ResourceNotFoundException("Loan not found with ID: " + loanDTO.getId());
        }
    }


    @Override
    public void deleteLoan(Long loanId) throws ResourceNotFoundException  {
        // Find loan by ID
        Optional<LoanOffer> loan = loanRepository.findById(loanId);
        if (loan.isPresent()) {
            // Delete the loan from the repository
            loanRepository.deleteById(loanId);
        } else {
            throw new ResourceNotFoundException("Loan not found with ID: " + loanId);
        }
    }
}

