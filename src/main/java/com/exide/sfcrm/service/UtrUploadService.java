package com.exide.sfcrm.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.exide.sfcrm.model.TblPRFGeneratedCashView;
/**
 * 
 * @author vasavivr
 *
 */
public interface UtrUploadService {

	List<TblPRFGeneratedCashView> downloadUtrExcel(String prfNo, String uid) throws IOException;

	String uploadUtrDetails(MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException;

}
