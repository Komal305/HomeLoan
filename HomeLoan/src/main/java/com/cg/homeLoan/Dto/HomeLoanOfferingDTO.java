package com.cg.homeLoan.Dto;

public class HomeLoanOfferingDTO {
	
	private Long loanId;
    private String loanType;
    private String LoanName;
	private double totalLoanAmount;
    private int loanTenure;
    private double rateOfInterest;
    private double principalOutstanding;
    private int outstandingEmiCount;
    
    
	public HomeLoanOfferingDTO() {
		super();
	}


	public HomeLoanOfferingDTO(Long loanId, String loanType, String loanName, double totalLoanAmount, int loanTenure,
			double rateOfInterest, double principalOutstanding, int outstandingEmiCount) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		LoanName = loanName;
		this.totalLoanAmount = totalLoanAmount;
		this.loanTenure = loanTenure;
		this.rateOfInterest = rateOfInterest;
		this.principalOutstanding = principalOutstanding;
		this.outstandingEmiCount = outstandingEmiCount;
	}


	public Long getLoanId() {
		return loanId;
	}


	public String getLoanType() {
		return loanType;
	}


	public String getLoanName() {
		return LoanName;
	}


	public double getTotalLoanAmount() {
		return totalLoanAmount;
	}


	public int getLoanTenure() {
		return loanTenure;
	}


	public double getRateOfInterest() {
		return rateOfInterest;
	}


	public double getPrincipalOutstanding() {
		return principalOutstanding;
	}


	public int getOutstandingEmiCount() {
		return outstandingEmiCount;
	}
	
	
}
