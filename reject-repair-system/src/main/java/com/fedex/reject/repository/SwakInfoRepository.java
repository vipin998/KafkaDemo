package com.fedex.reject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.fedex.reject.model.SwakRepository;

@Repository

	public interface SwakInfoRepository extends CrudRepository<SwakRepository, Integer> {
		
	}
	
	

