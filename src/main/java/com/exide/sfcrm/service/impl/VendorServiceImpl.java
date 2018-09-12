package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.Vendor;
import com.exide.sfcrm.repository.VendorRepository;
import com.exide.sfcrm.service.VendorService;
/**
 * 
 * @author vasavivr
 *
 */
@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	

	@Override
	public List<Vendor> getVendorList() {
		List<Vendor> vendor = new ArrayList<>();
		vendor = vendorRepository.findAll();
		return vendor;
	}

	@Override
	public Vendor createVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return vendorRepository.saveAndFlush(vendor);
	}

}
