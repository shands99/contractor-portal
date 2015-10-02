package org.jemco.contractorportal.contractor;

import javax.inject.Inject;

import org.jemco.contractorportal.contractor.dto.Company;
import org.jemco.contractorportal.contractor.dto.ContractorInfo;

public class ContractorServiceImpl implements ContractorService {

	private ContractorInfoRepository contractorRepo;
	
	@Inject
	public ContractorServiceImpl(ContractorInfoRepository contractorRepo) {
		super();
		this.contractorRepo = contractorRepo;
	}

	@Override
	public ContractorInfo getContractorInfoById(String in) {
		return contractorRepo.findByContractorInfoId(in);
	}

	@Override
	public Company getCompanyById(long in) {
		// TODO Auto-generated method stub
		return null;
	}

}
