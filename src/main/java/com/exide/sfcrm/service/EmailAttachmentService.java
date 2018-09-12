package com.exide.sfcrm.service;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author vasavivr
 *
 */
public interface EmailAttachmentService {

	public	String emailAttach(MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException;

	public String emailAttachs(MultipartFile[] uploadfiles);

}
