package com.exide.sfcrm.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.service.EmailAttachmentService;

/**
 * 
 * @author vasavivr
 *
 */
@Service
public class EmailAttachmentServiceImpl implements EmailAttachmentService {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(EmailAttachmentServiceImpl.class);
	@Autowired
	PropertyConstants propertyConstants;

	@Override
	public String emailAttach(MultipartFile file)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		String response = "";

		String localFilePath = propertyConstants.EMAIL_UPLOAD_FOLDER
				+ File.separator + file.getOriginalFilename();
		copyFileToLocalFolder(file, localFilePath);
		return response;

	}

	private String copyFileToLocalFolder(MultipartFile file,
			String localFilePath) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		if (file.isEmpty()) {
			LOGGER.info("Empty file ");
			return "Fail";

		} else {
			try {

				File localDir = new File(propertyConstants.EMAIL_UPLOAD_FOLDER);

				if (!localDir.exists()) {
					localDir.mkdir();
				}
				if (localDir.list().length > 0) {
					String[] files = localDir.list();
					for (int i = 0; i < localDir.list().length; i++) {
						File tempFile = new File(
								propertyConstants.EMAIL_UPLOAD_FOLDER
										+ File.separator + files[i]);
						tempFile.delete();
					}
				}

				try {
					byte[] bytes = file.getBytes();
					Path path = Paths.get(localFilePath);
					LOGGER.info("Copying uploaded file to local directory");
					Files.write(path, bytes);
				} catch (IOException ex) {

					LOGGER.error(
							"Exception while converting  : " + ex.getMessage(),
							ex);
					return "Fail";
				}

				LOGGER.info("File uploaded successfully");

			} catch (Exception e) {
				LOGGER.error("File upload failed : " + e.getMessage(), e);
				return "Fail";
			}

		}
		return "Success";

	}

	@Override
	public String emailAttachs(MultipartFile[] uploadfiles) {
		// TODO Auto-generated method stub

		String uploadedFileName = Arrays.stream(uploadfiles)
				.map(x -> x.getOriginalFilename())
				.filter(x -> !StringUtils.isEmpty(x))
				.collect(Collectors.joining(" , "));

		if (StringUtils.isEmpty(uploadedFileName)) {
			LOGGER.info("please select a file!");
			return "Pass";
		}
		try {

			saveUploadedFiles(Arrays.asList(uploadfiles));

		} catch (Exception e) {
			LOGGER.error("File upload failed : " + e.getMessage(), e);
			return "Fail";
		}

		LOGGER.info("File uploaded successfully");

		return "Success";
	}

	private String saveUploadedFiles(List<MultipartFile> files)
			throws IOException {
		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue;
			}
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(propertyConstants.EMAIL_UPLOAD_FOLDER
						+ file.getOriginalFilename());
				LOGGER.info("Copying uploaded file to local directory");
				Files.write(path, bytes);
			} catch (IOException ex) {

				LOGGER.error(
						"Exception while converting  : " + ex.getMessage(), ex);
				return "Fail";
			}

			LOGGER.info("File uploaded successfully");

		}

		return "Success";

	}
}
