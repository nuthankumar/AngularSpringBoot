package com.exide.sfcrm.service;

import java.util.List;
import com.exide.sfcrm.model.Vendor;

/**
 * 
 * @author vasavivr
 *
 */


public interface VendorService {

	
	List<Vendor> getVendorList();

	Vendor updateVendor(Vendor vendor);

	Vendor createVendor(Vendor vendor);

	





}
