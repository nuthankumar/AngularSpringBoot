package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.model.Destination;
import com.exide.sfcrm.repository.DestinationRepository;
import com.exide.sfcrm.service.DestinationService;

/**
 * 
 * @author vasavivr
 *
 */
@Service
public class DestinationServiceImpl implements DestinationService{
	
	@Autowired
	DestinationRepository destinationRepository;

	@Override
	public List<Destination> getDestinationPlace() {
		List<Destination> destinations=new ArrayList<Destination>();
		destinationRepository.findAll().forEach(e->destinations.add(e));
		return destinations;
	}

	@Override
	public Destination addDestinationPlace(Destination destination) {

		return destinationRepository.save(destination);
	}

	@Override
	public Destination updateDestinationPlace(Destination destination) {

		return destinationRepository.saveAndFlush(destination);
	}

}









