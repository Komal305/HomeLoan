package com.cg.homeLoan.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_offers")
public class LoanOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String loanType;
    @Column(nullable = false)
    private String loanNumber;
    @Column(nullable = false)
    private BigDecimal loanAmount;
    @Column(nullable = false)
    private String nomineeDetails;
    @Column(nullable = false)
    private Integer loanTenure;
    @Column(nullable = false)
    private BigDecimal rateOfInterest;
    @Column(nullable = false)
    private BigDecimal principalOutstandingAmount;
    @Column(nullable = false)
    private Integer outstandingEMICount;
    @Column(nullable = false)
    private LocalDate creationDate;
    
    
    // Mapping to User entity with ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
