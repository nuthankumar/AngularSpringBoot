package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.Vendor;
import com.exide.sfcrm.model.VendorTransaction;

@Repository
public interface VendorTransactionRepository extends JpaRepository<VendorTransaction, String> {

	
	  @Query(value="select name from vendor",nativeQuery = true)
	  List<Vendor> findByName(String name);
	 
}
