package com.cg.homeLoan.services;

import java.util.List;

import com.cg.homeLoan.Dto.HomeLoanOfferingDTO;




public interface HomeLoanOfferingService {

    List<HomeLoanOfferingDTO> getAllOfferings();

    HomeLoanOfferingDTO getOfferingById(Long offeringId);
}

