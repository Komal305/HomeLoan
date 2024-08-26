package com.cg.homeLoan.Dto;

import java.time.LocalDate;

public class HomeLoanDto {
	 private Long loanId;
	    private String loanAccountNumber;
		private Double loanAmount;
	    private LocalDate loanCreationDate;
	    private String message;
	    
	    
	    public HomeLoanDto() {
			super();
	    }
	    
		public HomeLoanDto(Long loanId, String loanAccountNumber, Double loanAmount, LocalDate loanCreationDate,
				String message) {
			super();
			this.loanId = loanId;
			this.loanAccountNumber = loanAccountNumber;
			this.loanAmount = loanAmount;
			this.loanCreationDate = loanCreationDate;
			this.message = message;
		}
		public Long getLoanId() {
			return loanId;
		}
		public void setLoanId(Long loanId) {
			this.loanId = loanId;
		}
		public String getLoanAccountNumber() {
			return loanAccountNumber;
		}
		public void setLoanAccountNumber(String loanAccountNumber) {
			this.loanAccountNumber = loanAccountNumber;
		}
		public Double getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(Double loanAmount) {
			this.loanAmount = loanAmount;
		}
		public LocalDate getLoanCreationDate() {
			return loanCreationDate;
		}
		public void setLoanCreationDate(LocalDate loanCreationDate) {
			this.loanCreationDate = loanCreationDate;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	    
	    
	    

}
