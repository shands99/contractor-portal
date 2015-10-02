package org.jemco.contractorportal.contractor;

import org.jemco.contractorportal.contractor.dto.ContractorInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContractorInfoRepository extends MongoRepository<ContractorInfo, String>{

	ContractorInfo findByContractorInfoId(String id);
	
}
