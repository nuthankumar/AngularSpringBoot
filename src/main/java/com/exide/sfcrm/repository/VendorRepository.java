package com.exide.sfcrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.Vendor;
/**
 * 
 * @author vasavivr
 *
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {



}
