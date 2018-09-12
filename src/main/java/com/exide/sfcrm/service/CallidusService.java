/**
 * 
 */
package com.exide.sfcrm.service;

/**
 * @author saurabhp
 *
 */
public interface CallidusService {

	/**
	 * 
	 * @return
	 */
	public boolean getDataIntoTables() throws Exception;
	
	public boolean callidusRun() throws Exception;
}
