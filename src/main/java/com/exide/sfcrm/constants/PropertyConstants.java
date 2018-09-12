 /**
 * 
 */
package com.exide.sfcrm.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author neethub
 *
 */
@Configuration
public class PropertyConstants {
	
	@Value("${server.contextPath}")
	public String PAGE_CONTEXT ;
	
	@Value("${sfcrm.pagelimit}")
	public Integer PAGE_LIMIT ;
	
	@Value("${app.contextPath}")
	public String APP_CONTEXT ;
	
	@Value("${smtp.server.url}")
	public String SMTP_SERVER_URL ;
	
	@Value("${smtp.server.port}")
	public String SMTP_SERVER_PORT;
	
	@Value("${smtp.server.auth}")
	public String SMTP_SERVER_AUTH;
	
	@Value("${smtp.server.from}")
	public String SMTP_SERVER_FROM_ADDRESS ;
	
	@Value("${smtp.server.username}")
	public String SMTP_SERVER_USERNAME ;
	
	@Value("${smtp.server.password}")
	public String SMTP_SERVER_PASSWORD ;
	
	@Value("${mail.subject}")
	public String MAIL_SUBJECT ;
	
	@Value("${mail.body}")
	public String MAIL_BODY ;
	
	@Value("${ldap.default.user}")
	public String LDAP_DEFAULT_USER;
	
	@Value("${ldap.default.password}")
	public String LDAP_DEFAULT_PASSWORD;
	
	@Value("${ldap.domain.name}")
	public String LDAP_DOMAIN_NAME;
	
	@Value("${ldap.port}")
	public String LDAP_PORT;
	
	@Value("${app.static.path}")
	public String APP_STATIC_PATH;
	
	@Value("${sfcrm.ticket.loadDate.format}")
	public String TICKET_LOAD_DATE_FORMAT;
	
	@Value("${sfcrm.ticket.uploadFolder}")
	public String TICKET_UPLOAD_FOLDER;
	
	@Value("${sfcrm.ticket.downloadFolder}")
	public String TICKET_DOWNLOAD_FOLDER;
	
	@Value("${sfcrm.utr.uploadFolder}")
	public String UTR_UPLOAD_FOLDER;
	
	@Value("${sfcrm.utr.downloadFolder}")
	public String UTR_DOWNLOAD_FOLDER;
	
	
	@Value("${sfcrm.email.uploadFolder}")
	public String EMAIL_UPLOAD_FOLDER;
	
	@Value("${ldap.server}")
	public String LDAP_SERVER;
}
