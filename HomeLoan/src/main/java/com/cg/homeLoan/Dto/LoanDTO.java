package com.cg.homeLoan.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanDTO {

	private Long id;
    private String loanType;
    private String loanNumber;
    private BigDecimal loanAmount;
    private String nomineeDetails;
    private Integer loanTenure;
    private BigDecimal rateOfInterest;
    private BigDecimal principalOutstandingAmount;
    private Integer outstandingEMICount;
    private LocalDate creationDate;
    private Long userId;

    // Constructors
    public LoanDTO() {}

    public LoanDTO(Long id, String loanType, String loanNumber, BigDecimal loanAmount, String nomineeDetails,
                        Integer loanTenure, BigDecimal rateOfInterest, BigDecimal principalOutstandingAmount,
                        Integer outstandingEMICount, LocalDate creationDate, Long userId) {
        this.id = id;
        this.loanType = loanType;
        this.loanNumber = loanNumber;
        this.loanAmount = loanAmount;
        this.nomineeDetails = nomineeDetails;
        this.loanTenure = loanTenure;
        this.rateOfInterest = rateOfInterest;
        this.principalOutstandingAmount = principalOutstandingAmount;
        this.outstandingEMICount = outstandingEMICount;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getNomineeDetails() {
        return nomineeDetails;
    }

    public void setNomineeDetails(String nomineeDetails) {
        this.nomineeDetails = nomineeDetails;
    }

    public Integer getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(Integer loanTenure) {
        this.loanTenure = loanTenure;
    }

    public BigDecimal getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(BigDecimal rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public BigDecimal getPrincipalOutstandingAmount() {
        return principalOutstandingAmount;
    }

    public void setPrincipalOutstandingAmount(BigDecimal principalOutstandingAmount) {
        this.principalOutstandingAmount = principalOutstandingAmount;
    }

    public Integer getOutstandingEMICount() {
        return outstandingEMICount;
    }

    public void setOutstandingEMICount(Integer outstandingEMICount) {
        this.outstandingEMICount = outstandingEMICount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	// ToString method
    @Override
    public String toString() {
        return "LoanDTO{" +
                "id=" + id +
                ", loanNumber='" + loanNumber + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanType='" + loanType + '\'' +
                ", nomineeDetails='" + nomineeDetails + '\'' +
                ", loanTenure=" + loanTenure +
                ", rateOfInterest=" + rateOfInterest +
                ", principalOutstandingAmount=" + principalOutstandingAmount +
                ", outstandingEMICount=" + outstandingEMICount +
                ", creationDate=" + creationDate +
                ", userId=" + userId +
                '}';
    }
}
