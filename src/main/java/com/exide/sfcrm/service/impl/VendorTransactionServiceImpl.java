package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.dto.VendorTransactionDto;
import com.exide.sfcrm.model.CostCenter;
import com.exide.sfcrm.model.VendorTransaction;
import com.exide.sfcrm.repository.Channel_TypeRepository;
import com.exide.sfcrm.repository.CostCenterRepository;
import com.exide.sfcrm.repository.VendorRepository;
import com.exide.sfcrm.repository.VendorTransPageListRepository;
import com.exide.sfcrm.repository.VendorTransactionRepository;
import com.exide.sfcrm.service.VendorTransactionService;

@Service
public class VendorTransactionServiceImpl implements VendorTransactionService {

	 @Autowired
	 private VendorTransactionRepository vendorTranscationRepository;
	 
	 @Autowired
	 private VendorRepository vendorRepository;
	 
	 @Autowired
	 private VendorTransPageListRepository vendorTransPageListRepository;
	 
	 @Autowired
	 private CostCenterRepository costCenterRepository;
	 
	 @Autowired
	 private Channel_TypeRepository channelRepository;
	 
	 
	  
	 @Override
		public List<VendorTransaction> getVendorTranscationList() {
			List<VendorTransaction> vendorTranscations = new ArrayList<>();
			vendorTranscations = (List<VendorTransaction>) vendorTranscationRepository.findAll();			
			return vendorTranscations;
		}
	 @Override
	 public Page<VendorTransaction> getVendorTranscationListPagination(Pageable pageable) {
		 return vendorTransPageListRepository.findAll(pageable);
	}
	
	 
	 @Override
	 public VendorTransaction save(VendorTransactionDto vendorTranscationDto) {
		 VendorTransaction transaction = new VendorTransaction();
		 //vendorTranscationDto=calculation(vendorTranscationDto);
		 BeanUtils.copyProperties(vendorTranscationDto, transaction);
		 CostCenter center= new CostCenter();
		 Integer costCenterId = vendorTranscationDto.getCostCenterId();
		 center.setCostCenterId(costCenterId);
		 transaction.setCostCenter(center);
		return vendorTranscationRepository.save(transaction);
	}
	 
	 private VendorTransactionDto calculation(VendorTransactionDto vendorTranscationDto) {
		 
		 System.out.println("vendorTranscation.getTax() ::::"+vendorTranscationDto.getTax());
		 System.out.println("vendorTranscation.getAmount()  ::::"+vendorTranscationDto.getAmount());
		Double taxAmount =(double) (vendorTranscationDto.getAmount()*Double.parseDouble(vendorTranscationDto.getTax())/100);
		Double netPay = taxAmount+vendorTranscationDto.getAmount();
		vendorTranscationDto.setNetPayable(netPay);

		System.out.println(netPay);

		return vendorTranscationDto;
	 }
	@Override
	public List<CostCenter> getCostCenterDetails() {
		return costCenterRepository.getCostCenterDetails();
	}
	@Override
	public String getChannelType(Integer costCenter) {
		return channelRepository.getChannelBasedOnCostCenter(costCenter);
	}


 


 

 
 }
