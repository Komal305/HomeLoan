package com.cg.homeLoan.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "home_loans")
public class HomeLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String loanType;

    @Column(nullable = false)
    private Double loanAmount;

    @Column(nullable = false)
    private Integer loanTenure;
    
    @Column(nullable = false)
    private String loanAccountNumber;

    @Column(nullable = false)
    private Double rateOfInterest;

    @Column(nullable = false)
    private Double principalOutstandingAmount;

    @Column(nullable = false)
    private Integer outstandingEMICount;

    @OneToOne(mappedBy = "homeLoan", cascade = CascadeType.ALL)
    private NomineeDetails nomineeDetails;

    @OneToMany(mappedBy = "homeLoan", cascade = CascadeType.ALL)
    private List<LoanTracker> loanTrackers;

    @Temporal(TemporalType.DATE)
    private LocalDate loanCreationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Double getPrincipalOutstandingAmount() {
		return principalOutstandingAmount;
	}

	public void setPrincipalOutstandingAmount(Double principalOutstandingAmount) {
		this.principalOutstandingAmount = principalOutstandingAmount;
	}

	public Integer getOutstandingEMICount() {
		return outstandingEMICount;
	}

	public void setOutstandingEMICount(Integer outstandingEMICount) {
		this.outstandingEMICount = outstandingEMICount;
	}

	public NomineeDetails getNomineeDetails() {
		return nomineeDetails;
	}

	public void setNomineeDetails(NomineeDetails nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}

	public List<LoanTracker> getLoanTrackers() {
		return loanTrackers;
	}

	public void setLoanTrackers(List<LoanTracker> loanTrackers) {
		this.loanTrackers = loanTrackers;
	}

	public LocalDate getLoanCreationDate() {
		return loanCreationDate;
	}

	public void setLoanCreationDate(LocalDate loanCreationDate) {
		this.loanCreationDate = loanCreationDate;
	}

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public HomeLoan(Long id, User user, String loanType, Double loanAmount, Integer loanTenure,
			String loanAccountNumber, Double rateOfInterest, Double principalOutstandingAmount,
			Integer outstandingEMICount, NomineeDetails nomineeDetails, List<LoanTracker> loanTrackers,
			LocalDate loanCreationDate) {
		super();
		this.id = id;
		this.user = user;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanTenure = loanTenure;
		this.loanAccountNumber = loanAccountNumber;
		this.rateOfInterest = rateOfInterest;
		this.principalOutstandingAmount = principalOutstandingAmount;
		this.outstandingEMICount = outstandingEMICount;
		this.nomineeDetails = nomineeDetails;
		this.loanTrackers = loanTrackers;
		this.loanCreationDate = loanCreationDate;
	}

	@Override
	public String toString() {
		return "HomeLoan [id=" + id + ", user=" + user + ", loanType=" + loanType + ", loanAmount=" + loanAmount
				+ ", loanTenure=" + loanTenure + ", loanAccountNumber=" + loanAccountNumber + ", rateOfInterest="
				+ rateOfInterest + ", principalOutstandingAmount=" + principalOutstandingAmount
				+ ", outstandingEMICount=" + outstandingEMICount + ", nomineeDetails=" + nomineeDetails
				+ ", loanTrackers=" + loanTrackers + ", loanCreationDate=" + loanCreationDate + "]";
	}

  
	    
		
	    
	    
}
