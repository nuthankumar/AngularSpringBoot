package com.exide.sfcrm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.VendorTransaction;
@Repository

public interface VendorTransPageListRepository extends JpaRepository<VendorTransaction , Long> {
		public Page<VendorTransaction> findAll(Pageable pageable);
		 
	}

	

 
