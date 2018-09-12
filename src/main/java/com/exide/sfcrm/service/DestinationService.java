package com.exide.sfcrm.service;

import java.util.List;

import com.exide.sfcrm.model.Destination;
/**
 * 
 * @author vasavivr
 *
 */
public interface DestinationService {

	List<Destination> getDestinationPlace();

	Destination addDestinationPlace(Destination destination);


	Destination updateDestinationPlace(Destination destination);
}
