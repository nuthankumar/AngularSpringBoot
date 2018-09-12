package com.exide.sfcrm.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;
import com.exide.sfcrm.model.TicketExcelView;


public interface TicketUploadService {
	/**
	 * This method is used to set the choice selected by the advisors for
	 * Contest type ticket.
	 * 
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public String uploadTicketDetails(MultipartFile filePath)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException;

	public List<TicketExcelView> downloadExcel(String userId)
			throws IOException, InvalidFormatException;

}
