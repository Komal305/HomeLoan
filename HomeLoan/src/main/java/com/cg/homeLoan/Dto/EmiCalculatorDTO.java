package com.cg.homeLoan.Dto;

public class EmiCalculatorDTO {
    private Double loanAmount;
    private Double rateOfInterest;
    private Integer loanTenure; // tenure in months
    
    
	public Double getLoanAmount() {
		return loanAmount;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public Integer getLoanTenure() {
		return loanTenure;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}
	
	

    
}
